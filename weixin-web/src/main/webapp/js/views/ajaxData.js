function ajax_pinpai_Data(obj){
	$.ajax({ 
		type:"get", 
	//	url:"../data/pinpai.json",
		url:"http://115.28.231.67:3027/api/haier/1.0/common/getBrandList",
		dataType:"json", 
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
		url:"http://115.28.231.67:3027/api/haier/1.0/common/getTypeList/"+pinpaiCode, 
		dataType:"json", 
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
		url:"http://115.28.231.67:3027/api/haier/1.0/common/getSubTypeList/"+type1Code, 
		dataType:"json", 
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
	$.ajax({ 
		type:"POST", 
		url:"data/city.json", 
		dataType:"json", 
		success:function(data){
	   		userPicker.setData(data);
	   		userPicker.show(function(items) {
				obj.innerText = items[0].text;
				var id = obj.getAttribute("id");
				$("#"+id+"-hidden").val(items[0].value);
				$(obj).css("color","#000"); 
			});
			
		}
	}); 
}
function ajax_shi_Data(obj,sheng_val){
	$.ajax({ 
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
	}); 
}

function ajax_areaa_Data(obj,sheng_val,shi_val){
	$.ajax({ 
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
	}); 
}

function addData(){
	$("#newdate-front-after-hidden").val($("#newdate-font-hidden").val() + "-" +$("#newdate-after-hidden").val());
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
  	var newdate = $.trim($("#newdate-hidden").val());
  	var newdate_font = $.trim($("#newdate-font-hidden").val());
  	var newdate_after = $.trim($("#newdate-after-hidden").val());
  	
  	if(pinpai == '') {
  		mui.alert('请输入品牌', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
		if(type1 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(type2 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
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
  	if(newdate == '') {
  		mui.alert('请输入预约日期', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newdate_font == '') {
  		mui.alert('请输入服务开始时间', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newdate_after == '') {
  		mui.alert('请输入服务截止时间', '输入提示', function() 
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
  	var newtime = $.trim($("#yjbz-newtime-hidden").val());

  	if(pinpai == '') {
  		mui.alert('请输入品牌', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
		if(type1 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(type2 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
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
  		mui.alert('请输入预约日期小时', '输入提示', function() 
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
		"address":$("#infoaddress-hidden").val()
	}

	//jQuery.each( jsonData, function(i, field){
	//	  alert(field.value);
	//});
	//alert(JSON.stringify(jsonData));
	$.ajax({ 
		type:"POST", 
		url:"http://115.28.231.67:3027/api/haier/1.0/order/newOrder", 
		contentType: "application/json; charset=utf-8",
		dataType:"json", 
		data: JSON.stringify(jsonData),
		success:function(data){
	   //		mui.toast('信息提交成功');
	   		var btnArray = ['确认', '取消'];
		    mui.confirm('您的服务单已经提交成功，服务将尽快与您联系，感谢等待！', '提交服务单', btnArray, function(e) 
		    {		    	 
		        if (e.index == 1) 
		        {
		        	 
		         //   info.innerText = '取消';
		         
		        } 
		        else 
		        {
		        	window.location.href='index.html';
		         //   info.innerText = '确认';
		        }
		    });
	   	}
	});
}



function addMaintenceData(){
		$("#newdate-front-after-hidden").val($("#newdate-font-hidden").val() + "-" +$("#newdate-after-hidden").val());
	var infoaddress = $("#infoaddress").val();
	$("#infoaddress-hidden").val($("#sheng-hidden").val()+$("#shi-hidden").val()+$("#area-hidden").val()+infoaddress);
	//var jsonData = $("#item1mobile :input").serializeArray();
	
   	var pinpai = $.trim($("#pinpai-hidden").val());
  	var type1 = $.trim($("#type1-hidden").val());
  	var type2 = $.trim($("#type2-hidden").val());
  	var contact = $.trim($("#contact").val());
  	var phone = $.trim($("#phone").val());
  	var Address = $.trim($("#Address-hidden").val());
  	var sheng = $.trim($("#sheng-hidden").val());
  	var shi = $.trim($("#shi-hidden").val());
  	var area = $.trim($("#area-hidden").val());
  	var newdate = $.trim($("#newdate-hidden").val());
  	var newdate_font = $.trim($("#newdate-font-hidden").val());
  	var newdate_after = $.trim($("#newdate-after-hidden").val());
  	var wronginfo = $.trim($("#wrong-hidden").val());
  	
  	if(pinpai == '') {
  		mui.alert('请输入品牌', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
		if(type1 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(type2 == '') {
  		mui.alert('请输入类型', '输入提示', function() 
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
  	if(newdate == '') {
  		mui.alert('请输入预约日期', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newdate_font == '') {
  		mui.alert('请输入服务开始时间', '输入提示', function() 
	    {
	      return false;
	    });
	    return false;
  	}
  	if(newdate_after == '') {
  		mui.alert('请输入服务截止时间', '输入提示', function() 
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
		"require_service_desc":wronginfo,
		"service_time":$("#newdate-front-after-hidden").val(),
		"address":$("#infoaddress-hidden").val()
	};
	
 

	//jQuery.each( jsonData, function(i, field){
	//	  alert(field.value);
	//});
	//alert(JSON.stringify(jsonData));
	$.ajax({ 
		type:"POST", 
		url:"http://115.28.231.67:3027/api/haier/1.0/order/newOrder", 
		contentType: "application/json; charset=utf-8",
		dataType:"json", 
		data: JSON.stringify(jsonData),
		success:function(data){
	   //		mui.toast('信息提交成功');
	   		var btnArray = ['确认', '取消'];
		    mui.confirm('您的服务单已经提交成功，服务将尽快与您联系，感谢等待！', '提交服务单', btnArray, function(e) 
		    {		    	
		    		
		        if (e.index == 1) 
		        {
		        	 
		         //   info.innerText = '取消';
		         
		        } 
		        else 
		        {
		        	window.location.href='maintence.html';
		         //   info.innerText = '确认';
		        }
		    });
	   	}
	});
}
