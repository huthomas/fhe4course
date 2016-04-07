package at.example.calendar.google;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;

public interface IGoogleCalendarService {

	public List<CalendarListEntry> getCalendars() throws GeneralSecurityException, IOException;

	public List<Event> getEvents(CalendarListEntry calendar) throws GeneralSecurityException, IOException;

	public Calendar createCalendar(String name) throws GeneralSecurityException, IOException;
}
