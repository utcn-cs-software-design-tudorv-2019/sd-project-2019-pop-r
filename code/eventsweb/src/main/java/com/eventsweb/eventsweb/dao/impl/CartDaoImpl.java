package com.eventsweb.eventsweb.dao.impl;
import com.eventsweb.eventsweb.dao.CartDao;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ClientOrderService clientOrderService;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    @Override
    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = clientOrderService.getClientOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null||cart.getCartItems().size() == 0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
}
