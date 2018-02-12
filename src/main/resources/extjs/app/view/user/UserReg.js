Ext.define('extjs.view.user.UserReg',{
    extend: 'Ext.form.Panel',
    alias: 'widget.userreg',
    requires: [
        'extjs.view.user.UserRegController'
    ],
    controller: 'userreg',
    closable: true,
    bodyPadding: 5,
    title: '사용자등록',
    // url: '/sample/userReg',
    // jsonSubmit: true,
    // baseParams: {
    //     menuId: 'userReg'
    // },
    items: [{
        xtype: 'fieldset',
        title: '입력하세요',
        layout: {
            type: 'table',
            columns : 2
        },
        items: [{
            xtype: 'textfield',
            fieldLabel: '사용자ID',
            labelAlign: 'right',
            allowBlank: false,
            name: 'userId',
            inputId: 'userId',
            reference: 'userId'
        },{
            xtype: 'button',
            text: '중복확인',
            handler: 'onShowDuplicate'
        },{
            xtype: 'textfield',
            fieldLabel: '닉네임',
            labelAlign: 'right',
            allowBlank: false,
            name: 'nickName',
            inputId: 'nickName',
            colspan: 2
        },{
            xtype: 'textfield',
            fieldLabel: '패스워드',
            labelAlign: 'right',
            allowBlank: false,
            name: 'password',
            inputId: 'password',
            colspan: 2
        },{
            xtype: 'textfield',
            fieldLabel: '이메일',
            labelAlign: 'right',
            allowBlank: false,
            name: 'email',
            inputId: 'email',
            colspan: 2
        }]
    }],
    buttons: [{
        text: 'Reset',
        handler: 'onReset'
    },{
        text: 'Submit',
        formBind: true,
        disabled: true,
        handler: 'onSubmit'
    }]
});