package com.example.demo.service;

import com.example.demo.model.Warehouses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface WarehousesService {

    List <Warehouses> getAll();

    Warehouses get(long id);

    Warehouses add(Warehouses warehouses);

    Warehouses update(Warehouses warehouses);

    void delete(long id);


}
