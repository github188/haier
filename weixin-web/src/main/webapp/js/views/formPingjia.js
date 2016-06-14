$(function () {
 initBtn();
});


function initBtn(){
	
	//点赞
	$("#tap_dianzan a").bind('click', function(){
		var cur_class = $(this).attr("class");
		$("#tap_dianzan a").each(function(){
			var pre_class = $(this).attr("class");
			$(this).attr("class", pre_class.replace("-active",""));
		});
		$(this).attr("class", cur_class.replace("-active","")+'-active');
		var pj_value = $(this).attr("attr_zan");
		$("#dianzan-hidden").val(pj_value);
		if(pj_value == '3'){
			$("#tap_dianping-cha-detail").show();
		} else {
			$("#tap_dianping-cha-detail").hide();
		}
	});
	
	//提交评价
	$("#pingjiaBtn").bind('click', function(){
		var dianzan = $.trim($("#dianzan-hidden").val());
  		var pingjiatxt = $.trim($("#mypingjia").val());
  		var chaReason = dianzan == '3' ? $("input[name='dianpin-cha-reason']:checked").val():'';
  		mui.toast('您的评价发布成功');return false;
  		var jsonData = {
			"dianzan":dianzan,
			"pingjiatxt":pingjiatxt,
			"cha-reason":chaReason,
		};
		//alert(JSON.stringify(jsonData));
		$.ajax({ 
			type:"POST", 
			url:"http://hrfwtest.haier.net/api/haier/1.0/order/newOrder", 
			contentType: "application/json; charset=utf-8",
			dataType:"json", 
			data: JSON.stringify(jsonData),
			success:function(data){
		   		mui.toast('您的评价发布成功');
		   	}
		});
	});
	
	//语音录入评价
	$("#yuyinBtn").bind('click', function(){
		alert('语音录入');
	
	});
}
