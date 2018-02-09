/**
 * Created by sdh on 2018-02-09.
 */
Ext.define('extjs.view.menu.LeftMenuController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.leftmenu',

    /**
     * Called when the view is created
     */
    init: function() {

    },
    onMenuClick: function (obj, selObj) {
        console.log(obj);
        Ext.Msg.alert('선택', selObj.data.url);
    }
});