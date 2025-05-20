package com.itesm.ecommerce.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_has_products")
@Getter
@Setter
public class CartHasProductsEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private int quantity;

}
