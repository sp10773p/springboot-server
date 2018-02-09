Ext.define('extjs.view.user.UserRegController',{
    extend: 'Ext.app.ViewController',
    alias: 'controller.userreg',
    onSubmit: function () {
        var form = this.getView().getForm();

        var params = {
            data: {}
        }
        form.getFields().each(function(item, index, len){
            console.log(item.getFieldLabel(), item.getName(), item.getInputId(), item.getId(), item.getValue(), item);

            params.data[item.getInputId()] = item.getValue();

        }, this);


        if(form.isValid()) {
            Ext.Ajax.request({
                url: '/sample/userReg',
                headers: {
                    'Content-Type' : 'application/json;charset=UTF-8'
                },
                params: JSON.stringify(params),
                success: function (res) {
                    var obj = Ext.JSON.decode(res.responseText);
                    if(obj.status == 0){
                        console.log(obj);
                        Ext.Msg.alert("확인", "저장성공");
                    }else{
                        Ext.Msg.alert("오류", obj.msg);
                    }
                },
                fail: function (res) {
                    Ext.Msg.alert('오류', '시스템 장애입니다.');
                }
            })
            /*form.submit({
                url: '/sample/userReg',
                method: 'POST',
                params: params,
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                success:function(form, action){
                    Ext.Msg.alert('Success', action.result.msg);
                },
                failure: function (form, action) {
                    Ext.Msg.alert('Failed', action.result.msg);
                }
            })*/
        }
    },
    onReset: function () {
        this.getView().getForm().reset();
    }
})