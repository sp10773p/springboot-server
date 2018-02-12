/**
 * Created by sdh on 2018-02-09.
 */
Ext.define('extjs.view.user.UserUpdController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.userupd',

    /**
     * Called when the view is created
     */
    init: function() {

    },
    onSearch: function (obj, selObj) {
        var me = this;
        var userId = this.getViewModel().get('userId');

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
                    me.getViewModel().setData(obj.data);
                    // me.getViewModel().set('nickName', obj.data.nickName);
                    // me.getViewModel().set('password', obj.data.password);
                    // me.getViewModel().set('email', obj.data.email);

                    // console.log(me.getView().getForm().get('button1'));

                    Ext.Msg.alert("확인", "조회완료!");
                }else{
                    Ext.Msg.alert("오류", obj.msg);
                }
            },
            fail: function (res) {
                Ext.Msg.alert('오류', '시스템 장애입니다.');
            }
        })
    },
    onUpdate: function (obj, selObj) {
        var me = this;
        var params = this.getViewModel().getData();
        Ext.Ajax.request({
            url: '/sample/userUpd',
            headers: {
                'Content-Type' : 'application/json;charset=UTF-8'
            },
            params: JSON.stringify({data: params}),
            success: function (res) {
                var obj = Ext.JSON.decode(res.responseText);
                if(obj.status == 0){
                    console.log(obj);
                    Ext.Msg.alert("확인", "수정성공");
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