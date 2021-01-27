Ext.define("SL.model.Warehouses",{
    extend:"Ext.data.Model",
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    fields: ['id', 'name',],
    proxy: {
        url: '/warehouses',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})