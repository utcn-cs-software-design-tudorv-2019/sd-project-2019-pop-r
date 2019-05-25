package com.eventsweb.eventsweb.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.eventsweb.eventsweb.model.Event;

public class EventDao {
	
	private List<Event> eventList;
	
	public List<Event> getEventList()
	{
	Event event1= new Event();
	event1.setEventId("ID01");
	event1.setEventName("Concert Ac/Dc");
	event1.setEventType("Concert");
	event1.setEventsDescription("We are happy to announce that will have this concert!");
	event1.setEventPrice(300);
	event1.setTicketsAvailable(1000);
	event1.setEventPlace("Cluj Arena");
	event1.setEventStatus("Active");
	
	Event event2= new Event();
	event2.setEventId("ID02");
	event2.setEventName("Festival de Carte");
	event2.setEventType("Festival");
	event2.setEventsDescription("We are happy to announce that will have this festival!");
	event2.setEventPrice(50);
	event2.setTicketsAvailable(100);
	event2.setEventPlace("Sala Polivalenta");
	event2.setEventStatus("Festival");
	
	eventList= new ArrayList<Event>();
	eventList.add(event1);
	eventList.add(event2);
	
	return eventList;
	}
	public Event getEventById(String eventId) throws IOException
	{
		for(Event event : getEventList())
		{
			if(event.getEventId().equals(eventId))
			{
				return event;
			}
		}
		throw new IOException("No event found!");
	}
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
