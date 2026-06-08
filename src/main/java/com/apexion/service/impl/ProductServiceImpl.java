package com.apexion.service.impl;

import com.apexion.model.Product;
import com.apexion.model.Seller;
import com.apexion.repository.ProductRepository;
import com.apexion.request.CreateProductRequest;
import com.apexion.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(CreateProductRequest req, Seller seller) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product findProductById(Long productId) {
        return null;
    }

    @Override
    public List<Product> searchProducts() {
        return List.of();
    }

    @Override
    public Page<Product> getAllProducts(String category, String brand, String colors, String sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber) {
        return null;
    }

    @Override
    public List<Product> getProductBySellerId(Long sellerId) {
        return List.of();
    }
}
