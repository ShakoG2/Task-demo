Ext.define("SL.model.Products",{
    extend:"Ext.data.Model",
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    fields: [{name:'id', type:"number"}, 'warehouses','brand','model','quantity','price','retailPrice'],

    proxy: {
        url: '/product',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})