Ext.define('extjs.view.main.Main',{
    extend: 'Ext.container.Container',
    requires: [
        'Ext.layout.container.Border',
        'Ext.tab.Panel',
        'extjs.view.main.MainController',
        'extjs.view.main.MainModel',
        'extjs.view.menu.LeftMenu',
        'extjs.view.user.UserShow',
        'extjs.view.user.UserReg',
        'extjs.view.user.UserUpd',
        'extjs.view.user.UserShowList'
    ],
    xtype: 'main',
    controller: 'main',
    viewModel: {
        type: 'main'
    },
    layout: {
        type: 'border'
    },
    items: [{
        region: 'north',
        border: true,
        height: 50,
        bodyStyle: 'background-color: black',
        html: '<h2><font color="white">&nbsp;&nbsp;&nbsp;회원관리</font></h2>'
    },{
        region: 'west',
        border: true,
        xtype: 'leftmenu',
        collapsible: true,
        width: 200
    },{
        region: 'center',
        xtype: 'tabpanel',
        name: 'mainbar',
        items: [/*{
            xtype: 'usershow'
        },{
            xtype: 'userreg'
        },{
            xtype: 'userupd'
        },{
            xtype: 'usershowlist'
        }*/]
    },{
        region: 'south',
        border: true,
        height: 30,
        html: '도움말'
    }]
});


/* Original
Ext.define('extjs.view.main.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'app-main',

    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'extjs.view.main.MainController',
        'extjs.view.main.MainModel',
        'extjs.view.main.List'
    ],

    controller: 'main',
    viewModel: 'main',

    ui: 'navigation',

    tabBarHeaderPosition: 1,
    titleRotation: 0,
    tabRotation: 0,

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            bind: {
                text: '{name}'
            },
            flex: 0
        },
        iconCls: 'fa-th-list'
    },

    tabBar: {
        flex: 1,
        layout: {
            align: 'stretch',
            overflowHandler: 'none'
        }
    },

    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },

    defaults: {
        bodyPadding: 20,
        tabConfig: {
            plugins: 'responsive',
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 120
                }
            }
        }
    },

    items: [{
        title: 'Home',
        iconCls: 'fa-home',
        // The following grid shares a store with the classic version's grid as well!
        items: [{
            xtype: 'mainlist'
        }]
    }, {
        title: 'Users',
        iconCls: 'fa-user',
        bind: {
            html: '{loremIpsum}'
        }
    }, {
        title: 'Groups',
        iconCls: 'fa-users',
        bind: {
            html: '{loremIpsum}'
        }
    }, {
        title: 'Settings',
        iconCls: 'fa-cog',
        bind: {
            html: '{loremIpsum}'
        }
    }]
});
*/
