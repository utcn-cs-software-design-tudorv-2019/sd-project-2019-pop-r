package com.eventsweb.eventsweb.service;

import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByEventId(int eventId);
}