Ext.define("SL.model.Drivers",{
    extend:"Ext.data.Model",
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    fields:['id','name','privateNumber','firstName','lastName','birthDate',{
        name:'active',
        type:"boolean"
    }],

    proxy: {
        url: '/drivers',
        type: 'rest',
        writer: {
            writeRecordId: false,
            writeAllFields: true
        }
    }
})