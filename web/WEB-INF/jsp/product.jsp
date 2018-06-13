<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/17
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/myel" prefix="myel"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>${requestScope.productBean.productName}</title>
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

</head>
<body>
<!--top-->
<jsp:include page="top.jsp"></jsp:include>

<!--productPage-->
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/index.do">主页</a></li>
                    <li><a href="${pageContext.request.contextPath}/category.do">智能手机</a></li>
                    <li><a href="${pageContext.request.contextPath}/category.do?brand=${requestScope.productBean.brand}">${requestScope.productBean.brand}</a></li>
                    <li><a href="javascript:void(0)">${requestScope.productBean.productName}</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div id="main-content" class="col-md-8">
                <div class="product">
                    <div class="col-md-6">
                        <div class="image">
                            <img class="image-main" src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/main/1.jpg" />
                            <div class="image-more">
                                <ul class="row" id="image">
                                    <li class="col-lg-3 col-sm-3 col-xs-4">
                                        <a href="javascript:void(0)"><img class="img-responsive" src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/main/1.jpg"></a>
                                    </li>
                                    <li class="col-lg-3 col-sm-3 col-xs-4">
                                        <a href="javascript:void(0)"><img class="img-responsive" src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/main/2.jpg"></a>
                                    </li>
                                    <li class="col-lg-3 col-sm-3 col-xs-4">
                                        <a href="javascript:void(0)"><img class="img-responsive" src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/main/3.jpg"></a>
                                    </li>
                                    <li class="col-lg-3 col-sm-3 col-xs-4">
                                        <a href="javascript:void(0)"><img class="img-responsive" src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/main/4.jpg"></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="caption">
                            <div class="name"><h3>${requestScope.productBean.productName}</h3></div>
                            <div class="info">
                                <ul>
                                    <li style="margin-top: 10px">品牌: ${requestScope.productBean.brand}</li>
                                    <li style="margin-top: 10px">商品ID: ${requestScope.productBean.pid}</li>
                                </ul>
                            </div>
                            <div class="price" style="margin-top: 10px;"><h4>¥${myel:priceTwoDecimal(requestScope.productBean.price)}</h4></div>
                            <div class="rating" style="margin-top: 10px">库存:&nbsp; ${requestScope.productBean.stock}&nbsp; 件</div>
                            <c:choose>
                                <c:when test="${myel:CollectionExist(sessionScope.user.list, requestScope.productBean.pid)}">
                                    <a href="javascript:void(0)" class="btn btn-success disabled" style="margin-top: 10px;">商品已收藏</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/addcollection.do?pid=${requestScope.productBean.pid}&uid=${sessionScope.user.uid}"
                                       class="btn btn-default" style="margin-top: 10px;">收藏</a>
                                </c:otherwise>
                            </c:choose>
                            <form onsubmit="return a()" action="${pageContext.request.contextPath}/addcart.do" id="form1" method="post" style="margin-top: 20px;">
                                <div class="well">
                                    <label>数量: </label>
                                    <input class="form-inline quantity" type="text" name="quantity" onchange="checkQuantity(1,this,${requestScope.productBean.stock})" value="1">
                                    <input type="hidden" name="pid" value="${requestScope.productBean.pid}">
                                    <input type="hidden" name="uid" value="${sessionScope.user.uid}">
                                    <input class="btn btn-2" type="submit" value="加入购物车">
                                </div>
                            </form>
                            <a href="javascript:void(0)" onclick="clickNowPay()" class="btn btn-danger nowPay">立即购买</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="product-desc">
                    <ul class="nav nav-tabs">
                        <li class="detail active"><a href="#description" data-toggle="tab">商品详情</a></li>
                        <li class="access"><a href="#review" data-toggle="tab">商品评价</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="description" class="tab-pane active">
                            <img src="${pageContext.request.contextPath}/images/product/${requestScope.productBean.pid}/desc/1.jpg">
                        </div>
                        <div id="review" class="tab-pane fade">
                            <div>该功能暂未开发!</div>
                        </div>
                    </div>
                </div>
                <div class="product-related">
                    <div class="heading"><h2>相关商品</h2></div>
                    <div class="products">
                        <c:forEach var="radomInfo" items="${requestScope.radomProduct}">
                            <div class="col-lg-4 col-md-4 col-xs-12">
                                <div class="product">
                                    <div class="image"><a href="${pageContext.request.contextPath}/product.do?pid=${radomInfo.pid}"><img src="${pageContext.request.contextPath}/images/product/${radomInfo.pid}/main/1.jpg" /></a></div>
                                    <div class="buttons">
                                        <a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
                                        <a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
                                        <a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
                                    </div>
                                    <div class="caption">
                                        <div class="name"><a href="${pageContext.request.contextPath}/product.do?pid=${radomInfo.pid}">${radomInfo.productName}</a></div>
                                        <div class="price">${myel:priceTwoDecimal(radomInfo.price)}</div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div id="sidebar" class="col-md-4">
                <div class="widget wid-brand">
                    <div class="heading"><h4>品牌</h4></div>
                    <div class="content">
                        <c:forEach items="${brandList}" var="b" >
                            <a class="checkbox" href="${pageContext.request.contextPath}/category.do?brand=${b}">${b}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="widget wid-product">
                    <div class="heading"><h4>最新商品</h4></div>
                    <div class="content">
                        <c:forEach items="${requestScope.newProduct}" var="x">
                            <div class="product">
                                <a href="${pageContext.request.contextPath}/product.do?pid=${x.pid}"><img src="${pageContext.request.contextPath}/images/product/${x.pid}/main/1.jpg" /></a>
                                <div class="wrapper">
                                    <font size="2px"><a href="${pageContext.request.contextPath}/product.do?pid=${x.pid}">${x.productName}</a></font>
                                    <div class="price">¥${myel:priceTwoDecimal(x.price)}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--footer-->
<%@include file="footer.jsp"%>
<script>
    $(document).ready(function () {
        $("#image > li").hover(function () {
            var imgSrc = $(this).find("img").attr("src");
            $(".image-main").attr("src",imgSrc);
        });
    });

    var checkQuantity = function(count,obj,stock) {
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
    };

    var clickNowPay = function () {
        var quantity = $(".quantity").val();
        var sum = quantity * parseInt(${requestScope.productBean.price});
        if (window.confirm("亲,确认立即购买吗?")) {
            window.location.href = "${pageContext.request.contextPath}/nowpay.do?pid=${requestScope.productBean.pid}&uid=${sessionScope.user.uid}&sum=" + sum + "&quantity=" + quantity ;
        }
    }
</script>
</body>
</html>
