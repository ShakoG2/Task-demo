package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name="products_table")
@FieldNameConstants
@NoArgsConstructor
public class Product {

    @Id
//    @SequenceGenerator(name = "CustomerIdGen", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue
    private Long id;


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

    @ManyToOne(fetch = FetchType.LAZY)
    public Providers providers;

//    @JsonManagedReference("product-warehouses")
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<Warehouses> warehousesAll;

}
