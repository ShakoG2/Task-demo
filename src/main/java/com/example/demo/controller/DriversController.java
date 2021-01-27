//package com.example.demo.controller;
//
//
//import com.example.demo.model.Drivers;
//import com.example.demo.service.DriversService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@RestController
//@RequestMapping("drivers")
//@RequiredArgsConstructor
//public class DriversController {
//    private final DriversService driversService;
//
//
//
//    @GetMapping
//    @Transactional()
//    public List<Drivers> getProviders(){
//        return driversService.getAll();
//    }
//    @PostMapping
//    @Transactional
//    public ResponseEntity<Drivers> addProvider(@RequestBody Drivers drivers){
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(driversService.add(drivers));
//    }
//
//    @PutMapping("{id}")
//    public Drivers updateProvider(@PathVariable long id,
//                                    @RequestBody Drivers unsafeDriver) {
//        Drivers driver = driversService.get(id);
//        return driversService.update(unsafeDriver);
//    }
//    @GetMapping("{id}")
//    public Drivers getProvider(@PathVariable long id) {
//        return driversService.get(id);
//    }
//
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteProvider(@PathVariable long id) {
//        driversService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}
