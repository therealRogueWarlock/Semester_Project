package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DocumentationPopUpController extends Controller {

	public Label taskName;
	public Label totalTimeSpent;
	public ComboBox<TeamMember> selectMember;
	public TextField addTimeSpent;
	public DatePicker selectDate;
	public Button logSpentTime;
	public CheckBox taskFinished;

	public TableView<Documentation> documentationTableView;
	public TableColumn<Documentation, String> memberNameColumn;
	public TableColumn<Documentation, Integer> timeSpentColumn;
	public TableColumn<Documentation, MyDate> daySelectedColumn;

	public Button confirm;

	public void init() {
		populateComboBox();
		populateTableView();
	}


	private void populateComboBox() {
		selectMember.getItems().clear();
		ArrayList<TeamMember> teamMembers = ColourItGui.getSelectedProject().getTeamMemberList().getTeamMembers();
		System.out.println(teamMembers);
		selectMember.getItems().addAll(teamMembers);
	}

	private void populateTableView() {
		ArrayList<Documentation> documentations = ColourItGui.getSelectedTask().getDocumentations();

		ObservableList<Documentation> observableDocumentations = FXCollections.observableArrayList();

		observableDocumentations.addAll(documentations);

		memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
		timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpent"));
		daySelectedColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

		documentationTableView.setItems(observableDocumentations);
	}

	@Override
	public void goBack() {
		getParentController().init();
		((Stage) confirm.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}

	public void confirm(){
		ColourItGui.getSelectedTask().setFinito(taskFinished.isSelected());
		getParentController().getParentController().init();
		goBack();
	}

	public void toggleDisabledLogSpentTimeButton(){
		logSpentTime.setDisable(!(logSpentTime.isDisable()));
	}

	@FXML
	private void addDocumentation() {
		TeamMember member = (TeamMember) selectMember.getSelectionModel().getSelectedItem();
		int timeSpent = Integer.parseInt(addTimeSpent.getText());
		MyDate date = new MyDate(selectDate.getValue());
		ColourItGui.getSelectedTask().getDocumentations().add(new Documentation(member, timeSpent, date));
		init();
		getParentController().init();
		getParentController().getParentController().init();
	}
}
