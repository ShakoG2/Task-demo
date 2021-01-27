package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Drivers;
import com.example.demo.repository.DriversRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriversServiceImpl implements DriversService {

    private final DriversRepository driversRepository;

    @Override
    public List<Drivers> getAll(){
        return driversRepository.findAll();
    }

    @Override
    public Drivers get(long id){
        String msg = String.format("driver with id: %d Not Found", id);
        return driversRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public Drivers add(Drivers drivers){
        drivers.setId(null);
        return driversRepository.save(drivers);
    }

    @Override
    public Drivers update(Drivers drivers){
        return  driversRepository.save(drivers);
    }
    @Override
    public void  delete(long id){
        get(id);
        driversRepository.deleteById(id);
    }
}
