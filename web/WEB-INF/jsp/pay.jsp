<%--
  Created by IntelliJ IDEA.
  User: WuYuchen
  Date: 2017/11/11
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/myel" prefix="myel"%>
<html>
<head>
    <title>商品支付页面</title>
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
<jsp:include page="top.jsp"></jsp:include>
<div class="pay">
    <div class="container">
        <div class="row">
                <div class="pricedetails">
                    <div class="col-md-8">
                        <textarea class="address" id="#address" placeholder="详细收货地址 : " style="height: 150px;width: 300px;">${sessionScope.user.address}</textarea><br><br>
                        <input type="text" class="tel" placeholder="电话号码 : " maxlength="11" value="${sessionScope.user.tel}">
                    </div>
                    <div class="col-md-4">
                        <table>
                            <h6>付款详情:</h6>
                            <tr>
                                <td>用户余额</td>
                                <td>¥${sessionScope.user.money}</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>-----</td>
                            </tr>
                            <tr>
                                <td>应付款项</td>
                                <td>¥${requestScope.sum}</td>
                            </tr>
                            <tr style="border-top: 1px solid #333">
                                <td><h5>付后剩余:</h5></td>
                                <td></td>
                            </tr>
                        </table>
                        <center><button class="btn btn-1 nowSubmit" onclick="plank()">立即付款</button></center>
                    </div>
                </div>
        </div>
        <br>
        <br>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script>
        $(document).ready(function () {
            var balance = parseInt(${sessionScope.user.money}) - parseInt(${requestScope.sum});
            $("td").last().text("¥" + balance);
        });
        var plank = function () {
            var address = $(".address").val();
            var tel = $(".tel").val();
            if (address == null || address.trim() == "") {
                alert("亲,您还没有填写地址呢!");
                return;
            }
            var pattern = /^1[34578]\d{9}$/;
            if (tel == null || tel.trim() == "" || !pattern.test(tel)) {
                alert("亲,您的手机号输入不合法哦!");
                return;
            }
            window.location.href = "${pageContext.request.contextPath}/addorders.do?tel=" + tel + "&address=" + address + "&paysum=" + ${requestScope.sum};
    }
</script>
</body>
</html>
