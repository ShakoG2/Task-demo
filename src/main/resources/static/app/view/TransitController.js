Ext.define('SL.view.TransitController',{
    extend:"Ext.app.ViewController",

    addTransporter:function (){
        const me=this;
        const form=me.lookup("transporterForm");
        if(!form.isValid()) return;
        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("transporterCars");
        const car=Ext.create("SL.model.TransporterCarsModel",values);
        store.add(car);
        form.reset();
    },
    resetTransporter:function (){
        const me=this;
        const form=me.lookup("transporterForm");
        form.reset();
    },
    delete:function (grid,rowIndex,colIndex){
        const me=this;
        Ext.Msg.confirm("ყურადღება!","დარწმუნებული ხართ, რომ გნებავთ მონაცემის წაშლა ?",function (answer){
            if(answer==="yes"){
                const store=me.getViewModel().getStore("transporterCars");
                store.removeAt(rowIndex)
            }
        }, this)
    },
    addType:function (){
        const me=this;
        const form=me.lookup("transporterFormType");
        if(!form.isValid()) return;
        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("transporterCarsTypes");
        const cartyp=Ext.create("SL.model.TransporterCarsType",values);
        store.add(cartyp);
        form.reset();
    },
    deleteType:function (grid,rowIndex,colIndex){
        const me=this;
        Ext.Msg.confirm("ყურადღება!","დარწმუნებული ხართ, რომ გნებავთ მონაცემის წაშლა ?",function (answer){
            if(answer==="yes"){
                const store=me.getViewModel().getStore("transporterCarsTypes");
                store.removeAt(rowIndex)
            }
        }, this)
    },
    addDrivers:function (){
        const me=this;
        const form=me.lookup("driversForm");
        if(!form.isValid()) return;
        const values=form.getForm().getValues();
        const store=me.getViewModel().getStore("drivers");
        const driver=Ext.create("SL.model.Drivers",values);
        store.add(driver);
        form.reset();
    }
})