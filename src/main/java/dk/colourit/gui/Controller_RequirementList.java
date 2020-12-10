package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.TeamMember;
import dk.colourit.model.TeamMemberList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Controller_RequirementList extends Controller {

	public Label statusLabel;
	@FXML
	protected Button editButton;
	@FXML
	protected Button backButton;
	@FXML
	protected Button addRequirementButton;
	@FXML
	protected Button removeRequirementButton;
	@FXML
	protected Button deleteProjectButton;
	@FXML
	protected Button addTeamMemberButton;
	@FXML
	protected Button removeTeamMemberButton;
	@FXML
	private Label projectNameLabel;
	@FXML
	private TableView<Requirement> requirementTable;
	@FXML
	private TableColumn<Requirement, Integer> requirementPriorityColumn;
	@FXML
	private TableColumn<Requirement, String> requirementNameColumn;
	@FXML
	private TableColumn<Requirement, Integer> requirementStatusColumn;
	@FXML
	private TableView<TeamMember> teamMemberTable;
	@FXML
	private TableColumn<TeamMember, String> teamMemberNameColumn;
	@FXML
	private TableColumn<TeamMember, Integer> idNumberColumn;
	@FXML
	private TableColumn<TeamMember, Integer> roleColumn;
	@FXML
	private ChoiceBox<TeamMember> addTeamMemberChoiceBox;
	@FXML
	private ChoiceBox<TeamMember> removeTeamMemberChoiceBox;
	@FXML
	private ChoiceBox<Requirement> requirementChoiceBox;
	@FXML
	private ChoiceBox<String> selectRoleChoiceBox;
	@FXML
	private Label totalTimeSpentLabel;
	@FXML
	private Label deadlineLabel;

	public Controller_RequirementList( ) {

	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load( );
	}

	@Override
	public void init( ) {
		Project project = ColourItGui.getSelectedProject( );

		populateRequirementChoiceBox(project);

		populateAddTeamMemberChoiceBox(project);
		populateRemoveTeamMemberChoiceBox(project);
		populateRoleChoiceBox(project);

		populateRequirementTable(project);
		populateTeamMemberTable(project);

		totalTimeSpentLabel.setText(ColourItGui.getSelectedProject( ).getTotalTime( ) +
				" hours spent on " +
				ColourItGui.getSelectedProject( ).getName( ));
		teamMemberTable.setSelectionModel(null);
		deadlineLabel.setText("Deadline: " + ColourItGui.getSelectedProject( ).getDeadLine( ).toString( ));
		if ( ColourItGui.getSelectedProject( ).getRequirementList( ).getRequirements( ).size( ) <= ColourItGui.getSelectedProject( ).getRequirementList( ).getFinishedRequirements( ).size( ) )
			ColourItGui.getSelectedProject( ).setEndDate( );
	}

	private void populateRoleChoiceBox(Project project) {
		selectRoleChoiceBox.getItems( ).clear( );

		selectRoleChoiceBox.getItems( ).addAll("Team Member", "Project Creator", "Scrum Master", "Product Owner");

		// setting information text on scene
		projectNameLabel.setText(ColourItGui.getSelectedProject( ).getName( ));
		statusLabel.setText(project.getStatus( ));
	}

	private void populateRequirementChoiceBox(Project project) {
		requirementChoiceBox.getItems( ).clear( );

		ArrayList<Requirement> requirements = project.getRequirementList( ).getRequirements( );
		requirementChoiceBox.getItems( ).addAll(requirements);
	}

	private void populateRemoveTeamMemberChoiceBox(Project project) {
		removeTeamMemberChoiceBox.getItems( ).clear( );

		removeTeamMemberChoiceBox.getItems( ).addAll(project.getTeamMemberList( ).getTeamMembers( ));
	}

	private void populateAddTeamMemberChoiceBox(Project project) {
		addTeamMemberChoiceBox.getItems( ).clear( );

		TeamMemberList projectTeamMemberList = project.getTeamMemberList( );

		TeamMemberList employeesCopy = ColourItGui.getModel( )
				.getTeamMemberList( ).getCopy( );

		TeamMemberList employeesNotInProject = employeesCopy.subtractArgListFromThisList(projectTeamMemberList);

		addTeamMemberChoiceBox.getItems( ).addAll(employeesNotInProject.getTeamMembers( ));

	}

	private void populateRequirementTable(Project project) {

		ArrayList<Requirement> requirements = project.getRequirementList( ).getRequirements( );
		ObservableList<Requirement> observableRequirementList = FXCollections.observableArrayList( );

		observableRequirementList.addAll(requirements);

		requirementNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		requirementPriorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
		requirementStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

		requirementTable.setItems(observableRequirementList);
	}

	private void populateTeamMemberTable(Project project) {

		ArrayList<TeamMember> teamMembers = project.getTeamMemberList( ).getTeamMembers( );
		ObservableList<TeamMember> observableTeamMembers = FXCollections.observableArrayList( );

		observableTeamMembers.addAll(teamMembers);

		teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
		roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

		teamMemberTable.setItems(observableTeamMembers);
	}

	public void editButton( ) throws IOException {
		createPopUp("popUp_Project_Edit");
		// TODO: Implement Edit Scene and Functionality for a Project - use popUp_Project_Edit.fxml and PopUpController_Project_Edit.java
	}

	public void addRequirementButton( ) throws IOException {
		createPopUp("popUp_Requirement_Add");
	}

	public void removeRequirementButton( ) {

	}

	public void addTeamMemberButton( ) throws IOException {

		TeamMember selectedTeamMember = addTeamMemberChoiceBox.getSelectionModel( ).getSelectedItem( );

		String selectedRole = selectRoleChoiceBox.getSelectionModel( ).getSelectedItem( );

		if ( selectedTeamMember != null && selectedRole != null ) {

			Project selectedProject = ColourItGui.getSelectedProject( );

			ColourItGui.getModel( ).addMemberToProject(selectedProject, selectedTeamMember, selectedRole);

			//selectedTeamMember.setRole(selectedRole);
			//selectedProject.getTeamMemberList().addTeamMember(selectedTeamMember);
			init( );
		}

	}

	public void removeTeamMemberButton( ) {

		TeamMember selectedTeamMember = removeTeamMemberChoiceBox.getSelectionModel( ).getSelectedItem( );

		if ( selectedTeamMember != null ) {
			Project selectedProject = ColourItGui.getSelectedProject( );

			selectedProject.getTeamMemberList( ).removeTeamMember(selectedTeamMember);

			init( );
		}

	}

	public void deleteProjectButton( ) throws IOException {
		createPopUp("popUp_Project_DeleteConfirmation");
	}

	public void goBack( ) throws IOException {
		ColourItGui.setRoot("projectList");
	}

	public void itemSelected( ) throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
	{
		Requirement selectedRequirement = requirementTable.getSelectionModel( ).getSelectedItem( );
		ColourItGui.setSelectedRequirement(selectedRequirement);
		ColourItGui.setRoot("taskList");
	}
}


