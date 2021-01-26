package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@Table(name="products")
@FieldNameConstants
@NoArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(name = "CustomerIdGen", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerIdGen")
    private Long id;


    @Column(name="provider_name",nullable = false,columnDefinition ="text")
    private String name;


    @Column(name="warehouses_name",nullable = false,columnDefinition = "text")
    private String warehouses;


    @Column(name="bran_name",nullable = false,columnDefinition = "text")
    private String brand;

    @Column(name="model_name",nullable = false,columnDefinition = "text")
    private String model;

    @Column(name="quantity_name",nullable = false)
    private BigDecimal quantity;

    @Column(name="price",nullable = false)
    private BigDecimal price;

    @Column(name="retail_price",nullable = false)
    private BigDecimal retailPrice;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    public Providers providers;

}
