function ajax_pinpai_Data(obj){
	$.ajax({ 
		type:"get", 
		//url:"data/pinpai.json",
		url:"http://115.28.231.67:9090/api/haier/1.0/common/getBrandList",
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
		url:"http://115.28.231.67:9090/api/haier/1.0/common/getTypeList/"+pinpaiCode, 
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
		url:"http://115.28.231.67:9090/api/haier/1.0/common/getSubTypeList/"+type1Code, 
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
		url:"http://115.28.231.67:9090/api/haier/1.0/order/newOrder", 
		contentType: "application/json; charset=utf-8",
		dataType:"json", 
		data: JSON.stringify(jsonData),
		success:function(data){
	   		alert("Success");
	   	}
	});
}
