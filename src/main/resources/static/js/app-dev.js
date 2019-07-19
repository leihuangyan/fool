
//定义数据model
Ext.define('lsp.Statement', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'fid', type: 'string'},
        {name: 'subsidiary', type: 'string'},
        {name: 'paymentday', type: 'date'},
        {name: 'budgetitem', type: 'string'},
        {name: 'reimbursetotalamount', type: 'float'},
        {name: 'billstatus', type: 'int'},
        {name: 'createtime', type: 'date'},
    ]
});

// var ss = Ext.create('lsp.Statement',{
//     fid:'DLSP156082485105904C26F05E2',
//     subsidiary:'DLSP156082485105904C26F05E2',
//     paymentday:'2019-06-18',
//     budgetitem:'DLSP156082485105904C26F05E2',
//     reimbursetotalamount:'DLSP156082485105904C26F05E2',
//     billstatus:1,
//     createtime:'2019-06-18',
// });
// console.log(ss);


//定义strore
Ext.define('lsp.Statement.Store', {
    extend: 'Ext.data.Store',
    model: 'lsp.Statement',
    pageSize: 10, // 数据集每页显示数量
    proxy : {
        type : 'ajax',
        actionMethods: 'GET',
        url : '../flr/flrExtension/list.action'
    }
});

var conditions = [
    {
        xtype: 'textfield',
        columnWidth: 0.33,
        fieldLabel: '单据编号'
    },
    {
        xtype: 'textfield',
        columnWidth: 0.33,
        fieldLabel: '子公司'
    },
    {
        xtype:'datefield',
        fieldLabel:'申请时间',
        format:'Y-m-d',
        columnWidth : 0.20,
        maxValue:new Date(),
        editable:false,
        value : Ext.Date.format(new Date(new Date().getFullYear(),
            new Date().getMonth() - 1, new Date().getDate()), 'Y-m-d')
    },
    {
        xtype: 'combobox',
        fieldLabel: '单据状态',
        autoSelect : true,
        columnWidth: 0.33,
        queryMode: 'local',
        displayField: 'name',
        valueField: 'value',
        value:"未提交",
        store: Ext.create('Ext.data.Store', {
            fields: ['name', 'value'],
            data: [
                {name: '未提交', value: '101'},
                {name: '未审批', value: '102'},
                {name: '审批中', value: '103'},
                {name: '已办结', value: '104'},
                {name: '不同意', value: '105'}
            ]
        }),
    }];


var buttons = [{
    type: 'button', text: '查询'
}, {
    type: 'button', text: '清空'
}];

var  grid_tbar = [{
    xtype : 'button',
    text : '批量审核',
    name : 'export',
    handler : function(){
        Ext.Msg.alert('提示','功能等待实现');
    },
    },{
    xtype : 'button',
    text : '通知供应商确认',
    name : 'export',
    handler : function(){
        Ext.Msg.alert('提示','功能等待实现');
    },
    }, {
        xtype : 'button',
        text : '导出',
        name : 'export',
        handler : function(){
            Ext.Msg.alert('提示','功能等待实现');
        },
    }];


var  grid_columns = [{
    text: "序号",
    xtype: 'rownumberer',
    width : 40
}, {
    text: "fid",
    dataIndex: "fid",
    flex: 1
},
    {
        text: "子公司",
        dataIndex: "subsidiary",
        flex: 1
    },
    {
        text: "账期",
        dataIndex: "paymentday",
        flex: 1
    } ,
    {
        text: "预算项目",
        dataIndex: "budgetitem",
        flex: 1
    },
    {
        text: "创建时间",
        dataIndex: "reimbursetotalamount",
        flex: 1
    },
    {
        text: "报账总金额",
        dataIndex: "reimbursetotalamount",
        flex: 1
    }, {
        text: "订单状态",
        dataIndex: "billstatus",
        flex: 1,
        renderer: function (value) {
            if (value == "0") {
                return "未提交";
            } else if (value == "1") {
                return "未审批";
            } else if (value == "2") {
                return "审批中";
            } else if (value == "3") {
                return "已办结";
            } else if (value == "4") {
                return "不同意";
            }
        }
    }];


//主面板ID
var name = 'lsp.base.list.panel';

//查询表单的id
var search_id = 'list_form';
if (Ext.getCmp('list_form') != undefined) {
    Ext.getCmp('list_form').destroy();
}

/**
 * 创建查询表单
 * @param name               查询表单的定义名称
 * @param search_id          查询表单的id
 * @param conditions         各种输入框，下拉框
 * @param buttons            按钮集合
 * @returns                    form面板的对象
 */
