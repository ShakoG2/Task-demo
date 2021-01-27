Ext.define("SL.view.MainController",{
    extend:"Ext.app.ViewController",

    reset:function (){
        const me=this;
        const form=me.lookup("form");
        form.reset();
    },

    registration:function (){
        const me=this;
        const form=me.lookup("form");
        // if(!form.isValid()) return;
        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("products");
        const product=Ext.create("SL.model.Products",values);
        store.add(product);
        form.reset();
    },


    delete:function (grid,rowIndex,colIndex){
        const me=this;
        Ext.Msg.confirm("ყურადღება!","დარწმუნებული ხართ, რომ გნებავთ მონაცემის წაშლა ?",function (answer){
            if(answer==="yes"){
                const store=me.getViewModel().getStore("products");
                store.removeAt(rowIndex)
            }
        }, this)
    },
    addProvider:function (){
        const me=this;
        const form=me.lookup("providersForm");
        // if(!form.isValid()) return;
        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("providers");
        const provider=Ext.create("SL.model.Providers",values);

        store.add(provider);
        form.reset();
    },
    addWarehouses:function (){
        const me=this;
        const form=me.lookup("warehousesForm");

        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("warehouses");

        const warehouse=Ext.create("SL.model.Warehouses",values);

        store.add(warehouse);
        form.reset();
    },
    onMenuSelect: function(view, record) {
        const className = record.get('className');
        const title = record.get('text');

        const tabPanel = this.lookup('mainTabPanel');
        let tab = this.lookup(className);

        if(!tab) {
            tab = Ext.create(className, {
                reference: className,
                closable: true,
                title: title
            });
            tabPanel.add(tab);
        }

        tabPanel.setActiveTab(tab);
    },
})