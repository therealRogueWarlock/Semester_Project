package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Project_Edit extends Controller {

    public TextArea projectDescription;
    @FXML
	private Button confirmationButton;
	@FXML
	private TextField nameField;
	@FXML
	private DatePicker startDate;
	@FXML
	private DatePicker deadLine;

	@FXML
	private void confirm( ) throws IOException {

		if (! nameField.getText().isBlank() && ! nameField.getText().isEmpty()) {

			Project selectedProject = ColourItGui.getModel().getSelectedProject();

			selectedProject.setProjectName(nameField.getText());

			if (! (startDate.getValue() == null))
				selectedProject.setProjectStartDate(new MyDate(startDate.getValue()));
			if (! (deadLine.getValue() == null)
					&& selectedProject.getProjectStartDate().isBefore(new MyDate(deadLine.getValue())))
				selectedProject.setProjectDeadline(new MyDate(deadLine.getValue()));

			selectedProject.setProjectDescription(projectDescription.getText());
			getParentController().init();
			goBack();
		}
	}

	@Override
	public void init( ) {
		// setting data from selected project.
		Project selectedProject = ColourItGui.getModel().getSelectedProject();

		nameField.setText(selectedProject.getProjectName());

		projectDescription.setText(selectedProject.getProjectDescription());
	}

	@Override
	public void goBack( ) throws IOException {
		getParentController().init();
		((Stage) confirmationButton.getScene().getWindow()).close();
	}
}
