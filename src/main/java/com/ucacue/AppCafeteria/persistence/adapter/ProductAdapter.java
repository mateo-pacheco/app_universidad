package com.ucacue.AppCafeteria.persistence.adapter;

import com.ucacue.AppCafeteria.domain.model.Product;
import com.ucacue.AppCafeteria.domain.respository.ProductRepository;
import com.ucacue.AppCafeteria.persistence.entity.ProductEntity;
import com.ucacue.AppCafeteria.persistence.mapper.ProductMapper;
import com.ucacue.AppCafeteria.persistence.springData.ProductData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductAdapter implements ProductRepository {

    private final ProductData productData;
    private final ProductMapper productMapper;

    public ProductAdapter(ProductData productData, ProductMapper productMapper) {
        this.productData = productData;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productsEntity = productData.findAll();
        return productMapper.toProducts(productsEntity);
    }

    @Override
    public Product getById(Long id) {
        ProductEntity productEntity = productData.findById(id).orElseThrow(
                () ->  new EntityNotFoundException("Product not found with id: " + id)
        );
        return productMapper.toProduct(productEntity);
    }

    @Override
    public Product getByCode(String code) {
        ProductEntity productEntity = productData.findByCode(code).orElseThrow(
                () ->  new EntityNotFoundException("Product not found with code: " + code)
        );
        return productMapper.toProduct(productEntity);
    }

    @Override
    public List<Product> getByName(String name) {
        List<ProductEntity> productEntity = productData.findAllByNameIgnoreCase(name);
        return productMapper.toProducts(productEntity);
    }

    @Override
    public List<Product> getByActiveTrue() {
        List<ProductEntity> productEntities = productData.findByActiveTrue();
        return productMapper.toProducts(productEntities);
    }

    @Override
    public List<Product> getByActiveFalse() {
        List<ProductEntity> productEntities = productData.findByActiveFalse();
        return productMapper.toProducts(productEntities);
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        ProductEntity productEntitySaved = productData.save(productEntity);
        return productMapper.toProduct(productEntitySaved);
    }

    @Override
    public void delete(Long id) {
        productData.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productData.existsById(id);
    }
}
