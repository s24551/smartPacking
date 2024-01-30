package org.example.demo.services;

import org.example.demo.models.Product;
import org.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            // Obsługa błędu, np. rzucenie wyjątku
            throw new RuntimeException("Product not found for id: " + id);
        }
    }
    public Product findProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }


    public Product createProduct(Product product) {
        // Tutaj można dodać logikę walidacji lub inną logikę biznesową przed zapisaniem
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id); // Upewnij się, że aktualizowany obiekt ma prawidłowe ID
            return productRepository.save(updatedProduct);
        } else {
            // Obsługa błędu, np. rzucenie wyjątku
            throw new RuntimeException("Product not found for id: " + id);
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    // Dodatkowe metody specyficzne dla logiki biznesowej, np. wyszukiwanie produktów po lokalizacji
}
