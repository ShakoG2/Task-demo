package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouses;
import com.example.demo.service.ProductService;
import com.example.demo.service.WarehousesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("warehouses")
@RequiredArgsConstructor
public class WarehousesController {

//    public WarehousesController(WarehousesService warehousesService) {
//        this.warehousesService = warehousesService;
//    }

    private final WarehousesService warehousesService;




    @GetMapping
    @Transactional()
    public List<Warehouses> getWarehouses(){
        return warehousesService.getAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Warehouses> addWarehouses(@RequestBody Warehouses warehouses){

        return ResponseEntity.status(HttpStatus.CREATED).body(warehousesService.add(warehouses));
    }

    @PutMapping("{id}")
    public Warehouses updateWarehouses(@PathVariable long id,
                                  @RequestBody Warehouses unsafeWarehouses) {
        Warehouses warehouse =warehousesService.get(id);
        return warehousesService.update(unsafeWarehouses);
    }
    @GetMapping("{id}")
    public Warehouses getWarehouses(@PathVariable long id) {
        return warehousesService.get(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWarehouses(@PathVariable long id) {
        warehousesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
