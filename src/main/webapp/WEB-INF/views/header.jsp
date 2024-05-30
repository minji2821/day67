<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${cpath }/resources/css/style.css" rel="stylesheet">
</head>
<body>
  <h1>${cpath }</h1>

  <ul class="menu">
    <li><a href="${cpath }">home</a></li>
    <li><a href="${cpath }/board">board</a></li>
    <li><a href="${cpath }/account">account</a></li>
    
    <c:if test="${empty user }">
    <li><a href="${cpath }/account/login">login</a></li>
    <li><a href="${cpath }/account/signUp">SignUp</a></li>
    </c:if>
    
      <c:if test="${not empty user }">
        <li><a href="${cpath }/account/mypage">${user.nick }님</a></li>
        <li><a href="${cpath }/account/logout">logout</a></li>
      </c:if>
    
  </ul>
  
  <hr>