package com.eventsweb.eventsweb.dao;


import com.eventsweb.eventsweb.model.Event;

import java.util.List;

public interface EventDao {
	List<Event> getEventList();

	Event getEventById(int var1);

	void addEvent(Event var1);

	void editEvent(Event var1);

	void deleteEvent(Event var1);
}