var create_from_panel = function( name, search_id, conditions, buttons, height) {
    //定义表单容器panel,用于构造查询表单
    Ext.define(name, {
        extend: 'Ext.form.Panel',
        id: search_id,
        title: '查询条件',
        layout: 'column',
        animCollapse: true,//折叠使用动画效果
        //defaults 将会应用所有的子组件上,而不是父容器
        defaults: {
            msgTarget: 'qtip',
            margin: '5 0 5 0 ',
            labelWidth: 100,
            columnWidth: 0.33,
            maxLength: 30,
            labelAlign: 'right',
            enforceMaxLength: true
        },
        collapsible: true,
        border: 20,
        height: height,
        frame: true,
        items: conditions,
        fbar: buttons,
        header: 'true',
        buttonAlign: 'center'
    });

    return Ext.create(name);
}

//定义表格
Ext.define('test.module.grid', {
    extend: 'Ext.grid.Panel',
    id : 'hr_employee_grid',
    title: '详细信息列表',
    autoHeight: true,
    frame: true,
    forceFit: false, 	// Grid会自动100%平铺浏览器宽度
    autoScroll: true, 	// Grid面板会随着拖动单元格长宽产生滚动条
    enableColumnMove: false, // 列是否可以拖动
    sortableColumns: false, // 列是否动态改变排序
    enableColumnHide: false, // 列是否可隐藏或显示
    //不启用单选？
	simpleSelect:false,
    defaults: {
        margin: '0 0 0 0'
    },
	tbar:grid_tbar,
    columns: grid_columns,
    //分页
    pagingToolbar: null,
    constructor : function(config) {
        var me = this, cfg = Ext.apply({}, config);
        console.log("==============");
        me.store = Ext.create('lsp.Statement.Store', {
            pageSize : 10,
        });
        me.callParent([ cfg ]);
    }
});

/**
 * 创建主面板
 * @param form_panel        查询面板
 * @param list_grid_panel   查询列表面板
 * @param main_panel_name    主面板定义名称
 * @param main_panel_id    主面板id
 * @param renderTo    渲染到的div id（jsp中的divid）
 * @returns
 */
var createMainPanel = function (form_panel, list_grid_panel, main_panel_name, main_panel_id, renderTo) {
    /**
     * 主界面
     */
    Ext.define(main_panel_name, {
        extend: 'Ext.panel.Panel',
        id: main_panel_id,
        renderTo: renderTo,
        autoHeight: true,
        cls: "panelContentNToolbar",
        bodyCls: 'panelContentNToolbar-body',
        layout: 'auto',
        queryForm: null,
        getQueryForm: function () {
            if (this.queryForm == null) {
                //查询条件form
                this.queryForm = form_panel;
            }
            return this.queryForm;
        },
        setQueryForm: function (form) {
            this.queryForm = form;
            return this.queryForm;
        },
        detailGrid: null,
        getDetailGrid: function () {
            if (this.detailGrid == null) {
                //列表界面
                this.detailGrid = list_grid_panel;
            }
            return this.detailGrid;
        },
        setDetailGrid: function (grid) {
            this.detailGrid = grid;
            return this.detailGrid;
        },
        constructor: function (config) {
            var me = this,
                cfg = Ext.apply({}, config);
            //将查询面板和表格面板设置到主面板的 itmes
            me.items = [
                me.getQueryForm(),
                me.getDetailGrid()
            ];
            me.callParent([cfg]);
        }
    });

    return Ext.create(main_panel_name);
}


/**
 * 创建查询表单
 * @param name               查询表单的定义名称
 * @param search_id          查询表单的id
 * @param conditions         各种输入框，下拉框
 * @param buttons            按钮集合
 * @returns                    form面板的对象
 */
var  form_panel = create_from_panel(name, search_id, conditions, buttons, 150);
//创建表格面板
var list_grid_panel = Ext.create('test.module.grid');

//开始渲染窗体
Ext.onReady(function () {
    Ext.QuickTips.init();
    //开启动态加载
    Ext.Loader.setConfig({
        enabled: true
    });
    var main_panel = Ext.getCmp('test_list_Panel');

    if (main_panel != undefined) {
        main_panel.destroy();
    }
    main_panel = createMainPanel(form_panel, list_grid_panel,
        'test.list.listPanel',
        'test_list_listPanel',
        'configurable-params-body');
    main_panel.getDetailGrid();
});
