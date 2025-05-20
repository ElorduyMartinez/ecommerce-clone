package com.itesm.ecommerce.infrastructure.repository;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.domain.model.Product;
import com.itesm.ecommerce.domain.repository.ProductRepository;
import com.itesm.ecommerce.infrastructure.entity.CategoryEntity;
import com.itesm.ecommerce.infrastructure.entity.ProductEntity;
import com.itesm.ecommerce.infrastructure.mapper.ProductMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository, PanacheRepositoryBase<ProductEntity,Integer> {
    @Inject
    CategoryRepositoryImpl categoryRepository;
    @Override
    @Transactional
    public Product insertProduct(Product product) {
        ProductEntity productEntity= ProductMapper.toEntity(product);
        persist(productEntity);
        product=ProductMapper.toDomain(productEntity);
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        List<ProductEntity> productEntities= findAll().list();
        List<Product> products= new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            products.add(ProductMapper.toDomain(productEntity));
        }
        return products;
    }

    @Override
    @Transactional
    public void assignCategory(int product_id, int category_id) {
        ProductEntity productEntity = findById(product_id);
        CategoryEntity categoryEntity=categoryRepository.findById(category_id);
        productEntity.setCategory(categoryEntity);
        persist(productEntity);
    }

    public ProductEntity findById(int productId) {
        return find("id", productId).firstResult();
    }

}
