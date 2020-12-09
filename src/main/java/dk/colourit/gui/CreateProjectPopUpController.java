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
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateProjectPopUpController extends Controller
{

	public TableView<TeamMember> teamMemberTableView;
	public TableColumn<TeamMember, String> nameColumn;
	public TableColumn<TeamMember, Integer> idColumn;



	@FXML private TextField projectName;
	@FXML private DatePicker startDate;
	@FXML private DatePicker deadLine;
	@FXML private ComboBox<TeamMember> selectMember;

	private ArrayList<TeamMember> teamMembersForProject;


	@FXML private Button confirm;


	@FXML public Label statusLabel;


	public CreateProjectPopUpController(){
		teamMembersForProject = new ArrayList<>();
	}


	@Override public void init()
	{
		populateTeamMemberChoiceBox();
		populateTeamMemberTableView();
	}


	private void populateTeamMemberTableView(){
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));

		// converting team members array observable
		ObservableList<TeamMember> observableTeamMembersForProject = FXCollections.observableArrayList();
		observableTeamMembersForProject.addAll(teamMembersForProject);

		// adding observable list to teamMember table view
		teamMemberTableView.setItems(observableTeamMembersForProject);
	}



	private void populateTeamMemberChoiceBox(){
		selectMember.getItems().clear();
		selectMember.getItems().addAll(ColourItGui.getModel().getTeamMemberList().getCopy().getTeamMembers());
	}


	@Override public void goBack(){

	}

	public void confirmCreateProject()
	{
		String projectName = this.projectName.getText();
		LocalDate startDate = this.startDate.getValue();
		LocalDate deadLine = this.deadLine.getValue();
		try
		{

			Project constructProject = new Project(projectName, new MyDate(startDate), new MyDate(deadLine));

			constructProject.setTeamMemberList(new TeamMemberList(teamMembersForProject));
			ColourItGui.getModel().getProjectList().addProject(constructProject);

			statusLabel.setText("Project Created");
			statusLabel.setTextFill(Color.web("#22DD33"));
			getParentController().init();
		}
		catch (RuntimeException e)
		{
			statusLabel.setText("Project Creation Failed");
			statusLabel.setTextFill(Color.web("#FF3344"));
		}

	}

	public void closePopUp()
	{
		// Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
		((Stage) confirm.getScene().getWindow()).close();
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
}
