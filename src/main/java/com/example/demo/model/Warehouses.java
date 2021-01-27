package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Data
@Entity
@Table(name="warehouses")
@FieldNameConstants
public class Warehouses {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="warehouses_name",nullable = false,columnDefinition ="text")
    private String name;
//
//    @JsonBackReference("product-warehouses")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;

}
