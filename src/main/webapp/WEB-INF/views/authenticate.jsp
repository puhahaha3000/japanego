<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>인증안됨</h1>
<h1>로그인 이메일 : ${email}</h1
<c:url value="/member/auth" var="authenticateUrl" />>
<form:form name="f" action="${authenticateUrl}" method="POST">
    <input type="hidden" name="memberNo" value="${memberNo}">
    <input type="hidden" name="email" value="${email}">
    <p>
        <label for="auth_code">인증 코드</label>
        <input type="text" id="auth_code" name="no" />
    </p>
    <%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <button type="submit" class="btn">제출</button>
</form:form>
</body>
</html>
