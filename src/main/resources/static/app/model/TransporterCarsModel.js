Ext.define("SL.model.TransporterCarsModel",{
    extend:"Ext.data.Model",
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    fields:["id","type","carMark","carModel","dateOfIssue"],
    proxy: {
        url: '/transporterCars',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})