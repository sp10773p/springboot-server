/**
 * Created by sdh on 2018-02-13.
 */
Ext.define('extjs.controller.AjaxController', {
    extend: 'Ext.app.Controller',

    config: {
        /*
        Uncomment to add references to view components
        refs: [{
            ref: 'list',
            selector: 'grid'
        }],
        */

        /*
        Uncomment to listen for events from view components
        control: {
            'useredit button[action=save]': {
                click: 'updateUser'
            }
        }
        */
    },

    /**
     * Called when the view is created
     */
    init: function() {

    },
    storeReader: function(store, url, params, callback, scope){
        var proxy = new Ext.data.proxy.Ajax({
            url: url,
            extraParams: params,
            headers: {
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            actionMethods : {
                read : 'POST'
            },
            paramsAsJson: true,
            reader: {
                type: 'json',
                rootProperty: 'dataList',
                keepRawData: true
            }
        });

        store.setProxy(proxy);
        store.load({
            callback: callback,
            scope: scope
        });
    }
});