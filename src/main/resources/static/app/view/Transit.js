Ext.define("SL.view.Transit",{
    extend:"Ext.panel.Panel",
    layout:"border",
    controller:{
        xclass:"SL.view.TransitController"
    },
    viewModel:{
      xclass:"SL.view.MainViewModel"
    },
    items:[{
        xtype: 'tabpanel',
        reference: '',
        region: 'center',
        items: [{
            xtype:"grid",
            title:"ტრანსპორტის ტიპები",
            bind: {
                store:"{transporterCarsTypes}"
            },
            tbar:[{
                xtype:"form",
                reference: "transporterFormType",
                border:false,
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'top',
                    margin:"50 0 0 0",
                    width:250,

                },
                items:[{
                    xtype:"textfield",
                    name:"type",
                    align:"stretch",
                    fieldLabel: "type",
                    allowBlank:false,
                    width:300,
                },{
                    xtype:"button",
                    text:"დამატება",
                    margin:"20 0 0 0 ",
                    handler:"addType",
                    scale:"medium",
                    width:150,
                },{
                    xtype:"button",
                    text:"გასუფთავება",
                    margin:"20 0 0 0 ",
                    scale:"resetType",
                    width:150,
                }]
            }],
            columns:[{
                text:"ID",
                flex:1,
                dataIndex:"id",
            },{
                text:"TransportType",
                flex:2,
                dataIndex:"type",
            },{
                xtype: 'actioncolumn',
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: 'deleteType'
                }]
            }]
        },{
            xtype:"grid",
            title:"გადამზიდი მანქანები",
            bind:{
                store:"{transporterCars}"
            },
            tbar:[{
                xtype:"form",
                reference:"transporterForm",
                layout: "hbox",
                border:false,
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'top',
                    margin:"50 0 0 50",
                    width:250,
                    allowBlank: false,

                },
                items:[{
                    xtype: "combo",
                    name:"type",
                    displayField:"type",
                    valueField:"id",
                    queryMode:"local",
                    typeAhead: true,
                    allowBlank: false,
                    editable:false,
                    forceSelection: true,
                    bind:{
                        store:"{transporterCarsTypes}"
                    },
                    fieldLabel: "Type",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
                },{
                    xtype: "numberfield",
                    name:"number",
                    fieldLabel: "Number",
                    width:200,
                },{
                    xtype: "textfield",
                    name:"carModel",
                    fieldLabel: "CarModel",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
                },{
                    xtype: "textfield",
                    name:"carMark",
                    fieldLabel: "CarMark",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
                },{
                    xtype: "datefield",
                    name:"dateOfIssue",
                    fieldLabel: "DateOfIssue",
                    width:200,
                },{
                    xtype: "button",
                    text:"დამატება",
                    scale:"medium",
                    handler:"addTransporter",
                    margin:"70 0 0 50",
                    width:150,
                },{
                    xtype: "button",
                    text:"გასუფთავება",
                    scale:"medium",
                    handler:"resetTransporter",
                    margin:"70 0 0 50",
                    width:150,
                }]
            }],

            columns:[{
                text:"ID",

                dataIndex:"id",
                flex:1,
            },{
                text:"type",
                flex:2,
                dataIndex:"type"
            }, {
                text:"number",
                flex:2,
                tadaIndex:"number",
            },{
                text:"carModel",
                flex:2,
                dataIndex: "carModel",
            },{
                text:"carMark",
                flex:2,
                dataIndex: "carMark",
            },{
                text:"Date of issue",
                flex:2,
                dataIndex:"DateOfIssue"
            },{
                    xtype: 'actioncolumn',
                    flex:1,
                    items: [{
                        iconCls: 'fa fa-trash-o',
                        tooltip: 'წაშლა',
                        handler: 'delete'
                    }]
                }]
        },{
            xtype:"grid",
            // bind:{
            //     store:"{warehouses}"
            // },
            tbar:[{
                xtype:"form",
                layout:"hbox",
                reference:"driversForm",
                border:false,
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'top',
                    margin:"50 0 0 50",
                    width:250,
                    allowBlank: false,
                },
                items:[{
                    xtype: "numberfield",
                    name:"privateNumber",
                    fieldLabel:"PrivateNumber",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
                },{
                    xtype: "textfield",
                    name:"firstName",
                    fieldLabel: "FirstName",
                    regex: /^[0-9]{11}$/,
                    width:200,
               },{
                    xtype: "textfield",
                    fieldLabel: "LastName",
                    name:"lastName",
                    regex: /^[a-zA-Zა-ჰ]+$/,
                    width:200,
            },{
                    xtype: "datefield",
                    name:"birthDate",
                    fieldLabel: "BirthDate",
                    width:200,
            },{
                    xtype: "button",
                    text:"დამატება",
                    scale:"medium",
                    margin:"70 0 0 50",
                    handler:"addDrivers",
                    width:150,
                },{
                    xtype: "button",
                    text:"გასუფტავება",
                    scale:"medium",
                    margin:"70 0 0 50",
                    handler:"resetDrivers",
                    width:150,
                }]
            }],
            title:"მძღოლები",
            columns:[{
                text:"ID",
                width:50,
                dataIndex:"id",
                flex:1,
            },{
                text:"privateNumber",
                width:150,
                dataIndex:"privateNumber",
                flex:3,
            },{
                text:"Name",
                width:150,
                dataIndex:"name",
                flex:3,
            },{

                text:"LastName",
                width:150,
                dataIndex:"lastName",
                flex:3,
           },{
                text:"dateColumn",
                width:150,
                dataIndex:"birthDate",
                flex:3,
           },{
                xtype: 'actioncolumn',
                flex:1,
                items: [{
                    iconCls: 'fa fa-trash-o',
                    tooltip: 'წაშლა',
                    handler: 'deleteDriver'
                }]
            }]
        }]
    }]
})