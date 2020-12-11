package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.InputMismatchException;

public class PopUpController_Requirement_Add extends Controller {
	public TextField requirementNameTextField;
	public TextField priorityTextField;
	public TextField timeEstimateField;

	public TextArea requirementDescriptionTextArea;

	public Button addRequirementButton;
	@FXML
	private Label validationLabel;

	@Override
	public void init( ) {
		// Doesn't need anything initialized
	}

	public void addRequirement( ) {

		try {
			for ( Requirement req : ColourItGui.getModel( ).getSelectedProject( ).getRequirementList( ).getRequirements( ) ) {
				if ( req.getRequirementName( ).equalsIgnoreCase(requirementNameTextField.getText( )) )
					throw new InputMismatchException("Duplicate Name");
			}
			String requirementNameTextFieldText = requirementNameTextField.getText( );
			String timeEstimateText = timeEstimateField.getText( );
			String priorityText;
			int timeEstimate = Integer.parseInt(timeEstimateText);
			if ( ! ( priorityTextField.getText( ).isBlank( ) ) )
				priorityText = priorityTextField.getText( );
			else
				priorityText = "0";
			int priority = Integer.parseInt(priorityText);
			Project selectedProject = ColourItGui.getModel( ).getSelectedProject( );

			// getting RequirementList from selected project and adding a new requirement.
			selectedProject.getRequirementList( )
					.addRequirement(new Requirement(requirementNameTextFieldText, timeEstimate, priority));

			clearInputFields( );
			getParentController( ).init( );
		} catch ( InputMismatchException inputMismatchException ) {
			validationLabel.setText("Invalid information");
		}
	}

	private void clearInputFields( ) {
		requirementNameTextField.clear( );
		priorityTextField.clear( );
		timeEstimateField.clear( );
		requirementDescriptionTextArea.clear( );
		validationLabel.setText("");
	}

	@Override
	public void goBack( ) throws IOException {
		getParentController( ).init( );
	}

}
