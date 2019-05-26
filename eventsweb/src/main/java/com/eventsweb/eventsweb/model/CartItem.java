package com.eventsweb.eventsweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable {
    //private static final long serialVersionUID = 4682741580084876347L;
    @Id
    @GeneratedValue
    private int cartItemId;
    @ManyToOne
    @JoinColumn(
        name = "cartId"
    )
    @JsonIgnore
    private Cart cart;
    @ManyToOne
    @JoinColumn(
        name = "eventId"
    )
    private Event event;
    private int quantity;
    private double totalPrice;

    public CartItem() {
    }

    public int getCartId() {
        return this.cartItemId;
    }

    public void setCartId(int cartId) {
        this.cartItemId = cartId;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
