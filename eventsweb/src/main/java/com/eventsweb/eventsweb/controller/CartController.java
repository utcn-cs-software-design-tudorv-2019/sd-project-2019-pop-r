package com.eventsweb.eventsweb.controller;

import com.eventsweb.eventsweb.model.Client;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
    @Autowired
    private ClientService clientService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        int cartId = client.getCart().getCartId();

        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}