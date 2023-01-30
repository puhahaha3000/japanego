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
<c:forEach items="${header}" var="item">
  ${item.key}: ${item.value}<br>
</c:forEach>
${header.get("Authorization")}
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