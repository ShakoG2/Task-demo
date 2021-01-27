package com.example.demo.service;


import com.example.demo.model.TransporterCars;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransporterCarsService {
    List<TransporterCars> getAll();

    TransporterCars get(long id);

    TransporterCars add(TransporterCars transporterCars);

    TransporterCars update(TransporterCars transporterCars);

    void delete(long id);
}
