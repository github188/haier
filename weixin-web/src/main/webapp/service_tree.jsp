<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left title-back">返回</a>
	    	<h1 class="mui-title">服务单可视</h1>
	    </header> 
		<div class="mui-content">
			<ul class="service-list">
				<li class="view">
					<div class="service-list-view-title clearfix">
						<div class="service-type">安装</div>	
						<div class="service-product">冰箱(统帅)</div>
						<div class="service-status">服务完成</div>	
					</div>
				</li>
			</ul>
			
			<ul class="service-tree">
				<li class="clearfix">
					<div class="service-itme-name tree-active"><span>服务评价</span></div>
					<div class="service-itme-content">
						<p>未评价</p>
						<p>2016-06-01 14:34:48</p>
					</div>
					<hr>
				</li>	
				<li class="clearfix">
					<div class="service-itme-name tree"><span>服务完成</span></div>
					<div class="service-itme-content">
						<p>已安排服务人员李先生为您上门服务,收费123.89元</p>
						<p>2016-06-01 14:34:48</p>
					</div>
					<hr>
				</li>
				<li class="clearfix">
					<div class="service-itme-name tree"><span>服务中</span></div>
					<div class="service-itme-content">
						<p>由北京汇融信通电子电器设备有限公司为您提供服务</p>
						<p>2016-06-01 14:34:48</p>
					</div>
					<hr>
				</li>
				<li class="clearfix">
					<div class="service-itme-name tree"><span>已派单</span></div>
					<div class="service-itme-content">
						<p>由北京汇融信通电子电器设备有限公司为您提供服务</p>
						<p>2016-06-01 14:34:48</p>
					</div>
					<hr>
				</li>
				<li class="clearfix">
					<div class="service-itme-name tree"><span>已接收</span></div>
					<div class="service-itme-content">
						<p>2016-06-01 14:34:48</p>
					</div>
				</li>
			</ul>
			
			<form class="mui-input-group" id="formLogin">				
				<div class="mui-content-padded">
					<button id='pingjiaBtn' class="mui-btn mui-btn-block mui-btn-primary" style="width:100%;background-color: #32beff;border:-20">提交评价</button>
				</div>
				<input type="hidden" id="dianzan-hidden" value="0">
			</form>
		</div>
			
		
		

		<script>
			(function($, doc) {
				$.init({
					
				});
				
			}(mui, document));
		</script>
	</body>

</html>