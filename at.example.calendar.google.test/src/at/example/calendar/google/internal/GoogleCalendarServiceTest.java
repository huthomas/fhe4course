package at.example.calendar.google.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.junit.Test;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;

public class GoogleCalendarServiceTest {

	@Test
	public void getCalendarService() throws GeneralSecurityException, IOException {
		GoogleCalendarService gService = new GoogleCalendarService();
		Calendar service = gService.getCalendarService();
		assertNotNull(service);
	}

	@Test
	public void getCalendars() throws GeneralSecurityException, IOException {
		GoogleCalendarService gService = new GoogleCalendarService();
		List<CalendarListEntry> calendars = gService.getCalendars();
		assertNotNull(calendars);
		assertFalse(calendars.isEmpty());
	}
}
