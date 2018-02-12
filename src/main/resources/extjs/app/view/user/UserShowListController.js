/**
 * Created by sdh on 2018-02-12.
 */
Ext.define('extjs.view.user.UserShowListController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.usershowlist',
    onSearch: function (obj, selObj) {
        var me = this;
        var searchUserId = this.getViewModel().get('userId');
        this.getViewModel().getStore('userInfo').load({
            params: JSON.stringify({
                data: {
                    userId : searchUserId
                }
            }),
            callback: me.onGetUserInfo,
            scope: me
        });
    },
    onGetUserInfo: function (records, operation, success) {
        if(success == true){

        }else{
            Ext.Msg.alert('오류', this.getViewModel().getStore('userInfo').getProxy().getReader().rawData.msg)
        }
    },
    onPageMoveUserShow: function (view, rowindex, colindex, item, event, record, row) {
        var menucontroller = extjs.app.getController('MemberController');
        menucontroller.movePage('extjs.view.user.UserShow', '사용자조회', {userId: record.data.userId});
    },
    /**
     * Called when the view is created
     */
    init: function() {

    }
});