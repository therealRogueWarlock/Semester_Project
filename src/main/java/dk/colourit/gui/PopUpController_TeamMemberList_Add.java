package dk.colourit.gui;

import dk.colourit.model.MyDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.DateTimeException;
import java.util.InputMismatchException;

public class PopUpController_TeamMemberList_Add extends Controller {
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField idNumberTextField;

	@FXML
	private DatePicker birthdateDatePicker;
	@FXML
	private Label validationLabel;
	@FXML
	private Button closeButton;

	@Override
	public void init( ) {

        /*Editable false, to make sure user can't make invalid input. Like strings
		and invalid MyDate data.*/
		birthdateDatePicker.setEditable(false);
	}

	@FXML
	private void addTeamMember( ) {
		try {

			String teamMemberName = nameTextField.getText();

			int employeeIdNumber = Integer.parseInt(idNumberTextField.getText());

			if (ColourItGui.getModel().getTeamMemberList()
					.getTeamMember("id", Integer.toString(employeeIdNumber)) != null)
				throw new InputMismatchException("Employee with same id already exists");

			if (MyDate.now().isBefore(new MyDate(birthdateDatePicker.getValue())))
				throw new DateTimeException("Birthdate cannot be earlier than current date");

			MyDate birthday = new MyDate(birthdateDatePicker.getValue());

			ColourItGui.getModel().addEmployee(teamMemberName, employeeIdNumber, birthday);

			getParentController().init();
		} catch (DateTimeException | InputMismatchException exception) {
			validationLabel.setText(exception.getMessage());
		}
	}

	@Override
	public void goBack( ) {
		getParentController().init();
		((Stage) closeButton.getScene().getWindow()).close();
	}
}
