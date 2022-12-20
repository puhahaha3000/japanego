<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>로그인 페이지</title>
</head>

<body onload="document.f.id.focus();">

<h3>아이디와 비밀번호를 입력해주세요.</h3>

<c:url value="/sign_up" var="signUpUrl" />
<p>${signUpUrl}</p>

<!-- http://localhost:8282/login?error -->

<form:form name="f" action="${signUpUrl}" method="POST">
    <p>
        <label for="email">이메일</label>
        <input type="text" id="email" name="email" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/>
    </p>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <button type="submit" class="btn">로그인</button>
</form:form>

</body>
</html>