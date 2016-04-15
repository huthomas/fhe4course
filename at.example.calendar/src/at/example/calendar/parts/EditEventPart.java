
package at.example.calendar.parts;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.api.services.calendar.model.Event;

import at.example.calendar.google.IGoogleCalendarService;
import at.example.calendar.ui.model.ModelPackage;
import at.example.calendar.ui.model.UIEvent;

public class EditEventPart {

	@Inject
	IGoogleCalendarService gService;

	@Inject
	MDirtyable dirty;

	private UIEvent event;

	@Inject
	public EditEventPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent, IEclipseContext context) {

		event = (UIEvent) context.get("event.list.selection");

		parent.setLayout(new GridLayout(2, false));

		Label lbl = new Label(parent, SWT.NONE);
		lbl.setText("Name");
		Text text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		DataBindingContext ctx = new DataBindingContext();

		ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(text),
				EMFProperties.value(ModelPackage.Literals.UI_EVENT__NAME).observe(event));

		WidgetProperties.text(SWT.Modify).observe(text).addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				dirty.setDirty(true);
			}
		});
	}

	@Persist
	public void save() {
		Event gEvent = (Event) event.getObject();
		gEvent.setSummary(event.getName());
		try {
			gService.saveEvent(gEvent);
			dirty.setDirty(false);
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}