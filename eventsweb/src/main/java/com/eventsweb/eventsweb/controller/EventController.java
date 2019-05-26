package com.eventsweb.eventsweb.controller;


import java.io.IOException;
import java.util.List;

import com.eventsweb.eventsweb.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/product"})
public class EventController {
    @Autowired
    private EventService eventService;

    public EventController() {
    }

    @RequestMapping({"/eventproductList"})
    public String getProducts(Model model) {
        List<Event> products = this.eventService.getEventList();
        model.addAttribute("events", products);
        return "eventList";
    }

    @RequestMapping({"/viewEvent/{eventId}"})
    public String viewEvent(@PathVariable int eventId, Model model) throws IOException {
        Event product = this.eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "viewEvent";
    }
}
