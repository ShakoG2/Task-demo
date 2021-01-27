package com.example.demo.controller;

import com.example.demo.model.TransporterCars;
import com.example.demo.model.TransporterTypes;
import com.example.demo.service.TransporterCarsService;
import com.example.demo.service.TransporterTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("transporterCarsTypes")
@RequiredArgsConstructor
public class TransporterTypesController {
    private final TransporterTypesService transporterTypesService;


    @GetMapping
    @Transactional()
    public List<TransporterTypes> getProduct(){
        return transporterTypesService.getAll();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<TransporterTypes> addProduct(@RequestBody TransporterTypes transporterTypes){

        return ResponseEntity.status(HttpStatus.CREATED).body(transporterTypesService.add(transporterTypes));
    }

    @PutMapping("{id}")
    public TransporterTypes updateCustomer(@PathVariable long id,
                                          @RequestBody TransporterTypes unsafeTranporterType) {
        TransporterTypes transporterTypes = transporterTypesService.get(id);
        transporterTypes.setType(unsafeTranporterType.getType());
        return transporterTypesService.update(unsafeTranporterType);
    }
    @GetMapping("{id}")
    public TransporterTypes getCustomer(@PathVariable long id) {
        return transporterTypesService.get(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        transporterTypesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
