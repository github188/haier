$(function () {
 initBtn();
});
var countdown=10; 

function initBtn(){
	//密码输入框切换可见
	$("#register-icon-see").bind('click', function(){
		if ( $(this).hasClass("register-input-password-seeno") ) {
			$(this).removeClass("register-input-password-seeno");
			$(this).addClass("register-input-password-see");
			$("#password").attr("type", "text");
		} else {
			$(this).removeClass("register-input-password-see");
			$(this).addClass("register-input-password-seeno");
			$("#password").attr("type", "password");
		}
	});
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
	  	settime();
	});
	
	//注册
	$("#sendRegister").bind('click', function(){
		var phone = $.trim($("#phone").val());
  		var pass = $.trim($("#password").val());
  		var checkcode = $.trim($("#checkcode").val());
  		var agree = $("#agree").val());
  		
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
  		if(checkcode == '') {
	  		mui.alert('请输入验证码', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		if($("#agree").attr("checked") != true) {
	  		mui.alert('请先阅读并同意服务协议', '输入提示', function() 
		    {
		      return false;
		    });
		    return false;
	  	}
  		var jsonData = {
			"phone":phone,
			"password":pass,
			"checkcode":checkcode
		};
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
			    mui.confirm('您的注册信息已经提交成功', '提交注册', btnArray, function(e) 
			    {		    	
			    		
			        if (e.index == 1) 
			        {
			        	 
			         //   info.innerText = '取消';
			         
			        } 
			        else 
			        {
			        	window.location.href='../../maintence.jsp';
			         //   info.innerText = '确认';
			        }
			    });
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
        countdown = 10; 
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



