package com.example.demo.service;

import com.example.demo.model.TransporterCars;
import com.example.demo.model.TransporterTypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransporterTypesService {
    List<TransporterTypes> getAll();

    TransporterTypes get(long id);

    TransporterTypes add(TransporterTypes transporterTypes);

    TransporterTypes update(TransporterTypes transporterTypes);

    void delete(long id);
}
