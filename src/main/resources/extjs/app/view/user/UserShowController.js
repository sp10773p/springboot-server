/**
 * Created by sdh on 2018-02-09.
 */
Ext.define('extjs.view.user.UserShowController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.usershow',

    /**
     * Called when the view is created
     */
    init: function() {

    },
    onSearch: function (obj, selObj) {
        var me = this;
        var userId = this.lookupReference('userId').getValue();
        Ext.Ajax.request({
            url: '/sample/showUser',
            headers: {
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            params: JSON.stringify(
                {
                    data: {
                        userId : userId
                    }
                }
            ),
            success: function (res) {
                var obj = Ext.JSON.decode(res.responseText);
                if(obj.status == 0){
                    me.lookupReference('nickName').setValue(obj.data.nickName);
                    me.lookupReference('email').setValue(obj.data.email);
                    Ext.Msg.alert("확인", "조회완료!");
                }else{
                    Ext.Msg.alert("오류", obj.msg);
                }
            },
            fail: function (res) {
                Ext.Msg.alert('오류', '시스템 장애입니다.');
            }
        })
    }
});