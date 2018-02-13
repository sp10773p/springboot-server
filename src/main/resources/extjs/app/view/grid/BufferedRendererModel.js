/**
 * Created by sdh on 2018-02-12.
 */

Ext.define('extjs.view.grid.BufferedRendererModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.bufferedrenderer',

    requires: [
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],
    stores: {
        userInfo: {
            fields: ['userId', 'password', 'nickName', 'class', 'ages'],
            config: {
                autoLoad: false
            }
        }
    },

    data: {
        nickName: ''
    }
});