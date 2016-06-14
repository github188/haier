var _city_data = {};
var _begin_hour = 8;	//早八点
var _end_hour = 20;	//晚八点
var _time_data = [];
$(function () {
 	initCity();
});



function initTime(){
	_time_data = [];
	var newdate = $("#newdate-hidden").val();
	if(newdate != '') {
		var begin_hour = _begin_hour;
		var bTime = true;
		var myDate = new Date();
		var date= new Date(Date.parse(newdate.replace(/-/g,  "/"))); //转换成Data();
		if(date.toLocaleDateString() ==  myDate.toLocaleDateString()) {
			//选择当天
			var cur_hour = myDate.getHours();
			if(cur_hour >= (_end_hour-3)) {
				//当前时间3小时候已经超过20点 不可选择
				bTime = false;
			} else {
				begin_hour = (cur_hour+3)>begin_hour ? (cur_hour+3) : begin_hour;
			}
		}
		if(bTime) {
			var fhour = '';
			var thour = '';
			var o = {};
			for(var i=begin_hour;i<_end_hour;i++){
				fhour = i.length == 1 ? '0'+i.toString() : i.toString();
				thour = (i+1).length == 1 ? '0'+(i+1).toString() : (i+1).toString();
				o = {"value":fhour + ':00-' + thour + ':00',"text":fhour + ':00~' + thour + ':00'};
				_time_data.push(o);
			}
		}
	}	
}

function initCity(){
	$.ajax({
		type:"POST", 
		url:"data/city.json", 
		dataType:"json", 
		success:function(data){
	   		_city_data = data;
		}
	}); 
}

function ajax_time_Data(obj){
	initTime();
	userPicker.setData(_time_data);
	userPicker.show(function(items) {
		obj.innerText = items[0].text;
		var id = obj.getAttribute("id");
		$("#"+id+"-hidden").val(items[0].value);
		$(obj).css("color","#000"); 
	});
}

function ajax_pinpai_Data(obj){
	$.ajax({
		type:"get",
	//	url:"../data/pinpai.json",
	// 	url:"http://localhost:9090/api/haier/1.0/common/getBrandList",
		url:"common?type=brand",
		headers : {
			"abc":"xy",
			"type":"wx"
		},
		// dataType:"json",
		success:function(data){
			var infoArray = data.info;
	   		userPicker.setData(infoArray);
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
			});
		},
		error:function(){}
	});
}
function ajax_type1_Data(obj){
	var pinpaiCode = $("#pinpai-hidden").val();
	$.ajax({ 
		type:"get", 
		// url:"http://hrfwtest.haier.net/api/haier/1.0/common/getTypeList/"+pinpaiCode,
		url:"common?type=type&code="+pinpaiCode,
		// dataType:"json",
		success:function(data){
			var infoArray = data.info;
	   		userPicker.setData(infoArray);
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
			});
		}
	}); 
}
function ajax_type2_Data(obj){
	var type1Code = $("#type1-hidden").val();
	//alert(type1Code);
	$.ajax({ 
		type:"get", 
		// url:"http://hrfwtest.haier.net/api/haier/1.0/common/getSubTypeList/"+type1Code,
		url:"common?type=subType&code="+type1Code,
		// dataType:"json",
		success:function(data){
			var infoArray = data.info;
	   		userPicker.setData(infoArray);
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
			});
		}
	}); 
}

function ajax_area_Data(obj){
	/*$.ajax({ 
		type:"POST", 
		url:"data/city.json", 
		dataType:"json", 
		success:function(data){
	   		alert(data);
	   		userPicker.setData(data);
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
				$(obj).css("color","#000"); 
			});
			
		}
	});*/
	userPicker.setData(_city_data);
	userPicker.show(function(items) {
		obj.innerText = items[0].text;
		var id = obj.getAttribute("id");
		$("#"+id+"-hidden").val(items[0].value);
		$(obj).css("color","#000"); 
	});
	
}
function ajax_shi_Data(obj,sheng_val){
	/*$.ajax({ 
		type:"POST", 
		url:"data/city.json", 
		dataType:"json", 
		success:function(data){
			$.each(data, function(i,n) {
				if(n.value == sheng_val){
					userPicker.setData(n.sub);
					return false;
				}
			});
			
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
				$(obj).css("color","#000"); 
			});
		}
	});*/
	$.each(_city_data, function(i,n) {
		if(n.value == sheng_val){
			userPicker.setData(n.sub);
			return false;
		}
	});
	
	userPicker.show(function(items) {
		obj.innerText = items[0].text;
		var id = obj.getAttribute("id");
		$("#"+id+"-hidden").val(items[0].value);
		$(obj).css("color","#000"); 
	});
}

