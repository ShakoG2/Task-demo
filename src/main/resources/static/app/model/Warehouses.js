Ext.define("SL.view.Warehouses",{
    extend:"Ext.data.Model",
    fields: ['id', 'name', ''],
    proxy: {
        url: '',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})