package com.eventsweb.eventsweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventsweb.eventsweb.dao.EventDao;
import com.eventsweb.eventsweb.model.Event;

@Controller
public class HomeController {
	
	@Autowired
	private EventDao eventDao;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		List<Event> eventList=eventDao.getAllEvents();
		model.addAttribute("events", eventList);
		return "home";
	}
	
	public String viewEvent(@PathVariable String productId, Model model ) throws IOException
	{
		Event event = eventDao.getEventById(eventId);
		model.addAttribute(event);
		return "viewEvent";
	}
}