function ajax_areaa_Data(obj,sheng_val,shi_val){
	/*$.ajax({ 
		type:"POST", 
		url:"data/city.json", 
		dataType:"json", 
		success:function(data){
			var shi_array = new Array();
			$.each(data, function(i,n) {
				if(n.value == sheng_val){
					shi_array = n.sub;
					return false;
				}
			});
			$.each(shi_array, function(i,n) {
				if(n.value == shi_val){
					userPicker.setData(n.sub);
					return false;
				}
			});
			
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
				$(obj).css("color","#000"); 
			});
		}
	});*/
	var shi_array = new Array();
	$.each(_city_data, function(i,n) {
		if(n.value == sheng_val){
			shi_array = n.sub;
			return false;
		}
	});
	$.each(shi_array, function(i,n) {
		if(n.value == shi_val){
			userPicker.setData(n.sub);
			return false;
		}
	});
	
	userPicker.show(function(items) {
		obj.innerText = items[0].text;
		var id = obj.getAttribute("id");
		$("#"+id+"-hidden").val(items[0].value);
		$(obj).css("color","#000"); 
	});
}

function addData(){
	var user_id = $("#user_id").val();
	var openId = $("#openId").val();
	if(user_id == '') {
		//判断用户是否存在,user_id为空说明不存在,需用跳转注册页面
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
		   			sendData();
		   		}
		   	}
		});
	} else {
		sendData();
	}
}

