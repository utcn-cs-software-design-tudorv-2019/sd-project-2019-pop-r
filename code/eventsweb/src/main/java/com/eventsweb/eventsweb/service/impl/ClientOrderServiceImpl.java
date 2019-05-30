package com.eventsweb.eventsweb.service.impl;

import com.eventsweb.eventsweb.dao.ClientOrderDao;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.model.ClientOrder;
import com.eventsweb.eventsweb.service.CartService;
import com.eventsweb.eventsweb.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {
    @Autowired
    private ClientOrderDao clientOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addClientOrder(ClientOrder clientOrder) {
        clientOrderDao.addClientOrder(client);
    }

    @Override
    public double getClientOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }
}
