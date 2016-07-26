<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title></title>
    <script src="js/mui.min.js"></script>
    <script src="js/mui.picker.js"></script>
	<script src="js/mui.poppicker.js"></script>

    <script src="js/mui.picker.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
    <!--<script src="js/scale.js"></script>-->
    <script src="js/views/ajaxData.js"></script>
    
    <link href="css/mui.min.css" rel="stylesheet"/>
    <!--App自定义的css-->
	<!--<link rel="stylesheet" type="text/css" href="css/app.css" />-->
	<link href="css/mui.picker.css" rel="stylesheet" />
	<link href="css/mui.poppicker.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/mui.picker.min.css" />
    <link href="css/iconfont.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <style> 
		.mui-control-content {
			background-color: white;
			min-height:500px;
		}
	
	</style>
</head>
<body>
	
	<div class="mui-content">
			<div id="slider" class="mui-slider">
				
				
				<div class="mui-slider-group">
					<div id="item1mobile" class="mui-slider-item mui-control-content mui-active">
						<div id="scroll1" class="mui-scroll-wrapper">
							<div class="mui-scroll" style="height:640px;">
								<div style="height:80px;border-bottom: 1px solid #dcdcdc;line-height: 80px;padding-left:30px">
									<span class="color1">我的产品</span>
									<a style="display: block;background:url(images/arrow-right.png) no-repeat;background-size:6px 12px;width:12px;height:24px;float:right;margin-top:28px;margin-right:30px"></a>
								</div>
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">品牌</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px ">
										<div id="pinpai" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="pinpai-hidden" type="hidden"/>
									</div>
									
									
									
								</div>
								<div style="width:100%;height:80px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">类型</span></div>
									<div style="width:75%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;padding-right:30px">
										<div id="type1" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="type1-hidden" type="hidden"/>
									</div>
									
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<div id="type2" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="type2-hidden" name="product_id" type="hidden"/>
									</div>
								</div>
								
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">联系人</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<input type="text" id="contact" name="contact_name" style="padding:0;margin:0;height:40px;border:0;background: transparent;"/>
									</div>
								</div>
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">联系电话</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<input type="text" id="phone" name="mobile_phone" style="padding:0;margin:0;height:40px;border:0;background: transparent;"/>
										<input id="phone-hidden" type="hidden"/>
									</div>
								</div>
								
								<div style="width:100%;height:60px;padding-left:30px;">
									<div style="width:25%;height:60px;float:left;padding-top:20px"><span class="triangle">*</span><span class="color2">服务地址</span></div>
									<div style="width:45%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="Address" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:60px;width:100%;height:60px">请输入</div>
										<input id="Address-hidden" type="hidden"/>
									</div>
									<div style="width:30%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;padding-right:30px;text-align: right;">
										<a id="icon-add" class="mui-icon iconfont icon-roundaddfill" style="font-size: 30px;color: #32beff;padding-top: 15px;margin:0"></a>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">省</span></div>
									<div style="width:30%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="sheng" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="sheng-hidden" type="hidden"/>
									</div>
									<div style="width:5%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;border-bottom: 1px solid #dcdcdc;"><span class="color2">市</span></div>
									<div style="width:30%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="shi" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="shi-hidden" type="hidden"/>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">区</span></div>
									<div style="width:70%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="area" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="area-hidden" name="district" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:40px;padding-left:30px;border-bottom: 1px solid #dcdcdc;">
									<div style="width:25%;height:40px;float:left;"></div>
									<div style="width:75%;height:40px;float:left;">
										<input type="text" id="infoaddress" class="color3" placeholder="请填写详细地址" style="padding:0;margin:0;height:40px;border:0;background: transparent;"/>
										<input id="infoaddress-hidden" name="address" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"><span class="triangle">*</span><span class="color2">预约日期</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px;">
										<div id="newdate" class="color3 dates" data-options='{"type":"date"}' style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="newdate-hidden" name="require_service_date" type="hidden"/>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"><span class="triangle">*</span><span class="color2">服务时间</span></div>
									<div style="width:35%;height:40px;float: left;padding-right:30px;">
										<div id="newdate-font" class="color3 dates" data-options='{"type":"time"}' style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="newdate-font-hidden" type="hidden"/>
									</div>
									
									<div class="color2" style="width:5%;height:40px;float: left;text-align: right;padding-top:10px;">到</div>
									<div style="width:35%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="newdate-after" class="color3 dates" data-options='{"type":"time"}' style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="newdate-after-hidden" type="hidden"/>
									</div>
									<input id="newdate-front-after-hidden" name="service_time" type="hidden"/>
									
								</div>
								<div style="width:100%;height:40px;padding-left:30px;">
									
									
								</div>
								
								<!--<div style="width:100%;height:40px;padding-left:30px;">
									<div class="color3" style="width:25%;height:40px;float: left;text-align: right;padding-top:10px;">到</div>
									<div style="width:75%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="newdate-after" class="color3 dates" data-options='{"type":"hour"}' style="background:url(images/arrow-down.png) right center no-repeat;background-size:12px 6px;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="newdate-after-hidden" type="hidden"/>
									</div>
									<input id="newdate-front-after-hidden" name="service_time" type="hidden"/>
								</div>-->
								
							</div>
						</div>
						<input type="hidden" name="require_service_desc" value="hardcode">
						<input type="hidden" name="service_type" value="T02" />
					</div>
					<div id="item2mobile" class="mui-slider-item mui-control-content">
						<div id="scroll2" class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<div style="height:80px;border-bottom: 1px solid #dcdcdc;line-height: 80px;padding-left:30px">
									<span class="color1">我的产品</span>
									<a style="display: block;background:url(images/arrow-right.png);width:12px;height:24px;float:right;margin-top:28px;margin-right:30px"></a>
								</div>
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">品牌</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<div id="yjbz-pinpai" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="yjbz-pinpai-hidden" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:80px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">类型</span></div>
									<div style="width:75%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;padding-right:30px">
										<div id="yjbz-type1" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="yjbz-type1-hidden" type="hidden"/>
									</div>
									
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<div id="yjbz-type2" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="yjbz-type2-hidden" type="hidden"/>
									</div>
								</div>
								
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">联系人</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<div id="yjbz-contact" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="yjbz-contact-hidden" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:40px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px"><span class="triangle">*</span><span class="color2">联系电话</span></div>
									<div style="width:75%;height:40px;float: left;padding-right:30px">
										<div id="yjbz-phone" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px">请输入</div>
										<input id="yjbz-phone-hidden" type="hidden"/>
									</div>
								</div>
								
								<div style="width:100%;height:60px;padding-left:30px;">
									<div style="width:25%;height:60px;float:left;padding-top:20px"><span class="triangle">*</span><span class="color2">旧地址</span></div>
									<div style="width:45%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-Address" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:60px;width:100%;height:60px">请输入</div>
										<input id="yjbz-Address-hidden" type="hidden"/>
									</div>
									<div style="width:30%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;padding-right:30px">
										<a id="yjbz-icon-add" style="background:url(images/add.png) right center no-repeat;border:0;display:block;width:100%;height:60px""></a>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">省</span></div>
									<div style="width:30%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-sheng" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-sheng-hidden" type="hidden"/>
									</div>
									<div style="width:5%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;border-bottom: 1px solid #dcdcdc;"><span class="color2">市</span></div>
									<div style="width:30%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-shi" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-shi-hidden" type="hidden"/>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">区</span></div>
									<div style="width:70%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-area" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-area-hidden" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:40px;padding-left:30px;border-bottom: 1px solid #dcdcdc;">
									<div style="width:25%;height:40px;float:left;"></div>
									<div style="width:75%;height:40px;float:left;">
										<input type="text" id="yjbz-infoaddress" class="color1" placeholder="请填写详细地址" style="padding:0;margin:0;height:40px;border:0;background: transparent;"/>
									</div>
								</div>
								
								<div style="width:100%;height:60px;padding-left:30px;">
									<div style="width:25%;height:60px;float:left;padding-top:20px"><span class="triangle">*</span><span class="color2">新地址</span></div>
									<div style="width:45%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-newAddress" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:60px;width:100%;height:60px">请输入</div>
										<input id="yjbz-newAddress-hidden" type="hidden"/>
									</div>
									<div style="width:30%;height:60px;float: left;border-bottom: 1px solid #dcdcdc;padding-right:30px">
										<a id="icon-newadd" style="background:url(images/add.png) right center no-repeat;border:0;display:block;width:100%;height:60px""></a>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">省</span></div>
									<div style="width:30%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-newsheng" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-newsheng-hidden" type="hidden"/>
									</div>
									<div style="width:5%;height:40px;float: left;border-bottom: 1px solid #dcdcdc;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;border-bottom: 1px solid #dcdcdc;"><span class="color2">市</span></div>
									<div style="width:30%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-newshi" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-newshi-hidden" type="hidden"/>
									</div>
									
								</div>
								
								<div style="width:100%;height:40px;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;border-bottom: 1px solid #dcdcdc;"><span class="color2">区</span></div>
									<div style="width:70%;height:40px;float: left;padding-right:30px;border-bottom: 1px solid #dcdcdc;">
										<div id="yjbz-newarea" class="color3" style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-newarea-hidden" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:40px;padding-left:30px;border-bottom: 1px solid #dcdcdc;">
									<div style="width:25%;height:40px;float:left;"></div>
									<div style="width:75%;height:40px;float:left;">
										<input id="yjbz-newinfoaddress" type="text" class="color1" placeholder="请填写详细地址" style="padding:0;margin:0;height:40px;border:0;background: transparent;"/>
									</div>
								</div>
								
								<div style="width:100%;height:60px;border-bottom: 1px solid #dcdcdc;padding-left:30px;">
									<div style="width:25%;height:40px;float:left;padding-top:10px;"><span class="triangle">*</span><span class="color1">预约日期</span></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;text-align: right;"><span class="color1">日</span></div>
									<div style="width:30%;height:40px;float: left;">
										<div id="yjbz-newdate" class="color3 dates" data-options='{"type":"date"}' style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-newdate-hidden" type="hidden"/>
									</div>
									<div style="width:5%;height:40px;float: left;"></div>
									<div style="width:5%;height:40px;float:left;padding-top:10px;"><span class="color1">时</span></div>
									<div style="width:30%;height:40px;float: left;padding-right:30px;">
										<div id="yjbz-newtime" class="color3 dates" data-options='{"type":"time"}' style="background:url(images/arrow-down.png) right center no-repeat;border:0;line-height:40px;width:100%;height:40px;padding-left: 5px;">请输入</div>
										<input id="yjbz-newtime-hidden" type="hidden"/>
									</div>
								</div>
								<div style="width:100%;height:60px;padding-left:30px;">
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			var userPicker;
			(function($, doc) {
				mui.init({
					swipeBack: false
					
				});
				$('.mui-scroll-wrapper').scroll({
					indicators: true //是否显示滚动条
				});
				/*var html2 = '<ul class="mui-table-view"><li class="mui-table-view-cell">第二个选项卡子项-1</li><li class="mui-table-view-cell">第二个选项卡子项-2</li><li class="mui-table-view-cell">第二个选项卡子项-3</li><li class="mui-table-view-cell">第二个选项卡子项-4</li><li class="mui-table-view-cell">第二个选项卡子项-5</li></ul>';
				var item2 = document.getElementById('item2mobile');
				document.getElementById('slider').addEventListener('slide', function(e) { 
					if (e.detail.slideNumber === 1) {
						if (item2.querySelector('.mui-loading')) {
							setTimeout(function() {
								item2.querySelector('.mui-scroll').innerHTML = html2;
							}, 500);
						}
					}
				});*/
				$.ready(function() {
					//plus.webview.currentWebview().scrollbarIndicatorY = "none";
					//普通示例
					userPicker = new $.PopPicker();
					var pinpai = doc.getElementById('pinpai');
					pinpai.addEventListener('tap', function(event) {
						ajax_pinpai_Data(this);
					}, false);
					
					var type1 = doc.getElementById('type1');
					type1.addEventListener('tap', function(event) {
						ajax_type1_Data(this);
					}, false);
					
					var type2 = doc.getElementById('type2');
					type2.addEventListener('tap', function(event) {
						ajax_type2_Data(this);
					}, false);
					
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
				

				
				var btns = $('.dates');
				btns.each(function(i, btn) {
					btn.addEventListener('tap', function() {
						var obj = this;  
						var optionsJson = this.getAttribute('data-options') || '{}';
						var options = JSON.parse(optionsJson);
						var id = this.getAttribute('id');
						/*
						 * 首次显示时实例化组件
						 * 示例为了简洁，将 options 放在了按钮的 dom 上
						 * 也可以直接通过代码声明 optinos 用于实例化 DtPicker
						 */
						var picker = new $.DtPicker(options);
						picker.show(function(rs) {
							/*
							 * rs.value 拼合后的 value
							 * rs.text 拼合后的 text
							 * rs.y 年，可以通过 rs.y.vaue 和 rs.y.text 获取值和文本
							 * rs.m 月，用法同年
							 * rs.d 日，用法同年
							 * rs.h 时，用法同年
							 * rs.i 分（minutes 的第二个字母），用法同年
							 */
							if(obj.getAttribute("id") == "newdate"){
								doc.getElementById("newdate").innerText = rs.y.text+"-"+rs.m.text+"-"+rs.d.text;
								doc.getElementById("newdate-hidden").value = rs.y.text+"-"+rs.m.text+"-"+rs.d.text;
							}else if(obj.getAttribute("id") == "newdate-font"){
								doc.getElementById("newdate-font").innerText = rs.h.text+":00";
								doc.getElementById("newdate-font-hidden").value = rs.h.text+":00";
							}else if(obj.getAttribute("id") == "newdate-after"){
								doc.getElementById("newdate-after").innerText = rs.h.text+":00";
								doc.getElementById("newdate-after-hidden").value = rs.h.text+":00";
							}
							//doc.getElementById("newdate-hidden").innerText = rs.value;
							//alert(rs.value);
							/* 
							 * 返回 false 可以阻止选择框的关闭
							 * return false;
							 */
							/*
							 * 释放组件资源，释放后将将不能再操作组件
							 * 通常情况下，不需要示放组件，new DtPicker(options) 后，可以一直使用。
							 * 当前示例，因为内容较多，如不进行资原释放，在某些设备上会较慢。
							 * 所以每次用完便立即调用 dispose 进行释放，下次用时再创建新实例。
							 */
							//picker.dispose();
						});
					}, false);
				});
			})(mui, document);
		</script>
</body>
</html>