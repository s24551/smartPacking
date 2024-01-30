package org.example.demo.models;

public class Location {
    private String aisle; // Alejka w magazynie
    private String shelf; // Półka w magazynie
    private String position; // Dodatkowy identyfikator pozycji, jeśli potrzebny

    public Location() {
        // Konstruktor bezparametrowy
    }

    public Location(String aisle, String shelf, String position) {
        this.aisle = aisle;
        this.shelf = shelf;
        this.position = position;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
