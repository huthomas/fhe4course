package at.example.calendar.google.internal;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import at.example.calendar.google.IGoogleCalendarService;

public class GoogleCalendarService implements IGoogleCalendarService {

	private static final String APPLICATION_NAME = "fhe4course";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".store/e4_calendar_sample");

	private Calendar calendarService;
	private JsonFactory jsonFactory;
	private HttpTransport httpTransport;

	protected Calendar getCalendarService() throws GeneralSecurityException, IOException {
		if (calendarService == null) {
			calendarService = createCalendarService();
		}
		return calendarService;
	}

	private JsonFactory getJsonFactory() {
		if (jsonFactory == null) {
			jsonFactory = JacksonFactory.getDefaultInstance();
		}
		return jsonFactory;
	}

	private HttpTransport getHttpTransport() throws GeneralSecurityException, IOException {
		if (httpTransport == null) {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		}
		return httpTransport;
	}

	private Calendar createCalendarService() throws GeneralSecurityException, IOException {
		return new Calendar.Builder(getHttpTransport(), getJsonFactory(), getCredential())
				.setApplicationName(APPLICATION_NAME).build();
	}

	private Credential getCredential() throws IOException {
		// load client secrets
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(getJsonFactory(),
				new InputStreamReader(GoogleCalendarService.class.getResourceAsStream("/rsc/client_secrets.json")));
		// set up authorization code flow
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, getJsonFactory(),
				clientSecrets, Collections.singleton(CalendarScopes.CALENDAR))
						.setDataStoreFactory(new FileDataStoreFactory(DATA_STORE_DIR)).build();
		// authorize
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}

	@Override
	public List<CalendarListEntry> getCalendars() throws GeneralSecurityException, IOException {
		Calendar gService = getCalendarService();
		CalendarList cList = gService.calendarList().list().execute();
		if (cList != null && !cList.isEmpty()) {
			return cList.getItems();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Event> getEvents(CalendarListEntry calendar) throws GeneralSecurityException, IOException {
		Calendar gService = getCalendarService();
		Events events = gService.events().list(calendar.getId()).execute();
		if (events != null && !events.isEmpty()) {
			return events.getItems();
		}
		return Collections.emptyList();
	}

	@Override
	public com.google.api.services.calendar.model.Calendar createCalendar(String summary)
			throws GeneralSecurityException, IOException {
		Calendar gService = getCalendarService();

		// Create a new calendar
		com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
		calendar.setSummary(summary);

		// Insert the new calendar
		com.google.api.services.calendar.model.Calendar createdCalendar = gService.calendars().insert(calendar)
				.execute();

		return createdCalendar;
	}
}
