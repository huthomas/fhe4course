package at.example.calendar.google;

import java.util.List;

import com.google.api.services.calendar.model.Event;

public interface IGoogleCalendarService {

	public List<String> getCalendarIds();

	public List<Event> getEvents(String calendarId);

}
