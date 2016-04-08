
package at.example.calendar.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import at.example.calendar.ui.model.UIEvent;

public class EventListPart {
	private TableViewer viewer;

	@Inject
	public EventListPart() {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout());
		viewer = new TableViewer(parent);
		ComposedAdapterFactory factory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(factory));

		viewer.setContentProvider(new ArrayContentProvider());
	}

	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) List<UIEvent> events) {
		if (viewer != null && !viewer.getTable().isDisposed()) {
			viewer.setInput(events);
		}
	}
}