<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>패스워드 초기화 요청</title>
</head>
<body>
<h3>패스워드 초기화 요청</h3>

<c:url value="/member/send_reset_mail" var="resetUrl" />
<p>${resetUrl}</p>

<!-- http://localhost:8282/login?error -->

<form:form name="f" action="${resetUrl}" method="POST">
    <p>
        <label for="email">Email</label>
        <input type="text" id="email" name="email"/>
    </p>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <button type="submit" class="btn">메일 발송</button>
</form:form>

</body>
</html>