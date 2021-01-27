Ext.define("SL.model.TransporterCarsType",{
    extend:"Ext.data.Model",
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    fields: ['id','type'],

    proxy: {
        url: '/transporterCarsTypes',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})