/**
 * Created by sdh on 2018-02-09.
 */
Ext.define('extjs.view.user.UserUpd', {
    extend: 'Ext.form.Panel',
    alias: 'widget.userupd',
    requires: [
        'Ext.button.Button',
        'Ext.form.FieldSet',
        'Ext.form.field.Text',
        'Ext.layout.container.HBox',
        'Ext.toolbar.Spacer',
        'extjs.view.user.UserUpdController',
        'extjs.view.user.UserUpdModel'
    ],

    controller: 'userupd',

    viewModel: 'userupd',

    title: '사용자변경',
    bodyPadding: 5,
    closable: true,

    items: [{
        xtype: 'fieldset',
        layout: 'hbox',
        padding: 5,
        items: [{
            xtype: 'textfield',
            fieldLabel: '사용자 ID',
            labelAlign: 'right',
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
        xtype: 'fieldset',
        padding: 5,
        items: [{
            xtype: 'textfield',
            fieldLabel: '닉네임',
            labelAlign: 'right',
            allowBlank: false,
            name: 'nickName',
            bind: '{nickName}'

        },{
            xtype: 'textfield',
            fieldLabel: '패스워드',
            labelAlign: 'right',
            allowBlank: false,
            name: 'password',
            bind: '{password}'
        },{
            xtype: 'textfield',
            fieldLabel: '이메일',
            labelAlign: 'right',
            allowBlank: false,
            name: 'email',
            bind: '{email}'
        }]
    }],
    buttons: [{
        text: '변경',
        formBind: true,
        disabled: true,
        handler: 'onUpdate'
    }]
});