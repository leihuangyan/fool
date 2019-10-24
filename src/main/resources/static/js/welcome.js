layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user'], function(){
    var $ = layui.$
        ,admin = layui.admin
        ,form = layui.form;
    form.render();
    //提交
    form.on('submit(LAY-user-login-submit)', function(obj){
        //请求登入接口
        admin.req({
            url: '/login'
            ,data: obj.field
            ,type:'post'
            ,dataType:'json'
            ,done: function(res){
                //登入成功的提示与跳转
                if(0==res.code){
                    layer.msg(res.msg, {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        location.href = '../index'; //后台主页
                    });
                }
            }
        });

    });

    //实际使用时记得删除该代码
    layer.msg('欢迎到来！！！', {
        offset: '15px'
        ,icon: 1
    });
});