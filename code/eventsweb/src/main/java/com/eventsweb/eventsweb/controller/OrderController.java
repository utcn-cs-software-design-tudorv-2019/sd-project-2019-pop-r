package com.eventsweb.eventsweb.controller;

import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.model.ClientOrder;
import com.eventsweb.eventsweb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ClientOrderService clientOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable(value = "cartId") int cartId) {
        ClientOrder clientOrder = new Client()Order();
        Cart cart = cartService.getCartById(cartId);
        clientOrder.setCart(cart);

        Client client = cart.getClient();
        clientOrder.setClient(client);
        clientOrder.setBillingAddress(client.getBillingAddress());
        clientOrder.setShippingAddress(client.getShippingAddress());

        clientOrderService.addClientOrder(clientOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
