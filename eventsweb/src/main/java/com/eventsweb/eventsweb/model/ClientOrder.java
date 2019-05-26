package com.eventsweb.eventsweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ClientOrder implements Serializable {
   // private static final long serialVersionUID = 403095271512333664L;
    @Id
    @GeneratedValue
    private int clientOrderId;
    @OneToOne
    @JoinColumn(
        name = "cartId"
    )
    private Cart cart;
    @OneToOne
    @JoinColumn(
        name = "clientId"
    )
    private Client client;
    @OneToOne
    @JoinColumn(
        name = "billingAddressId"
    )
    private BillingAddress billingAddress;
    @OneToOne
    @JoinColumn(
        name = "shippingAddressId"
    )
    private ShippingAddress shippingAddress;

    public ClientOrder() {
    }

    public int getClientOrderId() {
        return this.clientOrderId;
    }

    public void setClientOrderId(int clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClientr(Client client) {
        this.client = client;
    }

    public BillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}

