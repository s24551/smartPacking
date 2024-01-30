package org.example.demo.repositories;

import org.example.demo.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Tutaj możesz dodać własne metody zapytań, np. wyszukiwanie produktów po nazwie
    // List<Product> findByName(String name);
    Optional<Product> findByName(String name);
    boolean existsByName(String name);

}
