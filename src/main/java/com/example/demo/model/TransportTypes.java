package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="transport_Types")
public class TransportTypes {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="transport_type",nullable = false,columnDefinition = "text")
    private String type;

}
