package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="transporter_cars")
public class TransporterCars {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="transporter_cars_type",nullable = false,columnDefinition = "text")
    private String type;

    @Column(name="transporter_car_number",nullable = false)
    private BigDecimal number;

    @Column(name="transporter_car_mark",nullable = false,columnDefinition = "text")
    private String carMark;


    @Column(name="transporter_car_model",nullable = false,columnDefinition = "text")
    private String carModel;


    @Column(name="transporter_car_date_ofissue",nullable = false,columnDefinition = "text")
    private Date dateOfIssue;
}
