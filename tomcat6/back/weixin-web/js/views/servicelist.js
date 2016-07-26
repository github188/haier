var _pageSize = 20;
$(function () {
 	initBtn();
});

function initBtn()
{
	var openId = $("#openId").val();
	$.ajax({
		type:"GET",
		// url:"http://hrfwtest.haier.net/api/haier/1.0/wxuser/isExist/"+openId,
		url:"wxuser?type=isExist&openId="+openId,
		// contentType: "application/json; charset=utf-8",
		// dataType:"json",
		success:function(data){
			var user_id = typeof(data.info.user_id) != 'undefined' ? data.info.user_id : '';
			if( ! user_id.length ) {
				window.location.href='register.jsp?openId='+openId;
			} else {
				$("#user_id").val(user_id);
				initList(1, 1);
			}
		}
	});

}
function initList(offset, status)
{
	offset = typeof(offset)=="undefined" ? 1 : parseInt(offset);
	var user_id = parseInt($("#user_id").val());
	var jsonData = {
		"user_id":user_id,
		"status":status,
		"pageNumber":offset,
		"pageSize":_pageSize
	}
	$.ajax({ 
		type:"POST", 
		// url:"http://115.28.231.67:3027/api/haier/1.0/order/getOrderList",
		url:"serviceOrderList",
		// contentType: "application/json; charset=utf-8",
		// dataType:"json", 
		data: jsonData,
		success:function(data){
	   		var code = typeof data.code != 'undefined' ? data.code : '';
	   		if(code.toString() == '0') {
	   			//返回成功
	   			var count = data.count;
	   			var html = '';
	   			var service_type_name = '';
	   			$.each( data.messages, function(i, n){
		   			service_type_name = n.service_type == 'T01' ? '安装' : (n.service_type == 'T02'?'维修 ':'移机' );
		   			html += '<li>';''
					html += '	<div class="service-title clearfix">';
					html += '		<div class="service-type">'+service_type_name+'</div>	';
					html += '		<div class="service-phone">'+n.order_code+'</div>';
					html += '		<div class="service-time">预约时间 '+time2Ymd(n.require_service_date)+" "+n.service_time+'</div>	';
					html += '	</div>';
					html += '	<div class="service-title clearfix">';
					html += '		<div class="service-type">预约时间</div>	';
					html += '		<div class="service-phone">'+time2Ymd(n.require_service_date)+" "+n.service_time+'</div>	';
					html += '	</div>';
					html += '	<div class="service-content clearfix">';
					html += '		<div class="detaillink"><a href="service_tree.jsp?order_code='+encodeURI(n.order_code)+'&service_type_name='+encodeURI(encodeURI(service_type_name))+'&address='+encodeURI(n.address)+'&contact_name='+encodeURI(n.contact_name)+'&mobile_phone='+encodeURI(n.mobile_phone)+'&product_name='+encodeURI(encodeURI(n.product_name))+'&type_name='+encodeURI(encodeURI(n.type_name))+'&service_time='+encodeURI(n.service_time)+'&statusDesc='+encodeURI(encodeURI(n.statusDesc))+'&require_service_desc='+encodeURI(encodeURI(n.require_service_desc))+'">追踪</a></div>';
					html += '		<div class="service-item clearfix">';
					html += '			<div class="service-content-pic"><img src="images/service/product.png" style="width:80px;"></div>';
					html += '			<div class="service-content-text">';
					html += '				<div class="name">'+n.product_name+' '+n.type_name+'</div>';
					html += '				<div class="company">'+n.address+'</div>';
					html += '				<div class="man clearfix">';
					html += '					<span>服务兵：'+n.contact_name+' '+n.mobile_phone+'</span>';
					//html += '					<a name="icon-phone" class="mui-icon" href=""></a>';
					html += '				</div>';
					html += '			</div>';
					html += '		</div>';
					html += '	</div>';
					html += '</li>';
				});
				$("#servicelist_"+status).html(html);
				var p = new ShowPage();
				p.CurrPage = offset;
				$("#pagelist_"+status).html(p.show("","","页次:","/","","页&nbsp;","&nbsp;每页","条&nbsp;","&nbsp;共","个记录<br>","首页","上一页","下一页","尾页","","","","","","","","","",count,_pageSize,4));
				$("#pagelist_"+status).attr("ncnt", count).attr("count", _pageSize).attr("data_status", status);
				bindPage(status);
		   		} else {
		   			mui.toast('服务单数据获取失败');
		   		}
	   	}
	});
	
}
function bindPage(status){
	$("#pagelist_"+status+" a").each(function() {
		$(this).bind("click", function(){
			initList($(this).attr("page"), status);
		})
	});
}

function time2Ymd(time){
	var date = new Date(time);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds();
	return Y+M+D;
}

