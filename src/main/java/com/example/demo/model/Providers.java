package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="providers")
public class Providers {

    @Id
    @SequenceGenerator(name = "CustomerIdGen", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerIdGen")
    private Long id;

    @Column(name="providers_name",nullable = false,columnDefinition ="text")
    private String name;
}
