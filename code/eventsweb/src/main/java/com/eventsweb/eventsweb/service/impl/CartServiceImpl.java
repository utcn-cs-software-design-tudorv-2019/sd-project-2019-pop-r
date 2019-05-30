package com.eventsweb.eventsweb.service.impl;

import com.eventsweb.eventsweb.dao.CartDao;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
