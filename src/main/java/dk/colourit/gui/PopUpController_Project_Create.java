package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import dk.colourit.model.TeamMember;
import dk.colourit.model.TeamMemberList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.MissingResourceException;

public class PopUpController_Project_Create extends Controller {
	public TableView<TeamMember> teamMemberTableView;
	public TableColumn<TeamMember, String> nameColumn;
	public TableColumn<TeamMember, Integer> idColumn;

	@FXML
	private TextField projectName;
	@FXML
	private DatePicker startDate;
	@FXML
	private DatePicker deadLine;
	@FXML
	private ComboBox<TeamMember> selectMember;

	@FXML
	private Button confirm;

	@FXML
	public Label statusLabel;

	private ArrayList<TeamMember> teamMembersForProject;

	public PopUpController_Project_Create() {
		teamMembersForProject = new ArrayList<>();
	}


	@Override
	public void init() {
		populateTeamMemberChoiceBox();
		populateTeamMemberTableView();
	}


	private void populateTeamMemberTableView() {
		// setting cell factory to new Property Factory. will check for if obj has getter for field and use return value
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("memberMame"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));

		// Converting a TeamMember ArrayList to an ObservableArrayList
		ObservableList<TeamMember> observableTeamMembersForProject = FXCollections.observableArrayList();
		observableTeamMembersForProject.addAll(teamMembersForProject);

		// Adding the ObservableArrayList to the TableView
		teamMemberTableView.setItems(observableTeamMembersForProject);
	}

	private void populateTeamMemberChoiceBox() {
		// Safety clear on anything which might possibly have gotten into the list
		selectMember.getItems().clear();
		// Adds the ArrayList of TeamMembers to the ChoiceBox
		selectMember.getItems().addAll(ColourItGui.getModel().getTeamMemberList().getCopy().getTeamMembers());
	}

	public void confirmCreateProject() {
		String projectName = this.projectName.getText();
		LocalDate startDate = this.startDate.getValue();
		LocalDate deadLine = this.deadLine.getValue();
		try {

			// if there is already a project with given name, trow input error.
			if (ColourItGui.getModel().getProjectList().getProjectByName(projectName) != null)
				throw new InputMismatchException();

			Project constructProject = new Project(projectName, new MyDate(startDate), new MyDate(deadLine));
			constructProject.setTeamMemberList(new TeamMemberList(teamMembersForProject));
			ColourItGui.getModel().addProject(constructProject);

			statusLabel.setText("Project Created");
			statusLabel.setTextFill(Color.web("#22DD33"));
			getParentController().init();
		} catch (DateTimeException dateTimeException) {
			statusLabel.setText("Failed | Invalid Date");
			statusLabel.setTextFill(Color.web("#FF3344"));
		} catch (MissingFormatArgumentException missingFormatArgumentException) {
			statusLabel.setText("Failed | Name Field Empty");
			statusLabel.setTextFill(Color.web("#FF3344"));
		} catch (NullPointerException nullPointerException) {
			statusLabel.setText("Failed | Missing Date(s)");
			statusLabel.setTextFill(Color.web("#FF3344"));
		}catch (InputMismatchException e){
			statusLabel.setText("Project name already in use");
			statusLabel.setTextFill(Color.web("#FF3344"));
		}
	}

	public void addTeamMember() {
		TeamMember selectedTeamMember = selectMember.getSelectionModel().getSelectedItem();

		if (selectedTeamMember != null) {
			if (!teamMembersForProject.contains(selectedTeamMember)) {
				teamMembersForProject.add(selectedTeamMember);
				populateTeamMemberTableView();
			}
		}
	}

	@Override
	public void goBack() {
		getParentController( ).init();
		((Stage) confirm.getScene( ).getWindow( )).close(); // TODO: Fix this
	}
}
