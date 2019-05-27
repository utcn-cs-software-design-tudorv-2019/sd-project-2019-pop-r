package com.eventsweb.eventsweb.dao.impl;

import com.eventsweb.eventsweb.dao.CartItemDao;
import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


    @Repository
    @Transactional
    public class CartItemDaoImpl implements CartItemDao {
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public void addCartItem(CartItem cartItem) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(cartItem);
            session.flush();
        }

        @Override
        public void removeCartItem(CartItem cartItem) {
            Session session = sessionFactory.getCurrentSession();
            session.delete(cartItem);
            session.flush();
        }

        @Override
        public void removeAllCartItems(Cart cart) {
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem item : cartItems) {
                removeCartItem(item);
            }
        }

        @Override
        public CartItem getCartItemByEventId(int eventId) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from CartItem WHERE eventId=?");
            query.setInteger(0, eventId);
            session.flush();
            return (CartItem) query.uniqueResult();
        }
    }

