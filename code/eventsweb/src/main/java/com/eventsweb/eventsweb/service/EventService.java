package com.eventsweb.eventsweb.service;

import com.eventsweb.eventsweb.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getEventList();
    Event getEventById(int id);
    void addEvent(Event event);
    void editEvent(Event event);
    void deleteEvent(Event event);
}