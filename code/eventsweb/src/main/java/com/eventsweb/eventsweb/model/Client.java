package com.eventsweb.eventsweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue
    private int clientId;
    @NotEmpty(
        message = "Enter an id!"
    )
    private String clientName;
    @NotEmpty(
        message = "Enter name!"
    )
    private String clientEmail;
    private String clientPhone;
    @NotEmpty(
        message = "Enter email and password!"
    )
    private String username;
    @NotEmpty(
        message = "Your username please!"
    )
    private String password;
    private boolean enabled;
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
    @OneToOne
    @JoinColumn(
        name = "cartId"
    )
    @JsonIgnore
    private Cart cart;

    public Client() {
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return this.clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return this.clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
