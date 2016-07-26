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
		
	
	</style>
</head>
<body>
	<header class="mui-bar mui-bar-nav">
	    
				<div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<a id="tab1" class="mui-control-item  mui-active"  href="#item1mobile">
						新机报装
					</a>
					<a id="tab2" class="mui-control-item" href="#item2mobile">
						移机报装
					</a>
				</div>
				<!--<div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>-->
				
			
	</header>

		
		<script>
			var userPicker;
			(function($, doc) {
				mui.init({
					swipeBack: false,
					subpages:[{
			      		url:"index_sub_sub.jsp",//子页面HTML地址，支持本地地址和网络地址
			      		id:"indexSubSub",//子页面标志
			      		styles: {
							top: '45px',
							bottom: '0px',
							bounce: 'vertical'
						},
			      		extras:{}//额外扩展参数
				    }]
					
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
					var tab1 = doc.getElementById('tab1');
					tab1.addEventListener('tap', function(event) {
						var wo = plus.webview.getWebviewById( "indexSubSub" );
						alert(wo.getElementById("item1mobile").innerHTML);
					}, false);
					
				});
				

				
				
			})(mui, document);
		</script>
</body>
</html>