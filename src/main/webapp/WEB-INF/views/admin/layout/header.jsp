<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="Ko-kr">
<head>
<meta charset="UTF-8">
<title>Flow</title>
<style type="text/css">
	
</style>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
	<div align="center">
	<h2>Flow admin</h2>
		<div class="header">
 			<c:choose>
				<c:when test="${!empty login }">
					<a href="${pageContext.request.contextPath }/admin/login/logout">Logout</a> | 
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/admin/login/loginForm">Login</a> | 
					<a href="${pageContext.request.contextPath }/admin/member/joinForm">Join</a> | 
				</c:otherwise>
			</c:choose>
			<a href="${pageContext.request.contextPath }">Home</a>
		</div>
		<div class="main">
