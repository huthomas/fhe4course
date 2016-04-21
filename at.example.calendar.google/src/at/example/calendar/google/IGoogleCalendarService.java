package at.example.calendar.google;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;

public interface IGoogleCalendarService {

	public final String EVENTSUPDATE = "at/example/google/events/update";

	public List<CalendarListEntry> getCalendars() throws GeneralSecurityException, IOException;

	public List<Event> getEvents(CalendarListEntry calendar) throws GeneralSecurityException, IOException;

	public void startEventObserver(CalendarListEntry calendar) throws GeneralSecurityException, IOException;

	public Calendar createCalendar(String name) throws GeneralSecurityException, IOException;

	public void saveEvent(Event event) throws GeneralSecurityException, IOException;
}
