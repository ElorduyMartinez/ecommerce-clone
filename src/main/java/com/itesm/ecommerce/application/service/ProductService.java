package com.itesm.ecommerce.application.service;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.domain.model.Product;
import com.itesm.ecommerce.domain.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        product.setUuid(UUID.randomUUID().toString());
        product=productRepository.insertProduct(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public void assignCategory(int category_id, int product_id) {
        productRepository.assignCategory(product_id,category_id);

    }
}
