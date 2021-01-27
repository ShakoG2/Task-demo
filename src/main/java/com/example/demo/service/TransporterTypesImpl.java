package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.TransporterTypes;
import com.example.demo.model.Warehouses;
import com.example.demo.repository.TransporterCarsRepository;
import com.example.demo.repository.TransporterTypesRepository;
import com.example.demo.repository.WarehousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransporterTypesImpl implements TransporterTypesService{

    private final TransporterTypesRepository transporterTypesRepository;



    @Override
    public List<TransporterTypes> getAll(){
        return transporterTypesRepository.findAll();

    }

    @Override
    public TransporterTypes get(long id){
        String msg = String.format("Warehouses with id: %d Not Found", id);
        return transporterTypesRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public TransporterTypes add(TransporterTypes transporterTypes){
        transporterTypes.setId(null);
        return transporterTypesRepository.save(transporterTypes);
    }

    @Override
    public  TransporterTypes update(TransporterTypes transporterTypes){
        return  transporterTypesRepository.save(transporterTypes);
    }
    @Override
    public void  delete(long id){
        get(id);
        transporterTypesRepository.deleteById(id);
    }
}
