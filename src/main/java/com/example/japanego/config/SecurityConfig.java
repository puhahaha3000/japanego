package com.example.japanego.config;

import com.example.japanego.security.MemberDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MemberDetailService memberDetailService;

    public SecurityConfig(MemberDetailService memberDetailService) {
        this.memberDetailService = memberDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeHttpRequests()
            .antMatchers("/user/**").hasAnyRole("USER")
            .antMatchers("/**").permitAll()
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .usernameParameter("email")
            .failureHandler(((request, response, exception) -> {
                if (exception instanceof DisabledException) {
                    request.setAttribute("email", request.getAttribute("email"));
                    request.getRequestDispatcher("/member/authenticate").forward(request, response);
                } else if (exception instanceof LockedException) {
                    request.getRequestDispatcher("/deleted_account").forward(request, response);
                } else {
                    response.sendRedirect("/japanego/login_view");
                }
            }))
        .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
