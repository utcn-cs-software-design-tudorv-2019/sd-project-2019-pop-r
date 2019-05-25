package com.eventsweb.eventsweb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart implements Serializable {
    //private static final long serialVersionUID = 8246032589617456834L;
    @Id
    @GeneratedValue
    private int cartId;
    @OneToMany(
        mappedBy = "cart",
        cascade = {CascadeType.ALL},
        fetch = FetchType.EAGER
    )
    private List<CartItem> cartItems;
    @OneToOne
    @JoinColumn(
        name = "clientId"
    )
    @JsonIgnore
    private Client client;
    private double grandTotal;

    public Cart() {
    }

    public int getCartId() {
        return this.cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}