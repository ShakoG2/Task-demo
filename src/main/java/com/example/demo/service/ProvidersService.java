package com.example.demo.service;

import com.example.demo.model.Providers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvidersService {

    List <Providers> getAll();

    Providers get(long id);

    Providers add(Providers providers);

    Providers update(Providers providers);

    void delete(long id);
}
