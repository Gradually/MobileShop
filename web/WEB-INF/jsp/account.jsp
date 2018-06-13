<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/17
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>我的账户</title>
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
    <style>
        td,th {
            text-align:center;
            vertical-align:middle;
            overflow: hidden;
        }
    </style>
</head>
<body>

<nav id="top">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-xs-6">
                <ul class="top-left">
                    <li class="top_cart_div" style="display: none;">
                        <a href="${pageContext.request.contextPath}/cart.do?uid=${sessionScope.user.uid}" class="btn btn-success"><span
                                class="glyphicon glyphicon-shopping-cart"></span>&nbsp;购物车</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/contact.do" class="btn btn-primary"><span
                                class="glyphicon glyphicon-phone-alt"></span>&nbsp;联系我们</a>
                    </li>
                </ul>
            </div>
            <div class="col-xs-6 col-sm-6">
                <ul class="top-link">
                    <li><span>欢迎您 : ${user.username} &nbsp;</span></li>
                    <li><a href="${pageContext.request.contextPath}/cancel.do" class="btn btn-danger"><span
                            class="glyphicon glyphicon-asterisk"></span>&nbsp;注销</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!--Header-->
<header class="container">
    <div class="row header_row">
        <div class="col-md-4">
            <div id="logo"><img src="${pageContext.request.contextPath}/images/logo.png"/></div>
        </div>
        <div class="col-md-4">
            <form class="form-search">
                <input type="text" class="input-medium search-query">
                <button type="submit" class="btn" style="background-color:#393939;"><span
                        class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="col-md-4">
            <div id="cart"><a class="btn btn-1" href="${pageContext.request.contextPath}/cart.do?uid=${sessionScope.user.uid}"><span
                    class="glyphicon glyphicon-shopping-cart"></span>购物车</a></div>
        </div>
    </div>
</header>
<!--Navigation-->
<nav id="menu" class="navbar">
    <div class="container">
        <div class="navbar-header"><span id="heading" class="visible-xs">导航</span>
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/index.do">主页</a></li>
                <li class="active"><a href="#description" data-toggle="tab">我的订单</a></li>
                <li><a href="#review" data-toggle="tab">我的收藏</a></li>
                <li><a href="javascript:void(0)">我的余额: </a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="account-info">
    <div class="container">
        <div class="row">
            <div class="tab-content col-lg-12">
                <div id="description" class="tab-pane active table-responsive">
                    <table class="table table-striped table-hover table-condensed table-bordered col-lg-12" align="center" >
                        <thead>
                            <tr bgcolor="#a9a9a9" align="center">
                                <th class="col-lg-2">订单号</th>
                                <th class="col-lg-5">商品名称</th>
                                <th class="col-lg-1">购买数量</th>
                                <th class="col-lg-2">付款金额</th>
                                <th class="col-lg-2">状态</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>52448312757472</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>4</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>4</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>4</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="review" class="tab-pane fade">
                    <div>bbb</div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--footer--%>
<%@include file="footer.jsp"%>
</body>
</html>
