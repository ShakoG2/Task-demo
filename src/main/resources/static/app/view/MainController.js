Ext.define("SL.view.MainController",{
    extend:"Ext.app.ViewController",

    onetwo:function (){
        const grid=this.getView();
        console.log(grid.getStore());
    },

    registration:function (){
        const me=this;
        const form=me.lookup("form");
        // if(!form.isValid()) return;
        const values=form.getForm().getValues();
        console.log(me)
        console.log(this.getViewModel());
        const store=me.getViewModel().getStore("products");
        const product=Ext.create("SL.model.Products",values);
        store.add(product);
        form.reset();
    },


    delete:function (grid,rowIndex,colIndex){
        const me=this;
        Ext.Msg.confirm("ყურადღება!","დარწმუნებული ხართ, რომ გნებავთ დავალების წაშლა ?",function (answer){
            if(answer==="yes"){
                const store=me.getViewModel().getStore("products");
                store.removeAt(rowIndex)
            }
        }, this)
    },
})