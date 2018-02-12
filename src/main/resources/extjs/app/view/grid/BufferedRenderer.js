/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.grid.BufferedRenderer', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.bufferedrenderer',
    requires: [
        'Ext.toolbar.Fill',
        'extjs.view.grid.BufferedRendererController',
        'extjs.view.grid.BufferedRendererModel'
    ],
    controller: 'bufferedrenderer',
    closable: true,
    viewModel: {
        type: 'bufferedrenderer'
    },
    title: '버퍼드랜더러',
    items: [{
        xtype: 'fieldset',
        layout: 'hbox',
        padding : 5,
        items: [{
            xtype: 'textfield',
            name: 'nickName',
            fieldLabel: '닉네임',
            labelAlign: 'right',
            bind: '{nickName}'
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
        height: 10,
    },{
        xtype: 'grid',
        reference: 'gridUser',
        bind: {
            store: '{userInfo}'
        },
        width: '100%',
        height: 400,
        columnLines: true,
        plugins: [{
            ptype: 'bufferedrenderer'
        }],
        columns: [{
            text: '순번',
            xtype: 'rownumberer',
            width: 80
        },{
            text: '아이디',
            hidden: true,
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
            text: '나이',
            dataIndex: 'ages',
            flex: 1
        },{
            text: '학급',
            dataIndex: 'class',
            flex: 1
        }]
    }]
});