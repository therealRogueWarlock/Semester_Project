package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.RequirementList;
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

			Project selectedProject = ColourItGui.getModel().getSelectedProject();

			RequirementList requirementList = selectedProject.getRequirementList();

			String newRequirementName = requirementNameTextField.getText();

			Requirement existingRequirement = requirementList.getRequirementByName(newRequirementName);

			if (existingRequirement != null) {
				throw new InputMismatchException("Duplicate Name");
			}


			String timeEstimateText = timeEstimateField.getText();

			String priorityText = priorityTextField.getText();

			if (priorityText.isBlank())
				priorityText = "0";

			int timeEstimate = Integer.parseInt(timeEstimateText);
			int priority = Integer.parseInt(priorityText);
			// creating a new requirement from input data
			Requirement newRequirement = new Requirement(newRequirementName, timeEstimate, priority);

			String requirementDescription = requirementDescriptionTextArea.getText();

			//Setting requirement description
			newRequirement.setRequirementDescription(requirementDescription);

			//adding the new requirement to the requirement list of the selected project.
			requirementList.addRequirement(newRequirement);

			getParentController().init();
			clearInputFields();

		} catch (InputMismatchException | NumberFormatException error) {
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
