package dk.colourit.gui;


import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
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

	public TableView employeeTableView;
	public TableColumn employeeNameColumn;
	public TableColumn idNumberColumn;
	public TableColumn birthdayColumn;

	@Override public void init()
	{

		/*
		int user = model.getUserRole();

		if (!(user == 3))
		{
			createButton.setDisable(true);
			createButton.setVisible(false);
		}*/

		ObservableList<Project> observableProjectList = FXCollections.observableArrayList();

		observableProjectList.addAll(ColourItGui.getModel().getProjectList().getProjects());

		projectName.setCellValueFactory(new PropertyValueFactory<>("name"));
		startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		deadLine.setCellValueFactory(new PropertyValueFactory<>("deadLine"));

		projectTableView.setItems(observableProjectList);

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