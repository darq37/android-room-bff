package com.darq37.roombackend.domain;

import javax.persistence.*;


@Entity
public class SharedList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User owner;

    @OneToOne
    private ShoppingList shoppingList;

    public SharedList() {
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User sharedList_owner) {
        this.owner = sharedList_owner;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
