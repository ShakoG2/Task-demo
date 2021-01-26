package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehousesRepository extends JpaRepository<Warehouses, Long> {

}
