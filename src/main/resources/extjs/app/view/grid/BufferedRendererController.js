/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.grid.BufferedRendererController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.bufferedrenderer',
    onSearch: function (obj, selObj) {
        var me = this;
        var searchNickName = this.getViewModel().get('nickName');
        this.getViewModel().getStore('userInfo').load({
            params: {searchNickName: searchNickName},
            callback: me.onGetUserInfo,
            scope: me
        });
    },
    onGetUserInfo: function (records, operation, success) {
        if(success == true) {

        } else {
            Ext.Msg.alert('오류', this.getProxy().getReader().rawData.msg);
        }
    },

    /**
     * Called when the view is created
     */
    init: function() {

    }
});