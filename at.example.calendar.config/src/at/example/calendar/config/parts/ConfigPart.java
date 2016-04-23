
package at.example.calendar.config.parts;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

import com.google.api.services.calendar.model.CalendarListEntry;

import at.example.calendar.google.IGoogleCalendarService;

public class ConfigPart {
	@Inject
	private IGoogleCalendarService gService;

	@Inject
	public ConfigPart() {

	}

	@PostConstruct
	public void postConstruct(Composite parent, Shell parentShell,
			@Preference("at.example.calendar") IEclipsePreferences preference) {
		parent.setLayout(new GridLayout(2, false));
		try {
			List<CalendarListEntry> calendars = gService.getCalendars();

			ComboViewer comboViewer = new ComboViewer(parent);
			comboViewer.setContentProvider(new ArrayContentProvider());
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					if (element instanceof CalendarListEntry) {
						return ((CalendarListEntry) element).getSummary();
					}
					return super.getText(element);
				}
			});
			comboViewer.setInput(calendars);
			// get initial selection from preference
			String selectedId = preference.get("selectedCalendarId", null);
			if (selectedId != null) {
				for (CalendarListEntry calendarListEntry : calendars) {
					if (calendarListEntry.getId().equals(selectedId)) {
						comboViewer.setSelection(new StructuredSelection(calendarListEntry));
						break;
					}
				}
			}

			Button btn = new Button(parent, SWT.PUSH);
			btn.setText("observe");
			// start observing and set selection to preference
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					StructuredSelection selection = (StructuredSelection) comboViewer.getSelection();
					if (selection != null && !selection.isEmpty()) {
						try {
							CalendarListEntry selCalendar = (CalendarListEntry) selection.getFirstElement();
							preference.put("selectedCalendarId", selCalendar.getId());
							preference.flush();

							gService.startEventObserver(selCalendar);
						} catch (GeneralSecurityException | IOException | BackingStoreException e1) {
							MessageDialog.openError(parentShell, "Error", "Could not list events. " + e1.getMessage());
						}
					}
				}
			});
		} catch (GeneralSecurityException | IOException e) {
			MessageDialog.openError(parentShell, "Error", "Could not list events. " + e.getMessage());
		}
	}
}