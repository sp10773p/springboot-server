Ext.define('extjs.controller.MainController', {
    extend: 'Ext.app.Controller',

    config: {
        refs: {
            mainBar: 'main tabpanel[name=mainbar]'
        }
    },

    setMainBar: function (url, menuName) {
        var mainBar = this.getMainBar();
        var findTitle = false;
        for(var i=0; i < mainBar.getTabBar().items.items.length; i++) {
            if(menuName == mainBar.getTabBar(i).items.items[i].title){
                mainBar.getLayout().setActiveItem(i);
                findTitle = true;
                break;
            }
        }
        if(findTitle == false) {
            var panel = Ext.create(url, {
                autoShow: true,
                autoDestroy: true
            });
            mainBar.add(panel);
            mainBar.getLayout().setActiveItem(panel);
        }
    },
    movePage: function (url, menuName, params) {
        var mainBar = this.getMainBar();
        var findTitle = false;
        var panel;
        for(var i=0; i < mainBar.getTabBar().items.items.length; i++) {
            if (menuName == mainBar.getTabBar(i).items.items[i].title) {
                mainBar.getLayout().setActiveItem(i);
                panel = mainBar.getLayout().getActiveItem();
                findTitle = true;
                break;
            }
        }
        if(findTitle == false) {
            panel = Ext.create(url, {
                autoShow: true
            });
            mainBar.add(panel);
            mainBar.getLayout().setActiveItem(panel);
        }

        panel.getController().calledByOther(params);
    }
})