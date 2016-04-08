
package at.example.calendar.handlers;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.example.calendar.google.IGoogleCalendarService;

public class AddCalendarHandler {
	@Inject
	IGoogleCalendarService gService;

	@Execute
	public void execute(Shell parentShell) {
		InputDialog dialog = new InputDialog(parentShell, "New Calendar", "Calendar name", "", new IInputValidator() {

			@Override
			public String isValid(String newText) {
				if (newText != null && !newText.isEmpty()) {
					return null;
				}
				return "Calendar name can not be empty";
			}
		});

		if (dialog.open() == InputDialog.OK) {
			try {
				gService.createCalendar(dialog.getValue());
			} catch (GeneralSecurityException | IOException e) {
				MessageDialog.openError(parentShell, "Error", "Could not create calendar. " + e.getMessage());
			}
		}
	}
}