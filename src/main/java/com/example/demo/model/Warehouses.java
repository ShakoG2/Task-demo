package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="warehouses")
public class Warehouses {

    @Id
    @SequenceGenerator(name = "CustomerIdGen", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerIdGen")
    private Long id;

    @Column(name="warehouses_name",nullable = false,columnDefinition ="text")
    private String name;

}
