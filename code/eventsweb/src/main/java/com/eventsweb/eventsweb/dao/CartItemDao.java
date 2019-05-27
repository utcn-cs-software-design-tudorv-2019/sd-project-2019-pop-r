package com.eventsweb.eventsweb.dao;

import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByEventId(int eventId);
}
