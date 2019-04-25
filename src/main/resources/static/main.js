layui.use(['element','layer','upload','laydate','form'], function () {
    var $ = layui.jquery;
    var element = layui.element; //加载element模块
    var layer = layui.layer; //加载layer模块
    var upload = layui.upload;  //加载upload模块
    var laydate = layui.laydate;
    var date = new Date();
    laydate.render({
        elem: '#calendar',
        min: (date .getFullYear()-100)+'-'+(date.getMonth()+1)+'-'+date .getDate(),
        max: date .getFullYear()+'-'+(date.getMonth()+1)+'-'+date .getDate()
    });

    /* 侧边栏开关 */
    $(".side-toggle").on("click", function (e) {
        e.preventDefault();
        var to = $(".layui-layout-admin");
        to.toggleClass("layui-side-shrink");
        to.attr("toggle") === 'on' ? to.attr("toggle", "off") : to.attr("toggle", "on");
    });
    $(".layui-side").on("click", function () {
        var to = $(".layui-layout-admin");
        if (to.attr("toggle") === 'on') {
            to.attr("toggle", "off");
            to.removeClass("layui-side-shrink");
        }
    });

    /* 最大化窗口 */
    $(".ggtt-screen-full").on("click", function (e) {
        e.preventDefault();
        if (!$(this).hasClass("full-on")) {
            var docElm = document.documentElement;
            var full = docElm.requestFullScreen || docElm.webkitRequestFullScreen ||
                docElm.mozRequestFullScreen || docElm.msRequestFullscreen;
            "undefined" !== typeof full && full && full.call(docElm);
        } else {
            document.exitFullscreen ? document.exitFullscreen()
                : document.mozCancelFullScreen ? document.mozCancelFullScreen()
                : document.webkitCancelFullScreen ? document.webkitCancelFullScreen()
                    : document.msExitFullscreen && document.msExitFullscreen()
        }
        $(this).toggleClass("full-on");
    });

    /* 新建或切换标签栏 */
    var tabs = function (url) {
        var item = $('[lay-url="' + url + '"]');
        if (url !== undefined && url !== '#' && item.length > 0) {
            var bootLay = $('[lay-id="' + url + '"]');
            if (bootLay.length === 0) {
                var title = item.attr("lay-icon") === 'true' ? item.html()
                    : item.children(".layui-nav-title").text();
                element.tabAdd('iframe-tabs', {
                    title: title
                    , content: '<iframe src="' + url + '" frameborder="0"  class="layui-layout-iframe"></iframe>'
                    , id: url
                });
            }
            element.tabChange('iframe-tabs', url);
        }
    };

    /* 监听导航栏事件，实现标签页的切换 */
    element.on("nav(layui-nav-side)", function ($this) {
        var url = $this.attr('lay-url');
        tabs(url);
    });

    /*  */
    element.on("tab(iframe-tabs)", function () {
        var layId = $(this).attr("lay-id");
        $(".layui-side .layui-this").removeClass("layui-this");
        $('[lay-url="' + layId + '"]').parent().addClass("layui-this");
        // 改变地址hash值
        location.hash = this.getAttribute('lay-id');
    });

    /* 监听hash来切换选项卡*/
    window.onhashchange = function (e) {
        var url = location.hash.replace(/^#/, '');
        var index = $(".layui-layout-admin .layui-side .layui-nav-item")[0];
        $(index).children("a").attr("lay-icon", "true");
        if (url === "" || url === undefined) {
            url = $(index).children("[lay-url]").attr("lay-url");
        }
        tabs(url);
    };
    window.onhashchange();

    /* 初始化时展开子菜单 */
    $("dd.layui-this").parents(".layui-nav-item").addClass("layui-nav-itemed");

    /* 刷新iframe页面 */
    $(".refresh-btn").click(function () {
        location.reload();
    });

    /* AJAX请求默认选项，处理连接超时问题 */
    $.ajaxSetup({
        complete: function (xhr, status) {
            if (xhr.status == 401) {
                layer.confirm('session连接超时，是否重新登录？', {
                    btn: ['是', '否']
                }, function () {
                    if (window.parent.window != window) {
                        window.top.location = window.location.pathname + '/login';
                    }
                });
            }
        }
    });

    /*  漂浮消息 */
    $.Messager = function (result) {
        if (result.status === 0) {
            layer.msg(result.message, {offset: '15px', time: 3000, icon: 1});
            setTimeout(function () {
                if (result.result === 'submit[refresh]') {
                    parent.location.reload();
                    return;
                }
                if (result.result == null) {
                    window.location.reload();
                } else {
                    window.location.href = result.result;
                }
            }, 500);
        } else {
            layer.msg(result.message, {offset: '15px', time: 3000, icon: 2});
        }
    };

    /* 提交表单数据 */
    $(document).on("click", ".ajax-submit", function (e) {
        e.preventDefault();
        var form = $(this).parents("form");
        var url = form.attr("action");
        var serializeArray = form.serializeArray();
        $.post(
            url,
            serializeArray,
            function (result) {
                console.log(result.status+"--"+result.message);
                if (result.result == null) {
                    result.result = 'submit[refresh]';
                }
                $.Messager(result);
            },"json");
    });

    /* get方式异步 */
    $(document).on("click", ".ajax-get", function (e) {
        e.preventDefault();
        var msg = $(this).data("msg");
        if (msg !== undefined) {
            layer.confirm(msg + '？', {
                title: '提示',
                btn: ['确认', '取消']
            }, function () {
                $.get(e.target.href, function (result) {
                    $.Messager(result);
                },"json");
            });
        } else {
            $.get(e.target.href, function (result) {
                $.Messager(result);
            },"json");
        }
    });

    // post方式异步-操作状态
    $(".ajax-status").on("click", function (e) {
        e.preventDefault();
        var msg = $(this).data("msg");
        var ids = [];
        if('special'==e.target.name){
            var tdcheckbox = $(".timo-checkbox :checkbox:checked");
        }else {
            var tdcheckbox = $(".timo-table td .timo-checkbox :checkbox:checked");
        }
        if (tdcheckbox.length > 0) {
            tdcheckbox.each(function (key, val) {
                ids.push($(val).attr("value"))
            });
            var status = e.target.id;
            var data = {"ids":ids,"status":status};
            if (msg !== undefined) {
                layer.confirm(msg + '？', {
                    title: '提示',
                    btn: ['确认', '取消']
                }, function () {
                    $.post(
                        e.target.href,data,
                        function (result) {
                            $.Messager(result);
                        },"json"
                    );
                },function () {
                    console.log("取消");
                    return;
                });
            }else{
                $.post(
                    e.target.href,data,
                    function (result) {
                        $.Messager(result);
                    },"json"
                );
            }
        } else {
            layer.msg('请选择一条记录');
        }
    });

    /* 添加/修改弹出层 */
    $(document).on("click", ".open-popup, .open-popup-param", function () {
        var title = $(this).data("title");
        var url = $(this).attr("data-url");
        if ($(this).hasClass("open-popup-param")) {
            var tdcheckbox = $(".timo-table td .timo-checkbox :checkbox:checked");
            var param = '';
            if (tdcheckbox.length === 0) {
                layer.msg('请选择一条记录');
                return;
            }
            if (tdcheckbox.length > 1 && $(this).data("type") === 'radio') {
                layer.msg('只允许选中一个');
                return;
            }
            tdcheckbox.each(function (key, val) {
                param += "ids=" + $(val).attr("value") + "&";
            });
            param = param.substr(0, param.length - 1);
            url += "?" + param;
        }
        var size = ['500px', '450px'];
        if ($(this).attr("data-size") !== undefined) {
            size = $(this).attr("data-size").split(",");
            size = [size[0] + 'px', size[1] + 'px'];
        }
        window.layerIndex = layer.open({
            type: 2,
            title: title,
            shadeClose: true,
            maxmin: true,
            area: size,
            content: [url, 'on']
        });
    });

    /* 关闭弹出层 */
    $(".close-popup").click(function (e) {
        e.preventDefault();
        parent.layer.close(window.parent.layerIndex);
    });

    /* 下拉按钮组 */
    $(".btn-group").click(function (e) {
        e.stopPropagation();
        $this = $(this);
        $this.toggleClass("show");
        $(document).one("click", function () {
            if ($this.hasClass("show")) {
                $this.removeClass("show");
            }
        });
    });

    // 展示数据列表-多选框
    var thcheckbox = $(".timo-table th .timo-checkbox :checkbox");
    thcheckbox.on("change", function () {
        var tdcheckbox = $(".timo-table td .timo-checkbox :checkbox");
        if (thcheckbox.is(':checked')) {
            tdcheckbox.prop("checked", true);
        } else {
            tdcheckbox.prop("checked", false);
        }
    });

    // 检测列表数据是否为空
    var timoTable = $(".timo-table tbody");
    if (timoTable.length > 0) {
        var children = timoTable.children();
        if (children.length === 0) {
            var length = $(".timo-table thead th").length;
            var trNullInfo = "<tr><td class='timo-table-null' colspan='"
                + length + "'>没有找到匹配的记录</td></tr>";
            timoTable.append(trNullInfo);
        }
    }

    // 携带参数跳转
    var paramSkip = function () {
        var getSearch = "";
        $('.timo-search-box [name]').each(function (key, val) {
            if ($(val).val() !== "" && $(val).val() !== undefined) {
                getSearch += $(val).attr("name") + "=" + $(val).val() + "&";
            }
        });
        var pageSize = $(".page-number").val();
        if (pageSize !== undefined && pageSize !== "") {
            getSearch += "rows=" + pageSize + "&";
        }
        if (getSearch !== "") {
            getSearch = "?" + getSearch.substr(0, getSearch.length - 1);
        }
        window.location.href = window.location.pathname + getSearch;
    };

    /* 展示列表数据搜索 */
    $(document).on("click", ".timo-search-btn", function () {
        paramSkip();
    });
    /* 改变显示页数 */
    $(document).on("change", ".page-number", function () {
        paramSkip();
    });

    /** 上传图片操作 */
    // upload.render({
    //     elem: '.upload-image' //绑定元素
    //     ,url:  $('.upload-image').attr('up-url')//上传接口
    //     ,field: 'picture' //文件域的字段名
    //     ,acceptMime: 'image/*' //选择文件类型
    //     ,exts: 'jpg|jpeg|png|gif' //支持的图片格式
    // });

    // 删除上传图片展示项
    $(document).on("click", ".upload-item-close", function () {
        $(this).parent('.upload-item').remove();
    });

});