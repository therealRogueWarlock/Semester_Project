package dk.colourit.gui;


import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ProjectListViewController extends Controller
{

	public TableView<Project> projectTableView;
	public TableColumn<Project, String> projectName;
	public TableColumn<Project, MyDate> startDate;
	public TableColumn<Project, MyDate> deadLine;
	public TableColumn<Project, String> projectStatus;

	// feeling cute might delete later
	public Button backButton;
	public Button createButton;
	public Button addEmployeeButton;
	public Button exportButton;

	public TableView<TeamMember> employeeTableView;
	public TableColumn<TeamMember, String> employeeNameColumn;
	public TableColumn<TeamMember, Integer> idNumberColumn;
	public TableColumn<TeamMember, MyDate> birthdayColumn;

	public ProjectListViewController(){
	}


	@Override public void init()
	{

		/*
		int user = model.getUserRole();

		if (!(user == 3))
		{
			createButton.setDisable(true);
			createButton.setVisible(false);
		}*/

		ObservableList<TeamMember> observableTeamMembers = FXCollections.observableArrayList();

		observableTeamMembers.addAll(ColourItGui.getModel().getTeamMemberList().getTeamMembers());

		employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		employeeTableView.setItems(observableTeamMembers);


		ObservableList<Project> observableProjects = FXCollections.observableArrayList();
		observableProjects.addAll(ColourItGui.getModel().getProjectList().getProjects());

		projectName.setCellValueFactory(new PropertyValueFactory<>("name"));
		startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		deadLine.setCellValueFactory(new PropertyValueFactory<>("deadLine"));
		projectStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

		projectTableView.setItems(observableProjects);

		employeeTableView.setSelectionModel(null);
	}

	public void exportToWebsite()
	{
		//TODO: Skal eksportere til vores hjemmeside via XML.
	}

	@Override public void goBack()
	{

	}

	public void itemSelected()  //SANDER DON'T FUCKING REMOVE THIS PLEASE
	{
		try {
			Project selectedProject = projectTableView.getSelectionModel().getSelectedItem();
			ColourItGui.setSelectedProject(selectedProject);
			ColourItGui.setRoot("requirementListScene");
		}catch (Exception e){
			System.out.println("No project selected");
		}
	}

	public void addEmployee() throws IOException{

		createPopUp("addTeamMemberScene");

	}

	public void createProjectButton() throws IOException
	{
		createPopUp("createProjectPopUp");

	}
}