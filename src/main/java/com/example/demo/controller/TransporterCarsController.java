package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.TransporterCars;
import com.example.demo.service.ProductService;
import com.example.demo.service.TransporterCarsService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("transporterCars")
@RequiredArgsConstructor
public class TransporterCarsController {

    private final TransporterCarsService transporterCarsService;


    @GetMapping
    @Transactional()
    public List<TransporterCars> getProduct(){
        return transporterCarsService.getAll();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<TransporterCars> addProduct(@RequestBody TransporterCars transporterCars){

        return ResponseEntity.status(HttpStatus.CREATED).body(transporterCarsService.add(transporterCars));
    }

    @PutMapping("{id}")
    public TransporterCars updateCustomer(@PathVariable long id,
                                  @RequestBody TransporterCars unsafeCars) {
        TransporterCars transporterCars = transporterCarsService.get(id);
        return transporterCarsService.update(unsafeCars);
    }
    @GetMapping("{id}")
    public TransporterCars getCustomer(@PathVariable long id) {
        return transporterCarsService.get(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        transporterCarsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
