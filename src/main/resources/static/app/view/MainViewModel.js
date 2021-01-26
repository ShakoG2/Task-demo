
Ext.define("SL.view.MainViewModel",{
    extend:"Ext.app.ViewModel",
    requires:["SL.model.Products"],


    stores:{
            products:{
                model:"SL.model.Products",
                autoLoad:true,
                autoSync:true,
            },
    }
})