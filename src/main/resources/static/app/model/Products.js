Ext.define("SL.model.Products",{
    extend:"Ext.data.Model",
    fields: ['id', 'name', 'warehouses','brand','model','quantity','price','retailPrice','createDate'],
    proxy: {
        url: '/product',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})