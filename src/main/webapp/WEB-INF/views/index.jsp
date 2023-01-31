<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
Index Page<br>
<script type="text/javascript">
  const token = localStorage.getItem("Authorization");
  console.log(token);
  let isAnonymous = false;
  if (token.length > 0) {
    try {
      jwt = JSON.parse(atob(token.split('.')[1]));
      console.log(jwt);
      isAnonymous = true;
      console.log('my id: ' + jwt.sub);
      // ^^ have a look at your jwt token- I only guess it's jwt.id
    } catch (e) {
      console.log('error: ' + e);
    }
  }
</script>
<sec:authorize access="isAnonymous()">
  [<a href="<c:url value="/login_view" />">로그인</a>]
  [<a href="<c:url value="/sign_up_view"/>">회원가입</a>]
  [<a href="<c:url value="/password_reset_view"/>">비밀번호 초기화</a>]
</sec:authorize>

<sec:authorize access="isAuthenticated()">
  <p>principal: <sec:authentication property="principal"/></p>
  <p>principal: <sec:authentication property="principal.username"/> 님 환영합니다</p>
  [<a href="<c:url value="/member/update_view"/>">정보 수정</a>]<br>
  [<a href="<c:url value="/logout"/>">로그아웃</a>]<br>
  [<a href="<c:url value="/first_quiz"/>">첫 퀴즈</a>]<br>
  [<a href="<c:url value="/member/delete"/>">회원 탈퇴</a>]
</sec:authorize>
</body>
</html>