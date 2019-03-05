<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Luck Of Today</title>
</head>
<body>
<h1>
	<img src="resources/images/unsetitle.jpg">
	<br>
	당신의 하루 운세가 궁금하시다면!  <br>
	If you are curious about your Luck Of Today!<br>
</h1>

<!-- user 정보가 없다면 -->
<c:if test="${empty user}">
	<p>Welcome! You Need to Input your Individual Information </p>
	<a href="${cp}/user/loginUser">INPUT</a> &nbsp;&nbsp; 
</c:if>

<!-- user 정보가 있다면 -->
<c:if test="${!empty user}">
	<p>Welcome! ${user.userName}. You can check Luck Of Today </p>
	<a href="${cp}/luck/inquiryLuck">INQUIRY</a> &nbsp;&nbsp; 
</c:if>









<P> Access Time  ${serverTime}. </P>
</body>
</html>
