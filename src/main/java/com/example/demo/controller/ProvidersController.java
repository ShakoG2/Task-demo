package com.example.demo.controller;


import com.example.demo.model.Providers;

import com.example.demo.service.ProvidersService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("providers")
@RequiredArgsConstructor
public class ProvidersController {

    private final ProvidersService providersService;



    @GetMapping
    @Transactional()
    public List<Providers> getProviders(){
        return providersService.getAll();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Providers> addProvider(@RequestBody Providers providers){

        return ResponseEntity.status(HttpStatus.CREATED).body(providersService.add(providers));
    }

    @PutMapping("{id}")
    public Providers updateProvider(@PathVariable long id,
                                  @RequestBody Providers unsafeProviders) {
       Providers providers = providersService.get(id);
       providers.setName(unsafeProviders.getName());
        return providersService.update(unsafeProviders);
    }
    @GetMapping("{id}")
    public Providers getProvider(@PathVariable long id) {
        return providersService.get(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable long id) {
        providersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
