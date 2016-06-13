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
		<link href="css/style.css" rel="stylesheet" />
		<link href="css/login.css" rel="stylesheet" />

		<script src="js/mui.min.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/views/register.js"></script>
	</head>

	<body>
	<input type="hidden" name="openId" id="openId" value="<%=openId%>">
	<input type="hidden" name="user_id" id="user_id" value="">
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">账号注册</h1>
		</header>
		<div class="mui-content">
			<div style="text-align: center;height: 80px;vertical-align:middle;"><img src="images/logo.png" style="height:40px;top:40px;margin-top: 20px; " /></div>
			<form class="mui-input-group" id="formRegister">				
				<div class="mui-input-row" style="height: 86px;line-height:86px;">
					<label style="margin-top:13px;"><img src="images/login/phone.png" style="width:40px;height:40px;"></label>
					<input id='phone' name="phone" type="text" class="mui-input-clear mui-input" placeholder="请输入手机号" style="margin-top:23px;">
				</div>             	
                
				<div class="mui-input-row register-input-password" style="height: 86px;line-height:86px;">
					<label style="margin-top:13px;"><img src="images/login/password.png" style="width:40px;height:40px;"></label>
					<input id='password' name="password" type="password" class="mui-input-clear mui-input" placeholder="请输入密码" style="margin-top:23px;width:60%;float: left;border:1px;">
					<div style="width:18%;height:40px;float: right;padding:23px 10px 0 0;text-align: right;">
						<a id="register-icon-see" class="register-input-password-seeno" href="javascript:;"></a>
					</div>
				</div>
				
				<div class="mui-input-row" style="height: 86px;line-height:86px;">
					<label style="margin-top:13px;"><img src="images/login/checkcode.png" style="width:40px;height:40px;"></label>
					<input id='checkcode' name="checkcode" type="text" class="mui-input-clear mui-input" placeholder="" style="margin-top:23px;width:50%;float: left;border:1px;">
					<div style="width:28%;height:40px;float: right;padding:23px 10px 0 0">
						<button id="getCheckcode"  type="button" class="mui-btn mui-btn-primary check-code nosend" style="width:100%;border:-20">获取验证码</button>
					</div>
				</div>
				
				<div class="mui-input-row" style="height: 40px;line-height:40px;">
					<label style="margin-top:0px;text-align: right;"><input type="checkbox" checked="checked" class="i-checkbox" name="agree" id="agree"></label>
					
					<div style="width:78%;height:40px;line-height:40px;float: left;font-size:13px;">我已阅读并同意《海尔服务使用协议》
					</div>
				</div>
			</form>
			<div class="mui-content-padded">
				<button id='sendRegister' class="mui-btn mui-btn-block mui-btn-primary" style="width:100%;background-color: #32beff;border:-20">注册</button>
			</div>
		</div>
		<script src="js/mui.min.js"></script>
		<script src="js/app.js"></script>
		<script>
			(function($, doc) {
				$.init();
			}(mui, document));
		</script>
	</body>

</html>