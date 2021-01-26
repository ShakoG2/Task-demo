Ext.define("SL.view.Providers",{
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