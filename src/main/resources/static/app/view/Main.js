Ext.define("SL.view.Main",{
    extend:"Ext.panel.Panel",
    layout:"border",
    controller:{
        xclass:"SL.view.MainController"
    },
    viewModel:{
      xclass:"SL.view.MainViewModel"
    },


    items:[{
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
            xtype:"textfield",
            fieldLabel:"მომწოდებელი",
            name:"provider"

        },{
            xtype:"textfield",
            fieldLabel:"საწყობები",
            name:"warehouses"
        },{
            xtype:"textfield",
            fieldLabel:"ბრენდი",
            name:"brand"
        },{
            xtype:"textfield",
            fieldLabel:"მოდელი",
            name:"model"
        },{
            xtype:"numberfield",
            fieldLabel:"რაოდენობა",
            name:"quantity"
        },{
            xtype:"numberfield",
            fieldLabel:"ფასი",
            name:"price"
        },{
            xtype:"numberfield",
            fieldLabel:"საცალო ფასი",
            name:"retailPrice"
        },{
            xtype:"datefield",
            fieldLabel: "თარიღი",
            name:"date"
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
            title:"products",
            bind: {
                store:"{products}"
            },
            tbar:[{
                text:"clickme",
                handler:"onetwo",
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
                text:"date",
                xtype:"datecolumn",
                name:"date",
                dataIndex:"createDate"
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
            title:"registrationGrid",
            columns:[{
                text:"ID",
                width:50,
                dataIndex:"id"
            },{
                text:"name",
                width:150,
                dataIndex:"name"
            },{
                xtype: 'actioncolumn',
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: ''
                }]
            }]

        },{
            xtype:"grid",
            title:"wareHausesGrid",
            columns:[{
                text:"ID",
                width:50,
                dataIndex:"id"
            },{
                text:"name",
                width:150,
                dataIndex:"name"
            },{
                xtype: 'actioncolumn',
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: ''
                }]
            }]
        }]
    }],
})