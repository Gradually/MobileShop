<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/17
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/myel" prefix="myel"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>商品清单</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"  type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">


    <!-- Custom Fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/font-slider.css" type="text/css">
    <!-- jQuery and Modernizr-->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>

</head>
<body>
<%--top--%>
<jsp:include page="top.jsp"></jsp:include>

<!--//////////////////////////////////////////////////-->
<!--///////////////////Category Page//////////////////-->
<!--//////////////////////////////////////////////////-->
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="index.do">主页</a></li>
                    <li><a href="${pageContext.request.contextPath}/category.do">智能手机</a></li>
                    <c:if test="${!empty(requestScope.brand)}">
                        <li><a href="javascript:void(0)">${requestScope.brand}</a></li>
                    </c:if>
                </ul>
            </div>
        </div>

        <div class="row">
            <div id="main-content" class="col-md-12">
                <c:forEach items="${requestScope.pageBean.list}" var="c" varStatus="b">
                    <c:if test="${b.count % 4 == 1}">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="products">
                    </c:if>
                                    <div class="col-lg-3 col-md-3 col-xs-12">
                                        <div class="product">
                                            <div class="image"><a href="${pageContext.request.contextPath}/product.do?pid=${c.pid}"><img src="${pageContext.request.contextPath}/images/product/${c.pid}/main/1.jpg" /></a></div>
                                            <div class="caption">
                                                <div class="name"><h3><a href="${pageContext.request.contextPath}/product.do?pid=${c.pid}">${c.productName}</a></h3></div>
                                                <div class="price">¥${myel:priceTwoDecimal(c.price)}</div>
                                            </div>
                                        </div>
                                    </div>
                    <c:if test="${b.count % 4 == 0 }">
                                </div>
                            </div>
                        </div>
                    </c:if>

                </c:forEach>
                <c:if test="${requestScope.pageBean.currentPage != requestScope.pageBean.nextPage}">
                            </div>
                        </div>
                    </div>
                </c:if>
                <div class="row text-center">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.previousPage}">
                                <li><a href="${pageContext.request.contextPath }/category.do?currentPage=${requestScope.pageBean.previousPage}&brand=${requestScope.brand}" >上一页</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="disabled"><a href="javascript:void(0)" >上一页</a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="pagenum" items="${requestScope.pageBean.pageBar }">
                            <c:choose>
                                <c:when test="${pagenum==requestScope.pageBean.currentPage }">
                                    <li class="active"><a href="javascript:void(0)" class="currentPage">${pagenum }</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageContext.request.contextPath }/category.do?currentPage=${pagenum}&brand=${requestScope.brand}">${pagenum }</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.nextPage}">
                                <li><a href="${pageContext.request.contextPath }/category.do?currentPage=${pageBean.nextPage}&brand=${requestScope.brand}" >下一页</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="disabled"><a href="javascript:void(0)" >下一页</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%--footer--%>
<%@include file="footer.jsp"%>
</body>
</html>
