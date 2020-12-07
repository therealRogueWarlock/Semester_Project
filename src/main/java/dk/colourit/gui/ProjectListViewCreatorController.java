package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProjectListViewCreatorController extends Controller{


    public TableView<Project> projectTableView;
    public TableColumn<Project, String> projectName;
    public TableColumn<Project, MyDate> startDate;
    public TableColumn<Project, MyDate> deadLine;




    public TableColumn<Project, String> projectStatus;
    // might be deleted
    public TableColumn projectEdit;

    @Override
    public void init() {

        ObservableList<Project> observableProjectList = FXCollections.observableArrayList();

        observableProjectList.addAll(getModel().getProjectList().getProjects());

        projectName.setCellValueFactory(new PropertyValueFactory<>("name"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        deadLine.setCellValueFactory(new PropertyValueFactory<>("deadLine"));


        projectTableView.setItems(observableProjectList);

    }
}
