/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.user.UserShowList', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.usershowlist',
    requires: [
        'extjs.view.user.UserShowListModel',
		'extjs.view.user.UserShowListController'
    ],
    viewModel: {
        type: 'usershowlist'
    },
    controller: 'usershowlist',
    closable: true,
    title: '사용자목록조회',
    bodyPadding: 5,
    items: [{
        xtype: 'fieldset',
        layout: 'hbox',
        width: '100%',
        items: [{
            xtype: 'textfield',
            name: 'userId',
            fieldLabel: '사용자 ID',
            bind: '{userId}'
        },{
            xtype: 'tbspacer',
            flex: 1
        },{
            xtype: 'button',
            text: '조회',
            handler: 'onSearch'
        }]
    },{
        xtype: 'tbspacer',
        height: 10
    },{
        xtype: 'grid',
        reference: 'gridUser',
        bind:{
            store: '{userInfo}'
        },
        width: '100%',
        height: 250,
        columnLines: true,
        columns:[{
            text: '순번',
            xtype: 'rownumberer',
            width: 80
        },{
            text: '아이디',
            dataIndex: 'userId',
            flex: 1
        },{
            text: '닉네임',
            dataIndex: 'nickName',
            flex: 2
        },{
            text: '이메일',
            dataIndex: 'email',
            flex: 2
        },{
            text: '상세화면',
            xtype: 'actioncolumn',
            align: 'center',
            width: 100,
            items: [{
                iconCls: 'x-fa fa-cog',
                handler: 'onPageMoveUserShow'
            }]
        }]
    }]
});