function sendData(){
	var infoaddress = $("#infoaddress").val();
	$("#infoaddress-hidden").val($("#sheng-hidden").val()+$("#shi-hidden").val()+$("#area-hidden").val()+infoaddress);
	//var jsonData = $("#item1mobile :input").serializeArray();
	if($("#item1mobile").hasClass("mui-active")) {
	  	//新机报装
	  	var pinpai = $.trim($("#pinpai-hidden").val());
	  	var type1 = $.trim($("#type1-hidden").val());
	  	var type2 = $.trim($("#type2-hidden").val());
	  	var contact = $.trim($("#contact").val());
	  	var phone = $.trim($("#phone").val());
	  	var Address = $.trim($("#Address-hidden").val());
	  	var sheng = $.trim($("#sheng-hidden").val());
	  	var shi = $.trim($("#shi-hidden").val());
	  	var area = $.trim($("#area-hidden").val());
	  	var infoaddress = $.trim($("#infoaddress").val());
	  	var newdate = $.trim($("#newdate-hidden").val());
	  	var newtime = $.trim($("#newdate-front-after-hidden").val());

	  	if(pinpai == '') {
	  		mui.alert('请输入产品品牌', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
			if(type1 == '') {
	  		mui.alert('请输入产品大类', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(type2 == '') {
	  		mui.alert('请输入产品子类', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(contact == '') {
	  		mui.alert('请输入联系人', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(phone == '') {
	  		mui.alert('请输入联系电话', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	} else {
	  		if(!isphone1(phone) && !isphone2(phone)) {
	  			mui.alert('请输入有效的联系电话', '输入提示', function()
			    {
			      return false;
			    });
			    return false;
	  		}
	  	}
	  	/*
	  	if(Address == '') {
	  		mui.alert('请输入服务地址', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	*/
	  	if(sheng == '') {
	  		mui.alert('请输入省', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(shi == '') {
	  		mui.alert('请输入市', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(area == '') {
	  		mui.alert('请输入区', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(infoaddress == '') {
	  		mui.alert('请输入详细地址', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newdate == '') {
	  		mui.alert('请输入预约日期', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newtime == '') {
	  		mui.alert('请输入预约时间', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	var bTime = checkTime(newdate, newtime);
	  	if(!bTime){
	  		mui.alert('预约时间应在当前时间3个小时之后', '输入提示', function()
		    {
		      return false;
		    });
		    return false;
	  	}
	  	
	} else {
	  	//移机报装
	  	var pinpai = $.trim($("#yjbz-pinpai-hidden").val());
	  	var type1 = $.trim($("#yjbz-type1-hidden").val());
	  	var type2 = $.trim($("#yjbz-type2-hidden").val());
	  	var contact = $.trim($("#yjbz-contact-hidden").val());
	  	var phone = $.trim($("#yjbz-phone-hidden").val());
	  	var Address = $.trim($("#yjbz-Address-hidden").val());
	  	var sheng = $.trim($("#yjbz-sheng-hidden").val());
	  	var shi = $.trim($("#yjbz-shi-hidden").val());
	  	var area = $.trim($("#yjbz-area-hidden").val());
	  	var newAddress = $.trim($("#yjbz-newAddress-hidden").val())
	  	var newsheng = $.trim($("#yjbz-newsheng-hidden").val());
	  	var newshi = $.trim($("#yjbz-newshi-hidden").val());
	  	var newarea = $.trim($("#yjbz-newarea-hidden").val())
	  	var newdate = $.trim($("#yjbz-newdate-hidden").val());
	  	var newtime = $.trim($("#yjbz-newdate-front-after-hidden").val());
	
	  	if(pinpai == '') {
	  		mui.alert('请输入产品品牌', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
			if(type1 == '') {
	  		mui.alert('请输入产品大类', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(type2 == '') {
	  		mui.alert('请输入产品子类', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(contact == '') {
	  		mui.alert('请输入联系人', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(phone == '') {
	  		mui.alert('请输入联系电话', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	} else {
	  		if(!isphone1(phone) && !isphone2(phone)) {
	  			mui.alert('请输入有效的联系电话', '输入提示', function() 
			    {
			      return false;
			    });
			    return false;
	  		}
	  	}
	  	if(Address == '') {
	  		mui.alert('请输入旧地址', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(sheng == '') {
	  		mui.alert('请输入省', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(shi == '') {
	  		mui.alert('请输入市', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(area == '') {
	  		mui.alert('请输入区', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newAddress == '') {
	  		mui.alert('请输入新地址', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newsheng == '') {
	  		mui.alert('请输入省', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newshi == '') {
	  		mui.alert('请输入市', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newarea == '') {
	  		mui.alert('请输入区', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newdate == '') {
	  		mui.alert('请输入预约日期', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(newtime == '') {
	  		mui.alert('请输入预约时间', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	}
	
	var jsonData = {
		"product_id":$("#type2-hidden").val(),
		"service_type":"T02",
		"require_service_date":$("#newdate-hidden").val(),
		"contact_name":$("#contact").val(),
		"mobile_phone":$("#phone").val(),
		"district":$("#area-hidden").val(),
		"require_service_desc":"hardcode",
		"service_time":$("#newdate-front-after-hidden").val(),
		"address":$("#infoaddress").val(),
		"user_id":$("#user_id").val()
	}

	//jQuery.each( jsonData, function(i, field){
	//	  alert(field.value);
	//});
//	alert(JSON.stringify(jsonData));
	$.ajax({ 
		type:"POST", 
		// url:"http://hrfwtest.haier.net/api/haier/1.0/order/newOrder",
		url:"serviceOrder",
		// contentType: "application/json; charset=utf-8",

		// dataType:"json",
		data: jsonData,
		success:function(data){
	   //		mui.toast('信息提交成功');
	   		var btnArray = ['确认', '取消'];
		    mui.confirm('您的服务单已经提交成功，服务兵将尽快与您联系，感谢等待！', '提交服务单', btnArray, function(e) 
		    {		    	 
		        if (e.index == 1) 
		        {
		        	 window.location.href='index.jsp?openId='+openId;
		         //   info.innerText = '取消';
		         
		        } 
		        else 
		        {
		        	window.location.href='index.jsp?openId='+openId;
		         //   info.innerText = '确认';
		        }
		    });
	   	}
	});
}

function addMaintenceData(){
	var infoaddress = $("#infoaddress").val();
	$("#infoaddress-hidden").val($("#sheng-hidden").val()+$("#shi-hidden").val()+$("#area-hidden").val()+infoaddress);
	//var jsonData = $("#item1mobile :input").serializeArray();
	
   	var pinpai = $.trim($("#pinpai-hidden").val());
  	var type1 = $.trim($("#type1-hidden").val());
  	var type2 = $.trim($("#type2-hidden").val());
  	var infowrong = $.trim($("#infowrong").val());
  	var contact = $.trim($("#contact").val());
  	var phone = $.trim($("#phone").val());
  	var Address = $.trim($("#Address").val());
  	var sheng = $.trim($("#sheng-hidden").val());
  	var shi = $.trim($("#shi-hidden").val());
  	var area = $.trim($("#area-hidden").val());
  	var newdate = $.trim($("#newdate-hidden").val());
  	var newtime = $.trim($("#newdate-front-after-hidden").val());
  	
  	if(pinpai == '') {
  		mui.alert('请输入产品品牌', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
		if(type1 == '') {
  		mui.alert('请输入产品大类', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(type2 == '') {
  		mui.alert('请输入产品小类', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(infowrong == '') {
  		mui.alert('请输入故障描述', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(contact == '') {
  		mui.alert('请输入联系人', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(phone == '') {
  		mui.alert('请输入联系电话', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	/*
  	if(Address == '') {
  		mui.alert('请输入服务地址', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	*/
  	if(sheng == '') {
  		mui.alert('请输入省', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(shi == '') {
  		mui.alert('请输入市', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(area == '') {
  		mui.alert('请输入区', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(infoaddress == '') {
  		mui.alert('请输入详细地址', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newdate == '') {
  		mui.alert('请输入预约日期', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newtime == '') {
  		mui.alert('请输入预约时间', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	var bTime = checkTime(newdate, newtime);
  	if(!bTime){
  		mui.alert('预约时间应在当前时间3个小时之后', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  		
	var jsonData = {
		"product_id":$("#type2-hidden").val(),
		"service_type":"T01",
		"require_service_date":$("#newdate-hidden").val(),
		"contact_name":$("#contact").val(),
		"mobile_phone":$("#phone").val(),
		"district":$("#area-hidden").val(),
		"require_service_desc":infowrong,
		"service_time":$("#newdate-front-after-hidden").val(),
		"address":$("#infoaddress").val(),
		//"infowrong":infowrong,
	};
	
 	alert(jsonData.require_service_desc);

	//jQuery.each( jsonData, function(i, field){
	//	  alert(field.value);
	//});
	//alert(JSON.stringify(jsonData));
	$.ajax({ 
		type:"POST", 
		// url:"http://hrfwtest.haier.net/api/haier/1.0/order/newOrder",
		url:"serviceOrder",
		// contentType: "application/json; charset=utf-8",
		// dataType:"json",
		data: jsonData,
		success:function(data){
	   //		mui.toast('信息提交成功');
	   		var btnArray = ['确认', '取消'];
		    mui.confirm('您的服务单已经提交成功，服务兵将尽快与您联系，感谢等待！', '提交服务单', btnArray, function(e) 
		    {		    	
		    		
		        if (e.index == 1) 
		        {
		        	 
		         //   info.innerText = '取消';
		         
		        } 
		        else 
		        {
		        	window.location.href='maintence.jsp?openId='+openId;
		         //   info.innerText = '确认';
		        }
		    });
	   	}
	});
}


/*判断输入是否为合法的手机号码*/
 function isphone2(inpurStr)
 {
      var partten = /^1[3,5,8]\d{9}$/;
      var fl=false;
      if(partten.test(inpurStr))
      {
           //alert('是手机号码');
           return true;
      }
      else
      {
           return false;
           //alert('不是手机号码');
      }
 }
 /*判断输入是否为合法的电话号码，匹配固定电话或小灵通*/
 function isphone1(inpurStr)
 {
      var partten = /^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$/;
      if(partten.test(inpurStr))
      {
           //alert('是电话号码');
           return true;
      }
      else
      {
           //alert('不是电话号码');
           return false;
      }
 }
 
function checkTime(newdate, newtime)
{
 	var ret = true;
 	var myDate = new Date();
	var date= new Date(Date.parse(newdate.replace(/-/g,  "/"))); //转换成Data();
	if(date.toLocaleDateString() ==  myDate.toLocaleDateString()) {
		//当天
		var cur_hour = myDate.getHours();
		var aTime = newtime.split(":");
		var sel_hour = aTime[0];
		if((cur_hour+3) > sel_hour) {
			//时间不在3小时之后
			ret = false;
		}
	}
	return ret;
}