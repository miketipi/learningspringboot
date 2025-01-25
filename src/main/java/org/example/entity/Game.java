package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String gameName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    public Game() {
    }

    public Game(int id, String gameName, String description, Double price) {
        this.id = id;
        this.gameName = gameName;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
