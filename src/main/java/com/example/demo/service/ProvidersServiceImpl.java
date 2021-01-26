package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Providers;
import com.example.demo.model.Warehouses;
import com.example.demo.repository.ProvidersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class ProvidersServiceImpl implements ProvidersService {
    private final ProvidersRepository providersRepository;

    public ProvidersServiceImpl(ProvidersRepository providersRepository) {
        this.providersRepository = providersRepository;
    }
    @Override
    public List<Providers> getAll(){
        return providersRepository.findAll();
    }

    @Override
    public Providers get(long id){
        String msg = String.format("Customer with id: %d Not Found", id);
        return providersRepository.findById(id).orElseThrow(() -> new NotFoundException(msg));
    }

    @Override
    public Providers add(Providers providers){
        return providersRepository.save(providers);
    }

    @Override
    public  Providers update(Providers providers){
        return  providersRepository.save(providers);
    }
    @Override
    public void  delete(long id){
        get(id);
        providersRepository.deleteById(id);
    }
}
