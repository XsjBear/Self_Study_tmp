/*//获取元素
var  $username = $("#username");
//输出到控制台
console.log($username);

//用户名验证
//失去焦点事件
$("#username").blur (function(){
	//获取用户输入的用户名
	var username = $("#username").val();
	console.log(username);
	//判断用户名的格式
	if(username == '' ){
		console.log("用户不能为空");
		//给当前对象的下一个标签设值
		$(this).next().html("用户不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
	//正则表达式
	//创建一个规则
	var reg = /^\w{6,15}$/;
	//判断
	
	var flag = reg.test(nickname);
	console.log(flag);
	
	if( !reg.test(nickname)){
		//给当前对象的下一个标签设值
		$(this).next().html("用户名必须是6-15位的英文或数字");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
});

//聚焦事件
$("#nickname").focus(function(){
	//隐藏
	$(this).next().hide();
})


//密码验证	
//失焦事件
$("#pwd").blur(function(){
	check_pwd();	
});

//聚焦事件
$("#pwd").focus(function(){
	$(this).next().hide();
});
	
function check_pwd(){
	//获取密码
	var pwd = $("#pwd").val();
	//规则
	var reg = /^[\w@!#$%^&*~]{6,15}$/;
	//判断
	if(!reg.test(pwd)){
		$("#pwd").next().html("密码不符合规范");
		$("#pwd").next().show();
	}
}

//确认密码验证
//失焦事件
$("#cpwd").blur(function(){
	check_cpwd();	
});

//聚焦事件
$("#cpwd").focus(function(){
	$(this).next().hide();
});
	
function check_cpwd(){
	//获取原密码
	var pwd = $("#pwd").val();
	//获取再次输入的密码
	var cpwd = $("#cpwd").val();
	
	//判断
	if(cpwd == ''){
		$("#cpwd").next().html("确认密码不能为空");
		$("#cpwd").next().show();
	}
	if(cpwd != pwd){
		$("#cpwd").next().html("两次输入的密码不一致");
		$("#cpwd").next().show();
	}
}

//手机号码验证
//失焦事件
$("#tel").blur(function(){
	check_tel();	
});

//聚焦事件
$("#tel").focus(function(){
	$("#tel").next().next().hide();
});
	
function check_tel(){
	//获取电话号码
	var tel = $("#tel").val();
	//规则
	var reg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
	
	if( !reg.test(tel)){
		$("#tel").next().next().html("手机号码格式错误");
		$("#tel").next().next().show();
	}
}

$("#email").blur(function(){
	if($.trim($(this).val())==""){
		$("#email").next().text("邮箱不能为空").show();
	}
});

//聚焦事件
$("#email").focus(function(){
	$("#email").next().hide();
});*/

//获取验证码
$("#getCode").click(function(){
	var email = $("#mail").val();
	var username = $("#realname").val();
	if(email == ""){
		$("#email").blur();
		return;
	}
	if(username == ""){
		$("#realname").blur();
		return;
	}
	
	$.post("../initial/code",{email:email,name:username},function(data){
		console.info(data);
		data = parseInt($.trim(data));		
		if(data > 0){
			$("#getCode").attr("disabled","true");
			//倒计时
			var time  = 180;
			var timeTask = setInterval(function(){
				if(time >0 ){
					time --;
					$("#getCode").val( time + "S");
				}else{
					$("#getCode").removeAttr("disabled").val("重新发送");
					clearInterval(timeTask);
				}
			},1000);
		}else{
			$("#getCode").removeAttr("disabled").val("重新获取");
			$("#getCode").next().next().html("验证码发送失败");
		}
	},"text");              
})

//$("input").focus(function(){
//	alert("获取焦点");
//})
//
//$("input").blur(function(){
//	alert("失去焦点");
//})




//点击注册响应方法
function reg(){
	var nickname =$.trim($("#nickname").val());
	var realName =$.trim($("#realname").val());
	var birthday =$.trim($("#birthday").val());
	var sex =$.trim($("#sex").val());
	var tel =$.trim($("#tel").val());
	var qq =$.trim($("#qq").val());
	var Wechat =$.trim($("#Wechat").val());
	var school =$.trim($("#school").val());
	var stu_num =$.trim($("#stu_num").val());
	var major =$.trim($("#major").val());
	var class_num =$.trim($("#class_num").val());
	var mail =$.trim($("#mail").val());
	
//	var pwd =$.trim($("#pwd").val());
	var pwd =$.trim($('input[name="pwd"]').val());
	var code =$.trim($("#code").val());
	
	console.info("realname : " + realname);
	console.info("pwd : " + pwd);
//	$.post("../initial/reg",$("#myform").serialize(),function(data){}
	$.post("../initial/reg",{nickname:nickname, realname:realName , birthday:birthday , sex:sex , tel:tel , qq:qq , Wechat:Wechat , school:school , stu_num:stu_num , major:major , class_num:class_num ,  mail:mail , pwd:pwd , code:code},function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data == -2){
//			$("#yzm").next().next().text("验证码错误").show();
			alert("验证码输入错误，请重新输入...");
			$("#code").val("");
		}else if(data > 0){
			$("#myform")[0].reset();
			alert("注册成功,请登录...");
			location.href='login.html';
		}else{
			alert("注册失败,请稍后重试...");
		}
	},"text");
}

$(document).keydown(function(event){ //监听键盘按下时的事件
	if(event.keyCode == 13){
		if($("#Log").css("display") == "block"){
			userLogin();//如果用户点击了登陆界面的enter键，则执行登陆操作
		}
		if($("#Reg").css("display") == "block"){
			reg();//如果用户点击了注册界面的enter键，则执行注册操作
		}
	}
});

//点击登陆响应事件
function userLogin(){
	var tel =$.trim($("#account").val());
	var pwd = $.trim($("#pwd").val());
	if(account =="" || pwd == ""){
		alert("账号或者密码不能为空!!!!!")
		return;
	}
	$.post("../initial/Login",{tel:tel,pwd:pwd},function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data == 1){
			//输入正确，跳转至首页
//			/Self_Study/src/main/resources/templates/HomePage.html
//			/Self_Study/src/main/webapp/Page/js/register.js
			$.cookie("userTel" , tel  , { expires: 1 });	//将用户的电话号码存储到本地用以区别用户身份信息,有效期为一天
			location.href='../HomePage';
		}else if(data == -1){
			//账号或者密码输入错误，提示用户账号或者密码输入错误，并且清空账号输入框和密码输入框
			alert("账号或密码错误，请重新输入...");
			$("#account").val("");
			$("#pwd").val("");
		}
	},"text");
}


/**
 * 显示登录页
 * @returns
 */
function changeLoginStyle(){
	$("#Log").css("display" , "block");
	$("#Reg").css("display" , "none");
}

/**
 * 显示注册页
 * @returns
 */
function changeRegisterStyle(){
	$("#Log").css("display" , "none");
	$("#Reg").css("display" , "block");
}


/**
 * 修改标记的内容
 * @returns
 */
function changeVale(hidden_value){
	alert(flag.value);
	var flag = document.getElementById("flag");
	flag.value = hidden_value;
	alert(flag.value);
	
}
	
	