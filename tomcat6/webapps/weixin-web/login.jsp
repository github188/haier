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
	    <link href="css/login.css" rel="stylesheet" />
	    
	    <script src="js/mui.min.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/views/login.js"></script>
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
	    	<h1 class="mui-title">登录</h1>
	    	<a id="maintence" class="mui-icon icon-mark mui-pull-right" style="color: #32BEFF">注册</a>  
		</header> 
		<div class="mui-content">
			<div id="slider" class="mui-slider">
				<div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<a class="mui-control-item " href="#index.html">
						新机报装
					</a>
					<a class="mui-control-item mui-active" href="#item2mobile">
						快速登录
					</a>
				</div>
				<div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>
				<div class="mui-slider-group">
					<div id="item2mobile" class="mui-slider-item mui-control-content mui-active">
						<div style="text-align: center;height: 80px;vertical-align:middle;background:#EEEEEE;"><img src="images/logo.png" style="width:130px;height:40px;top:40px;margin-top: 20px; " /></div>
						<form class="mui-input-group" id="formLogin">				
							<div class="mui-input-row" style="height: 86px;line-height:86px;">
								<label style="margin-top:13px;"><img src="images/login/phone.png" style="width:40px;height:40px;"></label>
								<input id='phone' name="phone" type="text" class="mui-input-clear mui-input" placeholder="请输入手机号" style="margin-top:23px;">
							</div>             	
			                
							<div class="mui-input-row register-input-password" style="height: 86px;line-height:86px;">
								<label style="margin-top:13px;"><img src="images/login/password.png" style="width:40px;height:40px;"></label>
								<input id='password' name="password" type="text" class="mui-input-clear mui-input" placeholder="" style="margin-top:23px;width:48%;float: left;border:1px;">
								<div style="width:30%;height:40px;float: right;padding:23px 10px 0 0">
									<button id="sendMessage"  type="button" class="mui-btn mui-btn-primary check-code nosend" style="width:100%;border:-20">发送短信</button>
								</div>
							</div>
							<div class="mui-content-padded">
								<button id='loginBtn' class="mui-btn mui-btn-block mui-btn-primary" style="width:100%;background-color: #32beff;border:-20">登录</button>
							</div>
						</form>
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