package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Transporter_types_cars")
public class TransporterTypes {
    @Id
    @SequenceGenerator(name = "CustomerIdGen", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerIdGen")
    private Long id;

    @Column(name="transporter_types",nullable = false,columnDefinition ="text")
    private String type;
}
