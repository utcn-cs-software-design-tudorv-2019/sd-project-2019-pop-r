package com.eventsweb.eventsweb.service.impl;

import com.eventsweb.eventsweb.dao.EventDao;
import com.eventsweb.eventsweb.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventsweb.eventsweb.model.Event;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao eventDao;


    @Override
    public List<Event> getEventList() {
        return eventDao.getEventList();
    }

    @Override
    public Event getEventById(int eventId) {
        return eventDao.getEventById(eventId);
    }

    @Override
    public void addEvent(Event event) {

        eventDao.addEvent(event);
    }

    @Override
    public void editEvent(Event event) {

        eventDao.editEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {

        eventDao.deleteEvent(event);
    }
}
