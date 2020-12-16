package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class Controller_ProjectList extends Controller {

    public Label roleSelectedLabel;
	@FXML private Button createButton;

	@FXML private TableView<Project> projectTableView;
	@FXML private TableColumn<Project, String> projectName;
	@FXML private TableColumn<Project, MyDate> startDate;
	@FXML private TableColumn<Project, MyDate> deadLine;
	@FXML private TableColumn<Project, String> projectStatus;

	@FXML private TableView<TeamMember> employeeTableView;
	@FXML private TableColumn<TeamMember, String> employeeNameColumn;
	@FXML private TableColumn<TeamMember, Integer> idNumberColumn;
	@FXML private TableColumn<TeamMember, MyDate> birthdayColumn;

	public Controller_ProjectList( ) {
	}

	@Override
	public void init( ) {
		populateProjectTable();
		populateEmployeeTable();

		buttonLogic( );

		roleSelectedLabel.setText(ColourItGui.getModel().getUseRoleString());
	}



	// general button logic
	private void buttonLogic( ) {
		// if the role is not admin check what buttons should be removed. else skip.
		if (ColourItGui.getModel().getUserRole() != 4) {
			// If the role is not project creator hide create button
			if (ColourItGui.getModel().getUserRole() != 3)
				createButton.setVisible(false);
		}
	}

	// functions for populating data one scene
	private void populateProjectTable(){

		ObservableList<Project> observableProjects = FXCollections.observableArrayList( );
		observableProjects.addAll(ColourItGui.getModel( ).getProjectList( ).getProjects( ));

		projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
		startDate.setCellValueFactory(new PropertyValueFactory<>("projectStartDate"));
		deadLine.setCellValueFactory(new PropertyValueFactory<>("projectDeadline"));
		projectStatus.setCellValueFactory(new PropertyValueFactory<>("projectStatus"));

		projectTableView.setItems(observableProjects);
	}
	private void populateEmployeeTable(){

		ObservableList<TeamMember> observableTeamMembers = FXCollections.observableArrayList( );

		observableTeamMembers.addAll(ColourItGui.getModel( ).getTeamMemberList( ).getTeamMembers( ));

		employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("memberName"));
		idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

		employeeTableView.setItems(observableTeamMembers);

		// disable selection functionality from employee tabel
		employeeTableView.setSelectionModel(null);

	}

	// functions for button/table functionality
	public void exportToWebsite( ) {
		ColourItGui.getModel().saveToXml();
	}

	@FXML private void itemSelected( ) {  //SANDER DON'T FUCKING REMOVE THIS PLEASE

		try {
			Project selectedProject = projectTableView.getSelectionModel( ).getSelectedItem( );
			ColourItGui.getModel().setSelectedProject(selectedProject);
			ColourItGui.setRoot("requirementList");
		} catch ( Exception e ) {
			//System.out.println("No project selected");
		}
	}

	@FXML private void addEmployee( ) throws IOException {
		createPopUp("popUp_TeamMemberList_Add");
	}

	@FXML private void createProjectButton( ) throws IOException {
		createPopUp("popUp_Project_Create");
	}


	@Override
	public void goBack() throws IOException {
		ColourItGui.setRoot("loginScreen");
	}

	public void loginScreen( ) throws IOException {
		goBack();
	}
}