Ext.define('extjs.view.user.UserDuplicate', {
    extend: 'Ext.window.Window',
    alias: 'widget.userduplicate',
    requires: [
        'extjs.view.user.UserDuplicateController'
    ],
    controller: 'userduplicate',
    title: '사용자중복조회',
    bodyPadding: 5,
    width: 400,
    height: 200,
    items: [{
        xtype: 'fieldset',
        layout: 'hbox',
        items: [{
            xtype: 'textfield',
            name: 'userId',
            fieldLabel: '사용자 ID',
            labelAlign: 'right',
            reference: 'userId'
        },{
            xtype: 'tbspacer',
            flax: 1
        },{
            xtype: 'button',
            text: '중복조회',
            handler: 'onSearch'
        }]
    },{
        xtype: 'button',
        text: '사용자ID 반환',
        handler: 'onReturn'
    }]
})