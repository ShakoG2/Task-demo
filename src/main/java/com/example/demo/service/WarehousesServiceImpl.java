package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Warehouses;
import com.example.demo.repository.WarehousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public  class WarehousesServiceImpl implements WarehousesService{

    private final WarehousesRepository warehousesRepository;

    public WarehousesServiceImpl(WarehousesRepository warehousesRepository) {
        this.warehousesRepository = warehousesRepository;
    }

    @Override
    public List<Warehouses> getAll(){
        return warehousesRepository.findAll();
    }

    @Override
    public Warehouses get(long id){
        String msg = String.format("warehouses with id: %d Not Found", id);
        return warehousesRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public Warehouses add(Warehouses warehouses){
       return warehousesRepository.save(warehouses);
    }

    @Override
    public  Warehouses update(Warehouses warehouses){
       return  warehousesRepository.save(warehouses);
    }
    @Override
    public void  delete(long id){
        get(id);
        warehousesRepository.deleteById(id);
    }
}
