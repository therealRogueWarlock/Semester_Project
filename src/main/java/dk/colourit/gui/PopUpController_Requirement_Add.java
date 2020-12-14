package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;

public class PopUpController_Requirement_Add extends Controller {
	@FXML
	private TextField requirementNameTextField;
	@FXML
	private TextField priorityTextField;
	@FXML
	private TextField timeEstimateField;

	@FXML
	private TextArea requirementDescriptionTextArea;

	@FXML
	private Button closeButton;

	@FXML
	private Label validationLabel;

	@Override
	public void init( ) {
		// Doesn't need anything initialized
	}

	@FXML
	private void addRequirement( ) {
		try {
			if (ColourItGui.getModel().getSelectedProject().getRequirementList()
					.getRequirementByName(requirementNameTextField.getText()) != null) {
				throw new InputMismatchException("Duplicate Name");
			}

			String requirementNameTextFieldText = requirementNameTextField.getText();
			String timeEstimateText = timeEstimateField.getText();
			String priorityText;
			int timeEstimate = Integer.parseInt(timeEstimateText);
			if (! (priorityTextField.getText().isBlank()))
				priorityText = priorityTextField.getText();
			else
				priorityText = "0";
			int priority = Integer.parseInt(priorityText);
			Project selectedProject = ColourItGui.getModel().getSelectedProject();

			// creating a new requirement from input data
			Requirement newRequirement = new Requirement(requirementNameTextFieldText, timeEstimate, priority);

			//Setting requirement description
			newRequirement.setRequirementDescription(requirementDescriptionTextArea.getText());

			// getting RequirementList from selected project and adding a new requirement.
			selectedProject.getRequirementList()
					.addRequirement(new Requirement(requirementNameTextFieldText, timeEstimate, priority));

			getParentController().init();
			clearInputFields();
		} catch (InputMismatchException inputMismatchException) {
			validationLabel.setText("Invalid information");
		}
	}

	@FXML
	private void clearInputFields( ) {
		requirementNameTextField.clear();
		priorityTextField.clear();
		timeEstimateField.clear();
		requirementDescriptionTextArea.clear();
		validationLabel.setText("");
	}

	@Override
	public void goBack( ) throws IOException {
		getParentController().init();
		((Stage) closeButton.getScene().getWindow()).close();
	}
}
