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
	    	<h1 class="mui-title">监督与评价</h1>
	    </header> 
		<div class="mui-content">
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
			</ul>
			
			<div class="service-dianzan clearfix" id="tap_dianzan">
				<div class="service-dianzan-name">服务评价</div>
				<div class="service-dianzan-pic">
					<a name="icon-zan" id="pingjia_zan" class="service-dianzan-pic-zan-active" href="javascript:;" attr_zan="1"></a>
					<div class="service-dianzan-title">点赞</div>
				</div>
				<div class="service-dianzan-pic">
					<a name="icon-manyi" id="pingjia_zan" class="service-dianzan-pic-manyi" href="javascript:;" attr_zan="2"></a>
					<div class="service-dianzan-title">满意</div>
				</div>
				<div class="service-dianzan-pic">
					<a name="icon-cha" id="pingjia_zan" class="service-dianzan-pic-cha" href="javascript:;" attr_zan="3"></a>
					<div class="service-dianzan-title">差评</div>
				</div>
			</div>
			<div class="service-dianzan-cha-detail" id="tap_dianping-cha-detail" style="display: none;">
				<div class="mui-input-row mui-radio mui-left">
					<label>服务态度差</label>
					<input name="dianpin-cha-reason" type="radio" value="1" checked="checked">
				</div>
				<div class="mui-input-row mui-radio mui-left">
					<label>服务技能差</label>
					<input name="dianpin-cha-reason" type="radio" value="2">
				</div>
				<div class="mui-input-row mui-radio mui-left">
					<label>上门不及时</label>
					<input name="dianpin-cha-reason" type="radio" value="3">
				</div>
				<div class="mui-input-row mui-radio mui-left">
					<label>收费不合理</label>
					<input name="dianpin-cha-reason" type="radio" value="4">
				</div>
				<div class="mui-input-row mui-radio mui-left">
					<label>服务周期长</label>
					<input name="dianpin-cha-reason" type="radio" value="5">
				</div>
				<div class="mui-input-row mui-radio mui-left">
					<label>其他</label>
					<input name="dianpin-cha-reason" type="radio"  value="6">
				</div>
			</div>
			
			<div class="service-pingjia-detail clearfix">
				<div class="service-pingjia-item clearfix">
					<div class="service-pingjia-name">评价详情</div>
					<div class="service-pingjia-txt">
						<textarea maxlength="64" id="mypingjia" name="mypingjia" class="color2" placeholder="我的评价,支持语音录入,最多输入64个字符"></textarea>
					</div>
				</div>
				<div class="service-pingjia-detail-yuyin clearfix"><a href="javascript:;" id="yuyinBtn"></a></div>
			</div>
			
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