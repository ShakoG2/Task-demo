Ext.define("SL.view.RegistrationProduct",{
    extend:"Ext.panel.Panel",
    layout:"border",
    controller:{
        xclass:"SL.view.MainController"
    },
    viewModel:{
      xclass:"SL.view.MainViewModel"
    },

    items:[{
        title:"Product Registration",
        region:"west",
        xtype:"form",
        reference:"form",
        border: true,
        bodyPadding: 20,
        width:500,
        layout: {
            type: 'vbox',
            // align: 'stretch'
        },
        fieldDefaults: {
            anchor: '100%',
            labelAlign: 'top',
            margin:"50 0 0 0",
            width:250,

        },
        items:[{
            xtype:"combo",
            fieldLabel:"მომწოდებელი",
            displayField:"name",
            valueField:"id",
            queryMode:"local",
            typeAhead: true,
            forceSelection: true,
            editable:false,
            allowBlank: false,
            bind:{
                store:"{providers}"
            },
            name:"provider",
            regex: /^[a-zA-Zა-ჰ]+$/,
        },{
            xtype:"combo",
            fieldLabel:"საწყობები",
            name:"warehouses",
            displayField:"name",
            valueField:"id",
            queryMode:"local",
            typeAhead: true,
            allowBlank: false,
            editable:false,
            forceSelection: true,
            bind:{
                store:"{warehouses}"
            },
            regex: /^[a-zA-Zა-ჰ]+$/,
        },{
            xtype:"textfield",
            fieldLabel:"ბრენდი",
            name:"brand",
            regex: /^[a-zA-Zა-ჰ]+$/,
        },{
            xtype:"textfield",
            fieldLabel:"მოდელი",
            name:"model",
            allowBlank: false,
            regex: /^[a-zA-Zა-ჰ]+$/,
        },{
            xtype:"numberfield",
            fieldLabel:"რაოდენობა",
            allowBlank: false,
            name:"quantity"
        },{
            xtype:"numberfield",
            fieldLabel:"ფასი",
            allowBlank: false,
            name:"price"
        },{
            xtype:"numberfield",
            fieldLabel:"საცალო ფასი",
            name:"retailPrice",
            allowBlank: false,
        }, {

            width:500,
            border:false,
            defaults: {
                xtype: 'button',
                scale: 'large'
            },
            items: [{
                text: 'რეგისტრაცია',
                handler: 'registration',
                margin:"20 0 0 0"
            }, {
                text: 'გასუფთავება',
                handler: 'reset',
                margin:"20 0 0 20"
            }]
        }]
    },{
        xtype: 'tabpanel',
        reference: 'mainTabPanel',
        region: 'center',
        items: [{
            xtype:"grid",
            title:"პროდუქტები",
            bind: {
                store:"{products}"
            },
            tbar:[{
                xtype:"form",
                border:false,
                items:[{
                    xtype:"textfield",
                    name:"search",
                    align:"stretch",
                    emptyText:"Search by brand",
                    width:200,
                },{
                    xtype:"button",
                    text:"Search",
                    width:150,
                }]
            }],
            columns:[{
                text:"ID",
                flex:1,
                dataIndex:"id",
            },{
                    text:"brand",
                    flex:2,
                    dataIndex:"brand",
            },{
                text:"model",
                flex:2,
                dataIndex:"model",
            },{
                text:"quantity",
                flex:2,
                dataIndex:"quantity",
            },{
                text:"price",
                flex:2,
                dataIndex:"price",
            },{
                text:"retailPrice",
                flex:2,
                dataIndex:"retailPrice",
            },{
                xtype: 'actioncolumn',
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: 'delete'
                }]
            }]
        },{
            xtype:"grid",
            title:"მომწოდებლები",
            bind:{
                store:"{providers}"
            },
            tbar:[{
                xtype:"form",
                reference:"providersForm",
                border:false,
               items:[{
                   xtype: "textfield",
                   name:"name",
                   regex: /^[a-zA-Zა-ჰ]+$/,
                   width:200,
               },{
                   xtype: "button",
                   text:"დამატება",
                   handler:"addProvider",
                   width:150,
               }]
            }],

            columns:[{
                text:"ID",

                dataIndex:"id",
                flex:1,
            },{
                text:"name",
                flex:3,
                dataIndex:"name"
            },{
                xtype: 'actioncolumn',
                flex:1,
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: ''
                }]
            }]

        },{
            xtype:"grid",
            bind:{
                store:"{warehouses}"
            },
            tbar:[{
                xtype:"form",
                reference:"warehousesForm",
                border:false,
                items:[{
                    xtype: "textfield",
                    name:"name",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
                },{
                    xtype: "button",
                    text:"დამატება",
                    handler:"addWarehouses",
                    width:150,
                }]
            }],
            title:"საწყობები",
            columns:[{
                text:"ID",
                width:50,
                dataIndex:"id",
                flex:1,
            },{
                text:"name",
                width:150,
                dataIndex:"name",
                flex:3,
            },{
                xtype: 'actioncolumn',
                flex:1,
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: ''
                }]
            }]
        }]
    }],
})