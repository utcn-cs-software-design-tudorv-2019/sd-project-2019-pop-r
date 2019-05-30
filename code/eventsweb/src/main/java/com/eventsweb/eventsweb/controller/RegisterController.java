package com.eventsweb.eventsweb.controller;

import com.eventsweb.eventsweb.model.BillingAddress;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.model.ShippingAddress;
import com.eventsweb.eventsweb.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("/register")
    public String registerClient(Model model) {
        Client client = new Client();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        client.setBillingAddress(billingAddress);
        client.setShippingAddress(shippingAddress);

        model.addAttribute("client", client);
        return "registerClient";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerClientPost(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerClient";
        }
        List<Client> clientList = clientService.getAllClients();
        for (int i=0; i<clientList.size(); i++) {
            if (client.getClientEmail().equals(clientList.get(i).getClientEmail())) {
                model.addAttribute("emailMsg", "email");
                return "registerClient";
            }

            if (client.getUsername().equals(clientList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "errorusername");
                return "registerClient";
            }

        }

        client.setEnabled(true);
        clientService.addClient(client);
        return "registerClientSuccess";
    }
}
