package com.ecommerce.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private Integer qty;

    @Column
    private String categoryName;
}
