
package com.example.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    public Product(BigInteger productId, String productName, double productPrice) {

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product() {

    }

}
