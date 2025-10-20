package com.ucacue.AppCafeteria.domain.respository;

import com.ucacue.AppCafeteria.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAll();

    public Product getById(Long id);

    public Product getByCode(String code);

    public List<Product> getByName(String name);

    public List<Product> getByActiveTrue();

    public List<Product> getByActiveFalse();

    public Product create(Product product);

    public void delete(Long id);

    public boolean existsById(Long id);
}
