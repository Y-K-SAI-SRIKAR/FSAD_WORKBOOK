package com.klu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.klu.model.Product;
import com.klu.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Category search
    public List<Product> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    // Price range filter
    public List<Product> getByPriceRange(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    // Sorted products
    public List<Product> getSortedProducts() {
        return repository.findAllSortedByPrice();
    }

    // Expensive products
    public List<Product> getExpensiveProducts(double price) {
        return repository.findExpensiveProducts(price);
    }
    public Product saveProduct(Product p) {
        return repository.save(p);
    }
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

}
