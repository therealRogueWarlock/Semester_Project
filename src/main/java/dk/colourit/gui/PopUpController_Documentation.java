package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class PopUpController_Documentation extends Controller {

	@FXML
	private Button logSpentTime;
	@FXML
	private Button confirm;
	@FXML
	private TextField addTimeSpent;
	@FXML
	private ComboBox<TeamMember> selectMember;
	@FXML
	private DatePicker selectDate;
	@FXML
	private CheckBox taskFinished;
	@FXML
	private TableView<Documentation> documentationTableView;
	@FXML
	private TableColumn<Documentation, String> memberNameColumn;
	@FXML
	private TableColumn<Documentation, Integer> timeSpentColumn;
	@FXML
	private TableColumn<Documentation, MyDate> daySelectedColumn;
	@FXML
	private Label validationLabel;

	public void init( ) {
		populateComboBox();
		populateTableView();

		taskFinished.setSelected(ColourItGui.getModel().getSelectedTask().isFinito());
		//Editable false, to make sure user can't make invalid input. Like strings and invalid MyDate data.
		selectDate.setEditable(false);
	}

	// functions for populating data on popup.
	private void populateComboBox( ) {
		selectMember.getItems().clear();
		ArrayList<TeamMember> teamMembers = ColourItGui.getModel().getSelectedProject().getTeamMemberList().getTeamMembers();
		selectMember.getItems().addAll(teamMembers);
	}

	private void populateTableView( ) {
		ArrayList<Documentation> documentations = ColourItGui.getModel().getSelectedTask().getDocumentations();
		ObservableList<Documentation> observableDocumentations = FXCollections.observableArrayList();
		observableDocumentations.addAll(documentations);

		memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
		timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpentDocumentation"));
		daySelectedColumn.setCellValueFactory(new PropertyValueFactory<>("documentationDate"));

		documentationTableView.setItems(observableDocumentations);
	}

	// functions for button functionality
	@FXML
	private void confirm( ) {
		ColourItGui.getModel().getSelectedTask().setFinito(taskFinished.isSelected());
		getParentController().getParentController().init();
		goBack();
	}

	@FXML
	private void toggleDisabledLogSpentTimeButton( ) {
		logSpentTime.setDisable(! (logSpentTime.isDisable()));
	}

	@FXML
	private void addDocumentation( ) {
		try {

			// get selected team member from choice box
			TeamMember member = selectMember.getSelectionModel().getSelectedItem();

			// check if a member was selected, if not throw Input Mismatch
			if (member == null) throw new InputMismatchException("No team member selected");

			// if the string cant be parsed to in, it will throw NumberFormatException
			int timeSpent = Integer.parseInt(addTimeSpent.getText());

			// check if current date is before selected date
			if (MyDate.now().isBefore(new MyDate(selectDate.getValue())))
				throw new DateTimeException("Date can't be later than current day");

			// creating a new MyDate object from selected date.
			MyDate date = new MyDate(selectDate.getValue());

			// getting Documentation list from selected task trough mediator.
			ColourItGui.getModel().getSelectedTask()
					.getDocumentations().add(new Documentation(member, timeSpent, date));

			// call init to update scene
			init();

		// catching different exceptions and giving user info.
		} catch (DateTimeException dateTimeException) {
			validationLabel.setText("Invalid date: \n" + dateTimeException.getMessage());

		}catch (NumberFormatException numberFormatException){
			validationLabel.setText("Invalid hour input");

		} catch (InputMismatchException inputMismatchException){
			validationLabel.setText(inputMismatchException.getMessage());
		}

	}

	@FXML
	private void removeTeamMember( ) {
		ColourItGui.getModel().getSelectedTask().getDocumentations().remove(documentationTableView.getSelectionModel().getSelectedItem());
		init();
	}

	@Override
	public void goBack( ) {
		getParentController().init();
		((Stage) confirm.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
}
