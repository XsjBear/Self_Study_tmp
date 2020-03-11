/**
  项目JS主入口
  以依赖layui的layer和form模块为例
**/    
/*layui.use(['form', 'layedit', 'laydate'], function(){*/
layui.define(['layer', 'form','layedit', 'laydate'], function(exports){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate
  ,$ = layui.jquery;
  
  var state = null;
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
	  //获取公开身份开关的选择状态
	  state = this.checked ? 'true' : 'false';
  });
  
  
  //监听提交
  form.on('submit(demo1)', function(data){
    var Info = JSON.stringify(data.field);
    var targetDescription = $(".targetDescription").val();
    $.post("SF/addFriendInfo" , {Info:Info,targetDescription:targetDescription} ,function(data){
    	if(data == 1){
    		window.location.href=$.cookie("url");
    		//跳转回到原界面
    	}else{
    		//提示用户添加失败
    	}
    },"json");
    
    layer.alert(Info + "  " + targetDescription);
    return false;
  });
  
  
  exports('SelfInfo', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
}); 