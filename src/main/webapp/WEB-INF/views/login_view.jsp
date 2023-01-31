<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>로그인 페이지</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    function getToken() {
        $.ajax({
            url: 'authenticate',
            async: true,
            type: 'POST',
            data: $("form[name=loginForm]").serialize(),
            dataType: 'json',
            error: function (xhr, status, error) {
                alert(error);
            },
            success: function (json) {
                console.log(json.token);
                localStorage.setItem("Authorization", json.token);
                location.href = "/japanego";
            }
        });
    }
</script>
<body>

<h3>아이디와 비밀번호를 입력해주세요.</h3>

<c:url value="/login" var="loginUrl"/>
<p>${loginUrl}</p>

<form:form name="loginForm" action="${loginUrl}" method="POST">
    <c:if test="${param.error != null}">
        <p>아이디와 비밀번호가 잘못되었습니다.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>로그아웃 하였습니다.</p>
    </c:if>
    <p>
        <label for="email">이메일</label>
        <input type="text" id="email" name="email"/>
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/>
    </p>
    <%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <input type="button" onclick="getToken()" value="로그인">
</form:form>

</body>
</html>