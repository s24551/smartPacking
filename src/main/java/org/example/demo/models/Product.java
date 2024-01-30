package org.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id; // Unikalny identyfikator produktu, np. UUID
    private String name; // Nazwa produktu
    private String description; // Opis produktu
    private String imageUrl; // URL do zdjęcia poglądowego produktu
    private Location location; // Lokalizacja produktu w magazynie


    public Product() {
    }

    public Product(String id, String name, String description, String imageUrl, Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
// Konstruktory, gettery i settery
}

