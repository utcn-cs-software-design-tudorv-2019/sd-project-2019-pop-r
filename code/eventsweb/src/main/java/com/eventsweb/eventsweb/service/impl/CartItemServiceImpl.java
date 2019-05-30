package com.eventsweb.eventsweb.service.impl;

import com.eventsweb.eventsweb.dao.CartItemDao;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;
import com.eventsweb.eventsweb.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByEventId(int productId) {
        return cartItemDao.getCartItemByEventId(productId);
    }
}
