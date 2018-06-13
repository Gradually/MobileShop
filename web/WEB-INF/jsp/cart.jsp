<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="/myel" prefix="myel"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>购物车</title>
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

<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/index.do">主页</a></li>
                    <li><font color="black">购物车</font></li>
                </ul>
            </div>
        </div>
        <c:if test="${empty(cartBeanList)}">
            <h1>亲,您的购物车里没有东西咧!</h1>
        </c:if>
        <c:forEach items="${requestScope.cartBeanList}" var="cartBean">
            <div class="row">
                <div class="product well">
                    <div class="col-md-3">
                        <div class="image">
                            <img src="${pageContext.request.contextPath}/images/product/${cartBean.pid}/main/1.jpg" />
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="caption">
                            <div class="name"><h3><a href="${pageContext.request.contextPath}/product.do?pid=${cartBean.pid}">${cartBean.productBean.productName}</a></h3></div>
                            <div class="info">
                                <ul>
                                    <li>商品品牌: ${cartBean.productBean.brand}</li>
                                    <li>商品ID: ${cartBean.pid}</li>
                                    <li>剩余库存: ${cartBean.productBean.stock}</li>
                                </ul>
                            </div>
                            <div class="price">¥${myel:priceTwoDecimal(cartBean.payable)}</div>
                            <label>商品数量: </label> <input maxlength="3" onblur="checkQuantity(${cartBean.quantity},this,${cartBean.productBean.stock},${cartBean.cid},${cartBean.pid})" class="form-inline quantity" type="text" value="${cartBean.quantity}">
                            <hr>
                            <a href="${pageContext.request.contextPath}/removecart.do?cid=${cartBean.cid}" class="btn btn-default pull-right">删除</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </c:forEach>
        <div class="row">
            <div class="pricedetails">
                <div class="col-md-4 col-md-offset-9">
                    <table>
                        <h6>应付款金额</h6>
                        <tr style="border-top: 1px solid #333;border-bottom: 1px solid #333;">
                            <td><h5>总计</h5></td>
                            <td id="paysum"></td>
                        </tr>
                    </table>
                    <br>
                    <c:choose>
                        <c:when test="${empty(cartBeanList)}">
                            <center><a href="javascript:void(0)" class="btn btn-1 disabled">付款</a></center>
                        </c:when>
                        <c:otherwise>
                            <center><a href="javascript:void(0)" onclick="payMoney()" class="btn btn-1">付款</a></center>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>
</div>

<%--footer--%>
<%@include file="footer.jsp"%>
<script>
    var checkQuantity = function(count,obj,stock,cid,pid) {
        var quantity = $(obj).val();
        if(count == quantity) {
            return;
        }
        if(isNaN(quantity) || quantity <= 0) {
            $(obj).val(count);
            return;
        }
        if(quantity > stock) {
            alert("库存不足!!");
            $(obj).val(count);
            return;
        }
        if(window.confirm("您确认修改吗?")) {
            window.location.href = "${pageContext.request.contextPath}/updatecart.do?quantity=" + quantity + "&cid=" + cid + "&pid=" + pid;
        }
    };

    var sum = 0;
    $(document).ready(function () {
        $(".price").each(function () {
            sum = sum + parseInt($(this).text().substring(1));
        });
        $("#paysum").text("¥" + sum);
    });

    var payMoney = function () {
        if (sum > parseInt(${sessionScope.user.money})) {
            alert("亲,很抱歉,您账户余额不足,无法购买这么多商品!");
        } else{
            if(window.confirm("确定购买吗?")) {
                window.location.href = "${pageContext.request.contextPath}/pay.do?sum=" + sum;
            }
        }

    }
</script>
</body>
</html>
