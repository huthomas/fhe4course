
package at.example.calendar.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.google.api.services.calendar.model.Event;

import at.example.calendar.google.IGoogleCalendarService;
import at.example.calendar.handlers.EventsLoadHandler;

public class EventListPart {
	private TableViewer viewer;

	@Inject
	public EventListPart() {

	}

	@PostConstruct
	public void postConstruct(Composite parent, EPartService partService, EModelService modelService,
			MPerspective perspective) {
		parent.setLayout(new FillLayout());
		viewer = new TableViewer(parent);
		ComposedAdapterFactory factory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(factory));

		viewer.setContentProvider(new AdapterFactoryContentProvider(factory));

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			// set selection to perspective context and create an edit part
			@Override
			public void doubleClick(DoubleClickEvent event) {
				StructuredSelection selection = (StructuredSelection) viewer.getSelection();
				if (selection != null && !selection.isEmpty()) {
					perspective.getContext().set("event.list.selection", selection.getFirstElement());

					MPart editPart = partService.createPart("at.example.calendar.partdescriptor.event.edit");
					MPartStack partStack = (MPartStack) modelService.find("at.example.calendar.partstack.right",
							perspective);
					partStack.getChildren().add(editPart);

					partService.showPart(editPart, PartState.ACTIVATE);
				}
			}
		});
	}

	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Resource events) {
		if (viewer != null && !viewer.getTable().isDisposed()) {
			viewer.setInput(events);
		}
	}

	@Inject
	@Optional
	void updateEvent(@UIEventTopic(IGoogleCalendarService.EVENTSUPDATE) List<Event> events) {
		viewer.setInput(EventsLoadHandler.getUIEventsResource(events));
	}
}