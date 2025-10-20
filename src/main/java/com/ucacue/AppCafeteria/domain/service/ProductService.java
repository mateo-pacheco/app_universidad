package com.ucacue.AppCafeteria.domain.service;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.domain.model.Product;
import com.ucacue.AppCafeteria.domain.respository.ProductRepository;
import com.ucacue.AppCafeteria.domain.validation.ProductValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidation productValidation;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductValidation productValidation, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productValidation = productValidation;
        this.categoryService = categoryService;
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Transactional(readOnly = true)
    public Product getByCode(String code) {
        return productRepository.getByCode(code);
    }

    @Transactional(readOnly = true)
    public List<Product> getByName(String name) {
        return productRepository.getByName(name);
    }

    @Transactional(readOnly = true)
    public List<Product> getByActiveTrue() {
        return productRepository.getByActiveTrue();
    }

    @Transactional(readOnly = true)
    public List<Product> getByActiveFalse() {
        return productRepository.getByActiveFalse();
    }

    @Transactional
    public Product create(Product product, Long idCategory) {
        productValidation.createProduct(product);
        productValidation.validateName(product.getName());
        productValidation.validatePrice(product.getPurchasePrice());
        productValidation.validateActive(product.isActive());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Category category = categoryService.getById(idCategory);
        product.setCategory(category);
        return productRepository.create(product);
    }

    @Transactional
    public Product update(Product product, Long idCategory) {
        if (productRepository.existsById(product.getIdProduct())) {
            productValidation.updateProduct(product);
            productValidation.validateName(product.getName());
            productValidation.validatePrice(product.getPurchasePrice());
            productValidation.validateActive(product.isActive());
            Product oldProduct = productRepository.getById(product.getIdProduct());
            product.setCreatedAt(oldProduct.getCreatedAt());
            product.setUpdatedAt(LocalDateTime.now());
            Category category = categoryService.getById(idCategory);
            product.setCategory(category);
            return productRepository.create(product);
        }  else {
            throw new IllegalStateException("El producto no existe");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (productRepository.existsById(id)) {
            productValidation.deleteProduct(id);
            productRepository.delete(id);
        }
    }
}
