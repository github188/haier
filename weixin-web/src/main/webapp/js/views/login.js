$(function () {
 initBtn();
});
var countdown=10; 

function initBtn(){
	
	//发送短信
	$("#sendMessage").bind('click', function(){
		if ( $(this).hasClass("sending") ) {
			return false;
		}
		var phone = $.trim($("#phone").val());
		if(phone == '') {
	  		mui.alert('请输入正确的手机号', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	} else {
	  		if(!isMobil(phone)){
	  			mui.alert('请输入正确的手机号', '输入提示', function() 
		  	  	{
		 	     return false;
		 	  	})	;
			    return false;
	  		}
	  	}
	  	$("#sendMessage").addClass("sending");
	  	$("#sendMessage").removeClass("nosend");
	  	$("#sendMessage").attr("disabled", true);
	  	settime();
	});
	
	//登录
	$("#loginBtn").bind('click', function(){
		var phone = $.trim($("#phone").val());
  		var pass = $.trim($("#password").val());
  		
  		
  		if(phone == '') {
	  		mui.alert('请输入正确的手机号', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		if(pass == '') {
	  		mui.alert('请输入密码', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		
  		var jsonData = {
			"phone":phone,
			"password":pass
		};
		//alert(JSON.stringify(jsonData));
		$.ajax({ 
			type:"POST", 
			url:"http://hrfwtest.haier.net/api/haier/1.0/order/newOrder", 
			contentType: "application/json; charset=utf-8",
			dataType:"json", 
			data: JSON.stringify(jsonData),
			success:function(data){
		   		mui.toast('登录成功');
		   		
		   	}
		});
	});
	
}


function settime() { 
    if (countdown == 0) { 
        $("#sendMessage").text("发送短信");
        $("#sendMessage").removeClass("sending");
        $("#sendMessage").addClass("nosend");
        $("#sendMessage").attr("disabled", false);
        countdown = 10; 
        return; 
    } else { 
        $("#sendMessage").text("重新发送(" + countdown + ")"); 
        countdown--; 
    } 
	setTimeout(function() { 
    	settime() }
    ,1000) 
}
function isMobil(s){
	var patrn=/^(\d+_\d+)|(1\d{10})$/;
	if (!patrn.exec(s)){
		return false
	} else {
		return true
	}
}

