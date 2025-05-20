package com.itesm.ecommerce.domain.repository;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    public Product insertProduct(Product product);
    public List<Product> findAllProducts();
    public void assignCategory(int product_id, int category_id);
}
