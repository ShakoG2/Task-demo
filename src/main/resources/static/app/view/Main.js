Ext.define("SL.view.Main",{
    extend:"Ext.panel.Panel",
    layout:"border",
    viewModel:{
        xclass:"SL.view.MainViewModel"
    },
    controller:{
        xclass:"SL.view.MainController"
    },

    items:[{
        xtype: 'panel',
        width: 200,
        title: 'Menu',
        split: true,
        collapsible: true,
        region: 'west',
        layout: {
            type: 'vbox',
            align: 'stretch',
        },
        items: [{
            xtype: 'treelist',
            flex: 1,
            border:false,
            bind: '{navItems}',
            listeners: {
                selectionchange: 'onMenuSelect',
            },
        }],
    }, {
        xtype: 'tabpanel',
        reference: 'mainTabPanel',
        region: 'center',
        // items: [{
        //     // xclass: 'SL.view.RegistrationProduct',
        // }],
    }]
})