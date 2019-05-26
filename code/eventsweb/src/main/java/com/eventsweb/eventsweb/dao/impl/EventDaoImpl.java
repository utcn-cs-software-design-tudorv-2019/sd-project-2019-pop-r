package com.eventsweb.eventsweb.dao.impl;


import java.util.List;

import com.eventsweb.eventsweb.dao.EventDao;
import com.eventsweb.eventsweb.model.Event;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EventDaoImpl implements EventDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Event event;

    public EventDaoImpl() {
    }
        @Override
        public List<Event> getEventList() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Event");
        List<Event> eventList = query.list();
        session.flush();
        return eventList;
    }
    @Override
    public Event getEventById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event Event = (Event)session.get(Event.class, id);
        session.flush();
        return event;
    }
    @Override
    public void addEvent(Event event) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(event);
        session.flush();
    }
    @Override
    public void editEvent(Event event) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(event);
        session.flush();
    }
    @Override
    public void deleteEvent(Event event) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(event);
    }
}
