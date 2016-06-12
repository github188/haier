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
	    	<h1 class="mui-title">我的服务单</h1>
	    </header> 
		<div class="mui-content">
			
			<div id="slider" class="mui-slider">
				<div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<a class="mui-control-item " href="#item1mobile">
						服务中
					</a>
					<a class="mui-control-item mui-active" href="#item2mobile">
						已完成
					</a>
				</div>
				<div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>
				<div class="mui-slider-group">
					<div id="item1mobile" class="mui-slider-item mui-control-content">
						11111
					</div>
					<div id="item2mobile" class="mui-slider-item mui-control-content mui-active">
						<ul class="service-list">
							<li>
								<div class="service-title clearfix">
									<div class="service-type">安装</div>	
									<div class="service-phone">019191823731</div>
									<div class="service-time">预约时间 2016.05.23 14:25</div>	
								</div>
								<div class="service-content clearfix">
									<div class="detaillink"><a href="">追踪</a></div>
									<div class="service-item clearfix">
										<div class="service-content-pic"><img src="images/service/product.png" style="width:80px;"></div>
										<div class="service-content-text">
											<div class="name">品牌名 类别1 类别2</div>
											<div class="company">北京新顺通达科技有限公司</div>
											<div class="man clearfix">
												<span>服务兵：李先生 13310202992</span>
												<a name="icon-phone" class="mui-icon" href=""></a>
											</div>
										</div>
									</div>
								</div>
							</li>
							
							<li class="clearfix">
								<div class="service-title clearfix">
									<div class="service-type">安装</div>	
									<div class="service-phone">019191823731</div>
									<div class="service-time">预约时间 2016.05.23 14:25</div>	
								</div>
								<div class="service-content clearfix">
									<div class="detaillink"><a href="">追踪</a></div>
									<div class="service-item clearfix">
										<div class="service-content-pic"><img src="images/service/product.png" style="width:80px;"></div>
										<div class="service-content-text">
											<div class="name">品牌名 类别1 类别2</div>
											<div class="company">北京新顺通达科技有限公司</div>
											<div class="man clearfix">
												<span>服务兵：李先生 13310202992</span>
												<a name="icon-phone" class="mui-icon" href=""></a>
											</div>
										</div>
									</div>
								</div>
							</li>
							
							<li class="clearfix">
								<div class="service-title clearfix">
									<div class="service-type">报装</div>	
									<div class="service-phone">019191823731</div>
									<div class="service-time">预约时间 2016.05.23 14:25</div>	
								</div>
								<div class="service-content clearfix">
									<div class="detaillink"><a href="">追踪</a></div>
									<div class="service-item clearfix">
										<div class="service-content-pic"><img src="images/service/product.png" style="width:80px;"></div>
										<div class="service-content-text">
											<div class="name">品牌名 类别1 类别2</div>
											<div class="company">北京新顺通达科技有限公司</div>
											<div class="man clearfix">
												<span>服务兵：李先生 13310202992</span>
												<a name="icon-phone" class="mui-icon" href=""></a>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
			
		
		

		<script>
			(function($, doc) {
				$.init({
					statusBarBackground: '#f7f7f7'
				});
				
			}(mui, document));
		</script>
	</body>

</html>