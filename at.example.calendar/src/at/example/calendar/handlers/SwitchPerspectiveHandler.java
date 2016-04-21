
package at.example.calendar.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class SwitchPerspectiveHandler {

	@Execute
	public void execute(@Named("at.example.calendar.commandparameter.perspective.id") final String perspectiveId,
			EModelService modelService, MTrimmedWindow window) {
		MPerspectiveStack perspectiveStack = (MPerspectiveStack) modelService
				.find("at.example.calendar.perspectivestack.0", window);
		if (perspectiveStack != null) {
			for (MPerspective perspective : perspectiveStack.getChildren()) {
				if (perspective.isToBeRendered() && perspective.isVisible()) {
					if (perspective.getElementId().equals(perspectiveId)) {
						perspectiveStack.setSelectedElement(perspective);
					}
				}
			}
		}
	}

}