package com.eventsweb.eventsweb.service;

import com.eventsweb.eventsweb.model.Cart;

public interface CartService {
    Cart getCartById(int cartId);
    void update(Cart cart);
}