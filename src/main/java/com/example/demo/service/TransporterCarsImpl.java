package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.TransporterCars;
import com.example.demo.repository.TransporterCarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransporterCarsImpl implements TransporterCarsService {

    private final TransporterCarsRepository transporterCarsRepository;


    @Override
    public List<TransporterCars> getAll(){
        return transporterCarsRepository.findAll();
    }


    @Override
    public TransporterCars get(long id){
        String msg = String.format("Transport with id: %d Not Found", id);
        return transporterCarsRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public TransporterCars add(TransporterCars transporterCars){
        transporterCars.setId(null);
        return transporterCarsRepository.save(transporterCars);
    }

    @Override
    public  TransporterCars update(TransporterCars transporterCars){
        return  transporterCarsRepository.save(transporterCars);
    }


    @Override
    public void  delete(long id){
        get(id);
        transporterCarsRepository.deleteById(id);
    }

}
