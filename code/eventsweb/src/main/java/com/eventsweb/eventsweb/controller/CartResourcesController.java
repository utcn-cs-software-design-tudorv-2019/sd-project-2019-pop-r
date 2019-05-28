package com.eventsweb.eventsweb.controller;

import com.eventsweb.eventsweb.model.Cart;
import com.eventsweb.eventsweb.model.CartItem;
import com.eventsweb.eventsweb.model.Client;
import com.eventsweb.eventsweb.model.Event;
import com.eventsweb.eventsweb.service.CartService;
import com.eventsweb.eventsweb.service.EventService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResourcesController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    protected EventService eventService;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "eventId") int eventId, @AuthenticationPrincipal User activeUser) {
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        Cart cart = client.getCart();

        Event event = eventService.getEventById(eventId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i<cartItems.size(); i++) {
            if (event.getEventId() == cartItems.get(i).getEvent().getEventId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(event.getEventPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;

            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setEvent(event);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(event.getEventPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);

    }

    @RequestMapping(value = "/remove/{eventId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "eventId") int eventId) {
        CartItem cartItem = cartItemService.getCartItemByEventId(eventId);
        cartItemService.removeCartItem(cartItem);
    }
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors(Exception e){}
}
