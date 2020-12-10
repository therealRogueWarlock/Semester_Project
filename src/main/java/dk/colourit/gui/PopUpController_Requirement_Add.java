package dk.colourit.gui;

import dk.colourit.model.Project;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PopUpController_Requirement_Add extends Controller {
	public TextField requirementNameTextField;
	public TextField priorityTextField;
	public TextField timeEstimateField;

	public TextArea requirementDescriptionTextArea;

	public Button addRequirementButton;

	@Override
	public void init() {
		// Doesn't need anything initialized
	}

	public void addRequirement() {
		String requirementNameTextFieldText = requirementNameTextField.getText();

		String timeEstimateText = timeEstimateField.getText();
		int timeEstimate = Integer.parseInt(timeEstimateText);

		String priorityText = priorityTextField.getText();
		int priority = Integer.parseInt(priorityText);

		Project selectedProject = ColourItGui.getSelectedProject();

		ColourItGui.getModel().addRequirement(selectedProject, requirementNameTextFieldText, timeEstimate, priority);
		clearInputFields();

		getParentController().init();
	}

	private void clearInputFields() {
		requirementNameTextField.clear();
		priorityTextField.clear();
		timeEstimateField.clear();
		requirementDescriptionTextArea.clear();
	}

	@Override
	public void goBack() throws IOException {

	}

}
