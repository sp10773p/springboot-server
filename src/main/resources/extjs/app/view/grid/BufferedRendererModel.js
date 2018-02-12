/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.grid.BufferedRendererModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.bufferedrenderer',

    stores: {
        userInfo: {
            fields: ['userId', 'password', 'nickName', 'class', 'ages'],
            config: {
                proxy: {
                    type: 'ajax',
                    url: '/sample/tooManyData',
                    headers: {
                        'Content-Type' : 'application/json; charset=UTF-8'
                    },
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
        nickName: ''
    }
});