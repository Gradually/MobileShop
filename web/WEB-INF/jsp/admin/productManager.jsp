<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: WuYuchen
  Date: 2017/11/20
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myel" uri="/myel" %>
<html>
<head>
    <title>商品管理</title>
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
<div class="addProduct">
    <div class="row">
        <span class="close" style="margin-right: 25px;margin-top: 5px;">&times;</span>
    </div>
    <form onsubmit="return addProduct()" id="addProductForm" action="${pageContext.request.contextPath}/uploadProductInfo.admin" enctype="multipart/form-data" method="post">
        <ul class="list-unstyled col-lg-12 col-lg-offset-0">
            <li style="text-align: center"><h2>增加商品</h2></li>
            <li><hr style="border: 1px solid transparent"></li>
            <li><input type="text" class="productName" name="productName" placeholder="商品名称:"></li>
            <li><input type="text" class="brand" name="brand" placeholder="商品品牌:"></li>
            <li><input type="text" class="price" name="price" placeholder="商品售价:"></li>
            <li><input type="text" class="stock" name="stock" placeholder="商品库存:"></li>
            <li class="label-danger">以下所有图片限制5M以内,且图片格式为JPG</li>
            <li><label>商品主图1:<input type="file" name="main1"></label></li>
            <li><label>商品主图2:<input type="file" name="main2"></label></li>
            <li><label>商品主图3:<input type="file" name="main3"></label></li>
            <li><label>商品主图4:<input type="file" name="main4"></label></li>
            <li><label>商品详情1:<input type="file" name="desc"></label></li>
            <li><hr style="border: 1px solid transparent"></li>
            <li><input type="submit" value="添加商品" style="width:100px" class="btn btn-primary"></li>
        </ul>
    </form>

</div>
<div id="wrapper">
<jsp:include page="top.jsp"></jsp:include>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-3 col-lg-offset-11">
                    <a href="javascript:void(0)" style="background-color:#000000;color: #ffffff;" class="btn btn-lg showAdd"><i class="fa fa-plus"></i>添加商品</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                <table class="table table-striped table-hover table-condensed table-bordered col-lg-12" align="center" >
                    <caption>
                        <h2>商品管理</h2>
                    </caption>
                    <thead>
                    <tr bgcolor="#a9a9a9" align="center">
                        <th class="col-lg-1">商品ID</th>
                        <th class="col-lg-3">商品名称(可改)</th>
                        <th class="col-lg-1">商品品牌(可改)</th>
                        <th class="col-lg-1">剩余库存(可改)</th>
                        <th class="col-lg-1">商品售价(¥)(可改)</th>
                        <th class="col-lg-2">添加时间</th>
                        <th class="col-lg-2">修改时间</th>
                        <th class="col-lg-1">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.pageBean.list}" var="productBean">
                            <tr>
                                <td>${productBean.pid}</td>
                                <td><input type="text"  value="${productBean.productName}" onchange="goSubmit(this)" name="productName"></td>
                                <td><input type="text" value="${productBean.brand}" onchange="goSubmit(this)" name="brand"></td>
                                <td><input type="text" value="${productBean.stock}" onchange="goSubmit(this)" name="stock"></td>
                                <td><input type="text" value="${myel:priceTwoDecimal(productBean.price)}" onchange="goSubmit(this)" name="price"></td>
                                <td>${productBean.createTime}</td>
                                <td>${productBean.modifiedTime}</td>
                                <td><a href="${pageContext.request.contextPath}/removeProduct.admin?currentPage=${requestScope.pageBean.currentPage}&pid=${productBean.pid}" class="btn btn-link">删除商品</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
            </div>
        </div>
        <c:if test="${myel:checkRow(requestScope.pageBean)}">
            <div class="row text-center">
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.previousPage}">
                            <li><a href="${pageContext.request.contextPath }/productManager.admin?currentPage=${requestScope.pageBean.previousPage}" >上一页</a></li>
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
                                <li><a href="${pageContext.request.contextPath }/productManager.admin?currentPage=${pagenum}">${pagenum }</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.nextPage}">
                            <li><a href="${pageContext.request.contextPath }/productManager.admin?currentPage=${pageBean.nextPage}" >下一页</a></li>
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
        $(".now-choose > li").eq(3).addClass("active");
        $(".showAdd").click(function () {
            $(".addProduct").animate({"margin-top": "-370px"});
        });
        $(".close").click(function () {
            $(".addProduct").animate({"margin-top": "-2000px"});
        });
    });
    var goSubmit = function (ele) {
        var pid = $(ele).parent().parent().find("td").eq(0).text();
        var input = $(ele).parent().parent().find("input");
        var productName = input.eq(0).val();
        var brand = input.eq(1).val();
        var stock = input.eq(2).val();
        var price = input.eq(3).val();
        var currentPage = ${requestScope.pageBean.currentPage};
        if (window.confirm("您确认修改ID为" + pid + "的商品信息吗?")) {
            window.location.href = "${pageContext.request.contextPath}/updateProductInfo.admin?pid=" + pid + "&productName=" + productName + "&brand=" + brand + "&stock=" + stock + "&price=" + price + "&currentPage=" + currentPage;
        }
    }

    var addProduct = function () {
        var isOK = true;
        var productName = $("input").eq(0).val();
        var brand = $("input").eq(1).val();
        var price = $("input").eq(2).val();
        var stock = $("input").eq(3).val();
        var filename1 = $("input").eq(4).val().replace(/.*(\/|\\)/, "");
        var fileExt1=(/[.]/.exec(filename1)) ? /[^.]+$/.exec(filename1.toLowerCase()) : '';
        var filename2 = $("input").eq(5).val().replace(/.*(\/|\\)/, "");
        var fileExt2=(/[.]/.exec(filename2)) ? /[^.]+$/.exec(filename2.toLowerCase()) : '';
        var filename3 = $("input").eq(6).val().replace(/.*(\/|\\)/, "");
        var fileExt3=(/[.]/.exec(filename3)) ? /[^.]+$/.exec(filename3.toLowerCase()) : '';
        var filename4 = $("input").eq(7).val().replace(/.*(\/|\\)/, "");
        var fileExt4=(/[.]/.exec(filename4)) ? /[^.]+$/.exec(filename4.toLowerCase()) : '';
        var filename5 = $("input").eq(8).val().replace(/.*(\/|\\)/, "");
        var fileExt5=(/[.]/.exec(filename5)) ? /[^.]+$/.exec(filename5.toLowerCase()) : '';
        alert(productName + "::" + brand + "::" + price + "::" + stock + "::" + filename1 + "::" + fileExt1 + fileExt2 + fileExt3 + fileExt4 + fileExt5);
        if (productName == null || productName.trim() == "") {
            isOK = false;
            alert("商品名称不能为空!");
        }
        if (brand == null || brand.trim() == "") {
            isOK = false;
            alert("商品品牌不能为空!");
        }
        if (isNaN(price) || price.trim() == "" || price == null || parseFloat(price) <= 0) {
            isOK = false;
            alert("商品价格不合法!!");
        }
        if (isNaN(price) || stock.trim() == "" || stock == null || parseInt(stock) <= 0) {
            isOK = false;
            alert("商品库存不合法!!");
        }
        if (fileExt5 != "jpg" || fileExt4 != "jpg" || fileExt3 != "jpg" || fileExt2 != "jpg" || fileExt1 != "jpg") {
            isOK = false;
            alert("五个图片中存在格式不是jpg为后缀名的文件!!");
        }
        if (isOK && window.confirm("您确定商品信息无误,确认提交吗?")) {
            return true;
        }
        return false;
    }

</script>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
