package com.ucacue.AppCafeteria.web.controller;

import com.ucacue.AppCafeteria.domain.model.Product;
import com.ucacue.AppCafeteria.domain.service.ProductService;
import com.ucacue.AppCafeteria.web.dto.request.ProductRequest;
import com.ucacue.AppCafeteria.web.dto.response.ProductResponse;
import com.ucacue.AppCafeteria.web.mapper.ProductWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductWebMapper productWebMapper;

    public ProductController(ProductService productService, ProductWebMapper productWebMapper) {
        this.productService = productService;
        this.productWebMapper = productWebMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<Product> products = productService.getAll();
        List<ProductResponse> productResponse = productWebMapper.toProductsResponse(products);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        ProductResponse productResponse = productWebMapper.toProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/by-code")
    public ResponseEntity<ProductResponse> getByCode(@RequestParam String code) {
        Product product = productService.getByCode(code);
        ProductResponse productResponse = productWebMapper.toProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<ProductResponse>> getByName(@RequestParam String name) {
        List<Product> products = productService.getByName(name);
        List<ProductResponse> productResponse = productWebMapper.toProductsResponse(products);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/is-active-true")
    public ResponseEntity<List<ProductResponse>> getByActiveTrue() {
        List<Product> products = productService.getByActiveTrue();
        List<ProductResponse> productResponse = productWebMapper.toProductsResponse(products);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/is-active-false")
    public ResponseEntity<List<ProductResponse>> getByActiveFalse() {
        List<Product> products = productService.getByActiveFalse();
        List<ProductResponse> productResponse = productWebMapper.toProductsResponse(products);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productWebMapper.toProduct(productRequest);
        Product productSaved = productService.create(product, productRequest.idCategory());
        ProductResponse productResponse = productWebMapper.toProductResponse(productSaved);
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping()
    public ResponseEntity<ProductResponse> update(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productWebMapper.toProduct(productRequest);
        Product productSaved = productService.update(product, productRequest.idCategory());
        ProductResponse productResponse = productWebMapper.toProductResponse(productSaved);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
