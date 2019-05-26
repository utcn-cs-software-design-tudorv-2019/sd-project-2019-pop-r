package com.eventsweb.eventsweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventsDescription() {
		return eventsDescription;
	}
	public void setEventsDescription(String eventsDescription) {
		this.eventsDescription = eventsDescription;
	}
	public double getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(double eventPrice) {
		this.eventPrice = eventPrice;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public int getTicketsAvailable() {
		return ticketsAvailable;
	}
	public void setTicketsAvailable(int ticketsAvailable) {
		this.ticketsAvailable = ticketsAvailable;
	}
	public String getEventPlace() {
		return eventPlace;
	}
	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}
	
	private String eventId;
	private String eventName;
	private String eventType;
	private String eventsDescription;
	private double eventPrice;
	private String eventStatus;
	private int ticketsAvailable;
	private String eventPlace;
}
