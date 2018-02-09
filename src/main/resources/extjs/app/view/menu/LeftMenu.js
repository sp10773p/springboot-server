Ext.define('extjs.view.menu.LeftMenu', {
   extend: 'Ext.tree.TreePanel',
    alias: 'widget.leftmenu',

    requires: ['extjs.view.menu.LeftMenuController'],

    controller: 'leftmenu',
    width: 200,
    title: '메뉴입니다.',
    rootVisible: false,
    displayField: 'name',
    useArrows: true,

    store: {
       type: 'tree',
        fields: ['name', 'url'],
        proxy: {
           type: 'ajax',
            url: './resources/data/LeftMenu.json',
            reader: {
               type: 'json'
            }
        },
        autoLoad: true
    },

    listeners: {
       itemclick: 'onMenuClick'
    }
});