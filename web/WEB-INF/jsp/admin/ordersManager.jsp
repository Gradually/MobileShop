<%--
  Created by IntelliJ IDEA.
  User: WuYuchen
  Date: 2017/11/21
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="myel" uri="/myel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>订单管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${pageContext.request.contextPath}/css/mobileshop-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
    <!-- Page Specific CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/morris-0.4.3.min.css">
</head>
<body>
<div id="wrapper">
    <jsp:include page="top.jsp"></jsp:include>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-striped table-hover table-condensed table-bordered col-lg-12" align="center" >
                    <caption>
                        <h2>订单管理</h2>
                    </caption>
                    <thead>
                    <tr bgcolor="#a9a9a9" align="center">
                        <th class="col-lg-1">订单ID</th>
                        <th class="col-lg-2">商品名称</th>
                        <th class="col-lg-2">购买用户</th>
                        <th class="col-lg-1">购买数量</th>
                        <th class="col-lg-1">订单金额(¥)</th>
                        <th class="col-lg-2">添加时间</th>
                        <th class="col-lg-1">订单状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.pageBean.list}" var="ordersBean">
                        <tr>
                            <td>${ordersBean.oid}</td>
                            <td>${ordersBean.productBean.productName}</td>
                            <td>${ordersBean.user.username}</td>
                            <td>${ordersBean.quantity}</td>
                            <td>${myel:priceTwoDecimal(ordersBean.payable)}</td>
                            <td>${ordersBean.createTime}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${ordersBean.state == 0}">
                                        <span class="btn btn-link disabled">未收货</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="btn btn-link disabled">交易完成</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <c:if test="${myel:checkRow(requestScope.pageBean)}">
            <div class="row text-center">
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.previousPage}">
                            <li><a href="${pageContext.request.contextPath }/ordersManager.admin?currentPage=${requestScope.pageBean.previousPage}" >上一页</a></li>
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
                                <li><a href="${pageContext.request.contextPath }/ordersManager.admin?currentPage=${pagenum}">${pagenum }</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.nextPage}">
                            <li><a href="${pageContext.request.contextPath }/ordersManager.admin?currentPage=${pageBean.nextPage}" >下一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled"><a href="javascript:void(0)" >下一页</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </c:if>
    </div>
</div>
<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Page Specific Plugins -->
<script src="${pageContext.request.contextPath}/js/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/js/morris-0.4.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/morris/chart-data-morris.js"></script>
<script src="${pageContext.request.contextPath}/js/tablesorter/jquery.tablesorter.js"></script>
<script src="${pageContext.request.contextPath}/js/tablesorter/tables.js"></script>
<script>
    $(document).ready(function () {
        $(".now-choose > li").eq(2).addClass("active");
    });
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
