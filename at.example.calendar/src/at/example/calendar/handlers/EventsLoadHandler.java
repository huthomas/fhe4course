
package at.example.calendar.handlers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;

import at.example.calendar.google.IGoogleCalendarService;
import at.example.calendar.ui.model.ModelFactory;
import at.example.calendar.ui.model.UIEvent;

public class EventsLoadHandler {
	@Inject
	ESelectionService selection;

	@Inject
	IGoogleCalendarService gService;

	@Execute
	public void execute(Shell parentShell) {
		try {
			List<CalendarListEntry> calendars = gService.getCalendars();
			for (CalendarListEntry calendarListEntry : calendars) {
				System.out.println(calendarListEntry.getSummary());
				if (calendarListEntry.getSummary().equals("fhe4course@gmail.com")) {
					List<Event> events = gService.getEvents(calendarListEntry);
					List<UIEvent> uiEvents = new ArrayList<UIEvent>();
					for (Event event : events) {
						UIEvent uiEvent = ModelFactory.eINSTANCE.createUIEvent();
						uiEvent.setName(event.getSummary());
						uiEvent.setObject(event);
						uiEvents.add(uiEvent);
					}
					selection.setSelection(uiEvents);
				}
			}
		} catch (GeneralSecurityException | IOException e) {
			MessageDialog.openError(parentShell, "Error", "Could not list events. " + e.getMessage());
		}
	}

}