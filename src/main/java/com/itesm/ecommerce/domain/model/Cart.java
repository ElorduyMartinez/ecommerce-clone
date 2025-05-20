package com.itesm.ecommerce.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private int id;
    private List<CartHasProduct> productsInCart;
    private User user;
    private String status;
}
