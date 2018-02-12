/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.user.UserShowListModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.usershowlist',

    stores: {
        userInfo: {
            fields : ['userId', 'password', 'nickName', 'email'],
            config: {
                proxy: {
                    type: 'ajax',
                    url: '/sample/userShowList',
                    params: {userId: ''},
                    reader: {
                        type: 'json',
                        rootProperty: 'dataList',
                        keepRawData: true
                    }
                },
                autoLoad: false
            }
        }
    },

    data: {
        userId : '',
        nickName : '',
        password: '',
        email: ''
    }
});