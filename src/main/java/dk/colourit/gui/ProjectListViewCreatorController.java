package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;

public class ProjectListViewCreatorController extends Controller
{
	public TableView<Project> projectTableView;
	public TableColumn<Project, String> projectName;
	public TableColumn<Project, MyDate> startDate;
	public TableColumn<Project, MyDate> deadLine;

	public TableColumn<Project, String> projectStatus;
	// might be deleted
	public TableColumn projectEdit;
	public Button backButton;
	public Button createButton;
	public Button addButton; // What is the purpose of this one?

	@Override public void init()
	{
		int user = model.getUserRole();
		System.out.print(model.getUserRole());

		if (!(user == 3))
		{
			createButton.setDisable(true);
			createButton.setVisible(false);
		}

		ObservableList<Project> observableProjectList = FXCollections.observableArrayList();

		observableProjectList.addAll(getModel().getProjectList().getProjects());

		projectName.setCellValueFactory(new PropertyValueFactory<>("name"));
		startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		deadLine.setCellValueFactory(new PropertyValueFactory<>("deadLine"));

		projectTableView.setItems(observableProjectList);

	}

	public void itemSelected() throws IOException //SANDER DONT FUCKING REMOVE THIS PLEASE
	{
		Project selectedProject = projectTableView.getSelectionModel().getSelectedItem();

		ColourItGui.setRoot("projectDetailsScene", selectedProject);

	}
}
