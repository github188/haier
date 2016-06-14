$(function () {
 initBtn();
});


function initBtn(){
	
	//设置默认
	$("input[id^='address_radio']").bind('click', function(){
		if($(this).attr("checked") == 'checked') {
			return false;
		}
		$(".deliver-address-item label").html('设为默认');
		$(this).parent().find("label").html('默认地址');
		mui.toast('设置默认地址成功');
	});
	
	//删除
	$("a[name='address-del']").bind('click', function(){
		var id = $(this).attr("attr_id");
  		$("#address_"+id).remove();
		mui.toast('删除地址成功');
		
	});
	
	//编辑地址
	$("#editAddressBtn").bind('click', function(){
		var contact_name = $.trim($("#contact_name).val());
	  	var contact_phone = $.trim($("#contact_phone").val());
	  	var sheng = $.trim($("#sheng-hidden").val());
	  	var shi = $.trim($("#shi-hidden").val());
	  	var areaxian = $.trim($("#area-hidden").val());
	  	var address = $.trim($("#address").val());
	  	
	  	if(contact_name == '') {
	  		mui.alert('请填写联系人', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
		if(contact_phone == '') {
	  		mui.alert('请联系电话', '输入提示', function() 
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
	  	if(areaxian == '') {
	  		mui.alert('请输入区', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	if(address == '') {
	  		mui.alert('请填写详细地址', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
	  	var jsonData = {
			"contact_name":contact_name,
			"contact_phone":contact_phone,
			"sheng":sheng,
			"shi":shi,
			"area":areaxian,
			"address":address
		}
	
		$.ajax({ 
			type:"POST", 
			url:"http://hrfwtest.haier.net/api/haier/1.0/order/newOrder", 
			contentType: "application/json; charset=utf-8",
			dataType:"json", 
			data: JSON.stringify(jsonData),
			success:function(data){
		   		mui.toast('地址信息提交成功');
		   	}
		});
	
	});
}
