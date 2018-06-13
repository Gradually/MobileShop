<%--
  Created by IntelliJ IDEA.
  User: WuYuchen
  Date: 2017/10/29
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆消息显示</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/font-slider.css" type="text/css">
    <!-- jQuery and Modernizr-->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>


    <style>
        .Message {
            width: 500px;
            height: 500px;
            position: relative;
            left: 50%;
            margin-left: -250px;
        }
    </style>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="Message">
    <c:choose>
        <c:when test="${empty(isOK)}">
            <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/login.do">
            <h2>${requestScope.message}</h2>
            三秒后将自动跳转,如果<span>3</span>秒后没有跳转,请点击<a href="${pageContext.request.contextPath}/login.do" class="label-danger">这里</a>手动跳转到登陆界面
        </c:when>
        <c:otherwise>
            <h2>${requestScope.isOK}</h2>
            <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.do">
            三秒后将自动跳转,如果<span>3</span>秒后没有跳转,请点击<a href="${pageContext.request.contextPath}/index.do" class="label-danger">这里</a>手动跳转到主页
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>
