<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>로그인 페이지</title>
</head>

<body onload="document.f.id.focus();">

<h3>회원 정보 수정</h3>

<c:url value="/member/update" var="updateUrl" />
<p>${updateUrl}</p>

<!-- http://localhost:8282/login?error -->

<form:form name="f" action="${updateUrl}" method="POST">
    <p>Email : <sec:authentication property="principal.username"/></p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/>
    </p>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <button type="submit" class="btn">수정</button>
</form:form>

</body>
</html>