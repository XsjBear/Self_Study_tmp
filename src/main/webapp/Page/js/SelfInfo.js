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
    /*layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });*/
	  //获取公开身份开关的选择状态
	  state = this.checked ? 'true' : 'false';
  });
  
  //赋值方法
	  $(function() {

		// window.location.href = "PageLoad";

		$.post("PageLoad", {}, function(data) {
			layer.msg(data);
			if (data.userInfo == null) {
				layer.msg("您当前尚未填写相关信息，请您先完善相关信息!!!!")
			} else {
//				form.val('example', {
//					"username" : "贤心" // "name": "value"
//					,
//					"password" : "123456",
//					"interest" : 1,
//					"like[write]" : true // 复选框选中状态
//					,
//					"close" : true // 开关状态
//					,
//					"sex" : "女",
//					"desc" : "我爱 layui"
//				});
			}
		}, "json")
	});
  
  
  exports('SelfInfo', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
}); 