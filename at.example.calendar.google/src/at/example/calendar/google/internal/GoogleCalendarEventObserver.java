package at.example.calendar.google.internal;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Timer;
import java.util.TimerTask;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Events;

public class GoogleCalendarEventObserver {

	private GoogleCalendarService calendarService;
	private CalendarListEntry calendar;

	private Timer timer;

	public GoogleCalendarEventObserver(GoogleCalendarService googleCalendarService, CalendarListEntry calendar) {
		this.calendarService = googleCalendarService;
		this.calendar = calendar;
		timer = new Timer();
	}

	public void start() throws GeneralSecurityException, IOException {
		final Calendar gService = calendarService.getCalendarService();

		timer.schedule(new TimerTask() {
			private String currentEventsString = "";

			@Override
			public void run() {
				try {
					Events events = gService.events().list(calendar.getId()).execute();
					String eventsString = events.toPrettyString();
					if (!eventsString.equals(currentEventsString)) {
						// send update
						calendarService.sendEventsUpdate(calendar, events.getItems());
						currentEventsString = eventsString;
					}
				} catch (IOException e) {
					// just print out and try again
					e.printStackTrace();
				}
			}
		}, 1000, 5000);
	}

	public void stop() {
		timer.cancel();
	}
}
