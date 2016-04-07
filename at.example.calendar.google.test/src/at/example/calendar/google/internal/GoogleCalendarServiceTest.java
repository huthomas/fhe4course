package at.example.calendar.google.internal;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Test;

import com.google.api.services.calendar.Calendar;

public class GoogleCalendarServiceTest {

	@Test
	public void getCalendarServcie() throws GeneralSecurityException, IOException {
		GoogleCalendarService gService = new GoogleCalendarService();
		Calendar service = gService.getCalendarService();
		assertNotNull(service);
	}
}
