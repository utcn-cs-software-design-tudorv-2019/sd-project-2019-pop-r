package com.eventsweb.eventsweb.service;

import com.eventsweb.eventsweb.model.ClientOrder;

public interface ClientOrderService {
    void addClientOrder(ClientOrder clientOrder);
    double getClientOrderGrandTotal(int cartId);
}