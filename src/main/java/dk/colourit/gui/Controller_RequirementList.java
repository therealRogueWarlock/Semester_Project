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

	@FXML
	protected Label statusLabel;
	@FXML
    protected Label roleSelectedLabel;
    @FXML
	protected Button editProjectButton;
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
	private TableColumn<Requirement, Integer> requirementTimeEstimateColumn;
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


	@Override
	public void init( ) {

		Project project = ColourItGui.getModel().getSelectedProject( );

		populateProjectInfo(project);

		populateRequirementChoiceBox(project);
		populateAddTeamMemberChoiceBox(project);
		populateRemoveTeamMemberChoiceBox(project);
		populateRoleChoiceBox(project);

		populateRequirementTable(project);
		populateTeamMemberTable(project);

		activateRoleButtonLogic();
	}


	// functions for Button disable/enable logic

	private void generalButtonLogic(){

	}

	private void activateRoleButtonLogic(){

		// if the role is not admin check what buttons should be removed. else skip.
		if (ColourItGui.getModel().getUserRole() != 4) {
			// if the role is not 1 ( product owner) make buttons associated with the role invisible
			if (ColourItGui.getModel().getUserRole() != 1) {
				removeProductOwnerButtons();
			}
			if (ColourItGui.getModel().getUserRole() != 3) {
				removeProjectCreatorButtons();
			}
		}

	}

	private void removeProjectCreatorButtons(){
		deleteProjectButton.setVisible(false);
		addTeamMemberChoiceBox.setVisible(false);
		selectRoleChoiceBox.setVisible(false);
		addTeamMemberButton.setVisible(false);
		removeTeamMemberChoiceBox.setVisible(false);
		removeTeamMemberButton.setVisible(false);
		editProjectButton.setVisible(false);
	}

	private void removeProductOwnerButtons(){
		addRequirementButton.setVisible(false);
		removeRequirementButton.setVisible(false);
		requirementChoiceBox.setVisible(false);
	}


	// functions for populating data on scene
	private void populateProjectInfo(Project project){

		totalTimeSpentLabel.setText(project.getTotalTime( ) + " hours spent on " + project.getName( ));

		teamMemberTable.setSelectionModel(null);

		deadlineLabel.setText("Deadline: " + project.getDeadLine( ).toString( ));

		if ( project.getRequirementList( ).getRequirements( ).size( ) <= project.getRequirementList( )
				.getFinishedRequirements( ).size( ) )
			project.setEndDate( );
		statusLabel.setText(project.getStatus());

		roleSelectedLabel.setText(ColourItGui.getModel().getUseRoleString());
	}

	private void populateRoleChoiceBox(Project project) {
		selectRoleChoiceBox.getItems( ).clear( );

		selectRoleChoiceBox.getItems( ).addAll("Team Member", "Project Creator", "Scrum Master", "Product Owner");

		// setting information text on scene
		projectNameLabel.setText(ColourItGui.getModel().getSelectedProject( ).getName( ));
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
		requirementTimeEstimateColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimate"));

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



	// functions for button functionality
	public void editButton( ) throws IOException {
		createPopUp("popUp_Project_Edit");
		// TODO: Implement Edit Scene and Functionality for a Project - use popUp_Project_Edit.fxml and PopUpController_Project_Edit.java
	}

	public void addRequirementButton( ) throws IOException {
		createPopUp("popUp_Requirement_Add");
	}

	public void removeRequirementButton( ) {
		ColourItGui.getModel().getSelectedProject().getRequirementList().removeRequirement(requirementChoiceBox.getSelectionModel().getSelectedItem().getName());
		init();
	}

	public void addTeamMemberButton( ) {

		TeamMember selectedTeamMember = addTeamMemberChoiceBox.getSelectionModel( ).getSelectedItem( );

		String selectedRole = selectRoleChoiceBox.getSelectionModel( ).getSelectedItem( );

		// if the the choice boxes er selected
		if ( selectedTeamMember != null && selectedRole != null ) {
			// getting selected project
			Project selectedProject = ColourItGui.getModel().getSelectedProject( );

			// adding the selected role to the selected team member
			selectedTeamMember.setRole(selectedRole);
			// adding the team member to the projects team member list
			selectedProject.getTeamMemberList().addTeamMember(selectedTeamMember);

			init();
		}
	}

	public void removeTeamMemberButton( ) {

		TeamMember selectedTeamMember = removeTeamMemberChoiceBox.getSelectionModel( ).getSelectedItem( );

		if ( selectedTeamMember != null ) {
			Project selectedProject = ColourItGui.getModel().getSelectedProject( );

			selectedProject.getTeamMemberList( ).removeTeamMember(selectedTeamMember);

			init( );
		}

	}

	public void deleteProjectButton( ) throws IOException {
		createPopUp("popUp_Project_DeleteConfirmation");
	}

	public void goBack( ) throws IOException {
		init();
		ColourItGui.setRoot("projectList");
	}

	public void itemSelected( ) throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
	{
		Requirement selectedRequirement = requirementTable.getSelectionModel( ).getSelectedItem( );

		if(selectedRequirement!=null)
		{
			ColourItGui.getModel().setSelectedRequirement(selectedRequirement);
			ColourItGui.setRoot("taskList");
		}
	}
}


