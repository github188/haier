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

	    <link href="css/mui.picker.css" rel="stylesheet" />
		<link href="css/mui.poppicker.css" rel="stylesheet" />
    	<link rel="stylesheet" type="text/css" href="css/mui.picker.min.css" />
	    <link href="css/iconfont.css" rel="stylesheet"/>
	    <link rel="stylesheet" type="text/css" href="css/main.css"/>
	  	<link rel="stylesheet" type="text/css" href="css/deliveraddress.css"/>
	    
		<script src="js/mui.min.js"></script>
		<script src="js/mui.poppicker.js"></script>
		<script src="js/city.data.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/city.data-3.js" type="text/javascript" charset="utf-8"></script>
    	<script src="js/mui.picker.min.js"></script>
    	<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/views/deliveraddress.js"></script>
		<script src="js/views/ajaxData.js"></script>
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
	    	<h1 class="mui-title">编辑地址</h1>
	    	<a id="morelink" class="mui-icon mui-icon-more icon-mark mui-pull-right"></a>  
	    </header> 
		<div class="mui-content">
			<div class="deliver-address-detail">
				<div class="deliver-address-detail-td clearfix">
					<div class="deliver-address-detail-tl">
						<span class="color2">联系人</span>
					</div>
					<div class="deliver-address-detail-ts">
						<input type="text" id="contact_name" name="contact_name" placeholder="请输入" class="color2"/>
					</div>
				</div>
				<div class="deliver-address-detail-td clearfix">
					<div class="deliver-address-detail-tl">
						<span class="color2">联系电话</span>
					</div>
					<div class="deliver-address-detail-ts">
						<input type="text" id="contact_phone" name="contact_phone" placeholder="请输入" class="color2"/>
					</div>
				</div>
				<div class="deliver-address-detail-td clearfix">
					<div class="deliver-address-detail-tl">
						<span class="color2">省</span>
					</div>
					<div class="deliver-address-detail-ts">
						<div id="sheng" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:90%;height:40px;padding-left: 5px;">请输入</div>
						<input id="sheng-hidden" type="hidden"/>
					</div>
				</div>
				
				<div class="deliver-address-detail-td clearfix">
					<div class="deliver-address-detail-tl">
						<span class="color2">市</span>
					</div>
					<div class="deliver-address-detail-ts">
						<div id="shi" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:90%;height:40px;padding-left: 5px;">请输入</div>
						<input id="shi-hidden" type="hidden"/>
					</div>
					
				</div>
				
				<div class="deliver-address-detail-td clearfix">
					<div class="deliver-address-detail-tl">
						<span class="color2">区县</span>
					</div>
					<div class="deliver-address-detail-ts">
						<div id="area" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:90%;height:40px;padding-left: 5px;">请输入</div>
						<input id="area-hidden" name="district" type="hidden"/>
					</div>
				</div>
				
				<div class="deliver-address-detail-textarea">
					<textarea id="address" placeholder="请填写详细地址" class="color3" ></textarea>
				</div>
				
				<div class="mui-content-padded clearfix">
					<button id='editAddressBtn' class="mui-btn mui-btn-block mui-btn-primary" style="width:100%;background-color: #32beff;border:-20">确定</button>
				</div>
			</div>
		</div>
		<script>
			(function($, doc) {
				$.init({
					
				});
				$.ready(function() {
					//普通示例
					userPicker = new $.PopPicker();
					var sheng = doc.getElementById('sheng');
					sheng.addEventListener('tap', function(event) {
						ajax_area_Data(this);
					}, false);
					
					var shi = doc.getElementById('shi');
					shi.addEventListener('tap', function(event) {
						var sheng_hidden = doc.getElementById("sheng-hidden");
						ajax_shi_Data(this,sheng_hidden.value);
					}, false);
					
					var areaa = doc.getElementById('area');
					areaa.addEventListener('tap', function(event) {
						var sheng_hidden = doc.getElementById("sheng-hidden");
						var shi_hidden = doc.getElementById("shi-hidden");
						ajax_areaa_Data(this,sheng_hidden.value,shi_hidden.value);
					}, false);
					
				});
				
			}(mui, document));
		</script>
	</body>

</html>