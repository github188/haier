<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="ui-page-login">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link href="css/mui.min.css" rel="stylesheet" />

    <!--App自定义的css-->
    <!--<link rel="stylesheet" type="text/css" href="css/app.css" />-->

    <link rel="stylesheet" type="text/css" href="css/mui.picker.min.css" />
    <link href="css/iconfont.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/service.css"/>

    <script src="js/mui.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/views/formPingjia.js"></script>
    <style>
        .mui-control-content {
            background-color: white;
            min-height: 500px;
        }

    </style>


</head>

<body>
<%
    String product_name = URLDecoder.decode(request.getParameter("product_name"),"UTF-8");
    String type_name = URLDecoder.decode(request.getParameter("type_name"),"UTF-8");
    String service_type_name = URLDecoder.decode(request.getParameter("service_type_name"),"UTF-8");
    String statusDesc =  URLDecoder.decode(request.getParameter("statusDesc"),"UTF-8");
%>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left title-back">返回</a>
    <h1 class="mui-title">服务单可视</h1>
</header>
<div class="mui-content">
        <ul class="service-list">
            <li style="height:120px;">
                <div class="service-content clearfix">
                    <div class="service-item clearfix">
                        <div class="service-content-pic"><img src="images/service/product.png" style="width:80px;"></div>
                        <div class="service-content-text">
                            <div class="name"><%=product_name%> &nbsp;&nbsp;<%=type_name%></div>
                            <div class="company">服务类型：<%=service_type_name%></div>
                            <div class="company">状态：<%=statusDesc%></div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <ul class="service-tree" id="serviceTract">

        </ul>

        <form class="mui-input-group" id="formLogin">
            <div class="mui-content-padded">
                <button id='pingjiaBtn' class="mui-btn mui-btn-block mui-btn-primary" style="width:100%;background-color: #32beff;border:-20">评价</button>
            </div>
            <input type="hidden" id="dianzan-hidden" value="0">
        </form>
</div>
<input type="hidden" name="orderCode" id="orderCode" value="BXK4160613661402">

<script>
    (function($, doc) {
        $.init({

        });

    }(mui, document));
</script>
</body>

</html>
