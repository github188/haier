$(function () {
 initBtn();
});
var countdown=60; 

function initBtn(){
	//获取验证码
	$("#getCheckcode").bind('click', function(){
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
	  	$("#getCheckcode").addClass("sending");
	  	$("#getCheckcode").removeClass("nosend");
	  	$("#getCheckcode").attr("disabled", true);
	  	//发送短信获取验证码
	  	var openId = $("#openId").val();
		$.ajax({ 
			type:"GET", 
			// url:"http://hrfwtest.haier.net/api/haier/1.0/wxuser/sendCode/"+openId+"/"+phone,
			url:"wxuser?type=sendCode&openId="+openId+"&phone="+phone,
			// contentType: "application/json; charset=utf-8",
			// dataType:"json",
			success:function(data){
		   		
		   	}
		});
	  	settime();
	});
	
	//注册
	$("#sendRegister").bind('click', function(){
		var phone = $.trim($("#phone").val());
  		var checkcode = $.trim($("#checkcode").val());
  		var openId = $("#openId").val();
  		
  		if(phone == '') {
	  		mui.alert('请输入正确的手机号', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		if(checkcode == '') {
	  		mui.alert('请输入验证码', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		if($("#agree").attr("checked") != "checked") {
	  		mui.alert('请先阅读并同意服务协议', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
		$.ajax({ 
			type:"GET", 
			// url:"http://hrfwtest.haier.net/api/haier/1.0/wxuser/register/"+openId+"/"+phone+"/"+checkcode,
			url:"wxuser?type=register&openId="+openId+"&phone="+phone+"&code="+checkcode,
			// contentType: "application/json; charset=utf-8",
			// dataType:"json",
			success:function(data){
		   		var code = typeof(data.code) != 'undefined' ? data.code : '';
		   		if( code.toString() == '0' ) {
		   			mui.alert('您的注册信息提交成功', '提交注册', function() 
				    {
				      self.location=document.referrer+"?openId"+openId;
				    });
		   		} else {
		   			mui.alert('您的注册信息提交失败', '提交注册', function() 
				    {
				      //
				    });
				    return false;
		   		}
		   	}
		});
	});
	
}


function settime() { 
    if (countdown == 0) { 
        $("#getCheckcode").text("获取验证码");
        $("#getCheckcode").removeClass("sending");
        $("#getCheckcode").addClass("nosend");
        $("#getCheckcode").attr("disabled", false);
        countdown = 60; 
        return; 
    } else { 
        $("#getCheckcode").text("重新发送(" + countdown + ")"); 
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



