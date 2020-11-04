package com.darq37.roombackend.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "shopping_lists")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private User owner;

    @ManyToMany
    private List<Product> products;

    private Date created;

    private Date edited;

    public ShoppingList() {
    }


    public ShoppingList(String name, User owner, List<Product> products) {
        this.name = name;
        this.owner = owner;
        this.products = products;
        this.created = new Date();
        this.edited = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }
}
