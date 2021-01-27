
Ext.define("SL.view.MainViewModel",{
    extend:"Ext.app.ViewModel",
    requires:["SL.model.Products","SL.model.Providers","SL.model.Warehouses","SL.model.TransporterCarsModel","SL.model.TransporterCarsType"],


    stores:{
        products:{
                model:"SL.model.Products",
                autoLoad:true,
                autoSync:true,
            },
        providers:{
            model:"SL.model.Providers",
            autoLoad:true,
            autoSync:true,
        },
        warehouses:{
            model:"SL.model.Warehouses",
            autoLoad:true,
            autoSync:true,
        },
        transporterCars:{
          model:"SL.model.TransporterCarsModel",
          autoLoad:true,
          autoSync:true,
        },
        transporterCarsTypes:{
            model:"SL.model.TransporterCarsType",
            autoLoad:true,
            autoSync:true,
        },
        navItems: {
            type: 'tree',
            border:false,
            root: {
                expanded: true,
                children: [{
                    text: 'პროდუქტის რეგისტრაცია',
                    className: 'SL.view.RegistrationProduct',
                    leaf: true,
                    children: [{
                        text: 'რეგისტრაცია',
                        leaf: true,
                        iconCls: 'x-fa fa-book'
                    }]
                }, {
                    text: 'პროდუქტის გადაზიდვა',
                    className: 'SL.view.Transit',
                    leaf: true,
                }],
            },
        },
    },
})