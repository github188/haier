<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="ui-page-login">
<%
	String openId = request.getParameter("openId");
	if(null == openId){
		openId="";
	}

%>
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
		<script src="js/views/showpage.js"></script>
		<script src="js/views/servicelist.js"></script>
    <style> 
		.mui-control-content {
			background-color: #EEEEEE;
			min-height: 500px;
		}
	
	</style>
		

	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left title-back">返回</a>
	    	<h1 class="mui-title">我的服务单</h1>
	    </header> 
		<div class="mui-content">
			
			<div id="slider" class="mui-slider">
				<div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<a class="mui-control-item " href="#item1mobile" id="service_type_link_0" attr_type_id="0">
						服务中
					</a>
					<a class="mui-control-item mui-active" href="#item2mobile" id="service_type_link_1" attr_type_id="1">
						已完成
					</a>
				</div>
				<div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>
				<div class="mui-slider-group">
					<div id="item1mobile" class="mui-slider-item mui-control-content">
						<ul class="service-list" id="servicelist_0"></ul>
						<div class="pagelist" id="pagelist_0"></div>	
					</div>
					<div id="item2mobile" class="mui-slider-item mui-control-content mui-active">
						<ul class="service-list" id="servicelist_1"></ul>
						<div class="pagelist" id="pagelist_1"></div>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" name="openId" id="openId" value="<%=openId%>">
		<input type="hidden" name="user_id" id="user_id" value="">

		<script>
			(function($, doc) {
				$.init({
					statusBarBackground: '#f7f7f7'
				});
				document.getElementById('service_type_link_0').addEventListener('tap',function(){
					initList(1, 0);
				});
				document.getElementById('service_type_link_1').addEventListener('tap',function(){
					initList(1, 1);
				});
			}(mui, document));
		</script>
	</body>

</html>