package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TaskListSceneController extends Controller {


    public TableView<Task> highPriorityTableView;
    public TableColumn<Task, String> taskNameHighColumn;
    public TableColumn<Task, Integer> estimatedTimeHighColumn;
    public TableColumn<Task, Integer> totalTimeSpentHighColumn;
    public TableColumn<Task, String> responsibleHighColumn;

    public TableView<Task> lowPriorityTableView;
    public TableColumn<Task, String> taskNameLowColumn;
    public TableColumn<Task, Integer> estimatedTimeLowColumn;
    public TableColumn<Task, Integer> totalTimeSpentLowColumn;
    public TableColumn<Task, String> responsibleLowColumn;

    private Scene scene;
    private Stage stage;

    public Text projectNameText;
    public Text statusText;
    public Text requirementNameText;
    public Button addTaskButton;

    public void init(){
        Requirement requirement = ColourItGui.getSelectedRequirement();

        // getting high priority task from requirement tasklist
        ArrayList<Task> highPriorityTasks = requirement.getTaskList().getHighPriority();
        ObservableList<Task> observableHighPriorityTasks = FXCollections.observableArrayList();

        // creating an observable list from the hihg Priority tasks list
        observableHighPriorityTasks.addAll(highPriorityTasks);

        taskNameHighColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeHighColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentHighColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));

        // adding the observable list to the high priority table
        highPriorityTableView.setItems(observableHighPriorityTasks);

        // repeat for low priority table view
        ArrayList<Task> lowPriorityTasks = requirement.getTaskList().getLowPriority();

        ObservableList<Task> observableLowPriorityTasks = FXCollections.observableArrayList();

        observableLowPriorityTasks.addAll(lowPriorityTasks);

        taskNameLowColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeLowColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentLowColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));

        lowPriorityTableView.setItems(observableLowPriorityTasks);
    }

    @Override public void goBack() throws IOException
    {
        ColourItGui.setRoot("projectDetailsScene");
    }

    @FXML
    private void popUpAddTask() throws IOException{
        scene = new Scene(loadFXML("taskListAddPopUp"));
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void popUpTaskDetails() throws IOException{
        scene = new Scene(loadFXML("taskDetailsPopUp"));
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void itemSelected(Event event) throws IOException //SANDER DONT FUCKING REMOVE THIS PLEASE
    {
        // getting what table is clicked by id
        String selectedTableId = ((Control) event.getSource()).getId();

        if (selectedTableId.equals("highPriorityTableView")) {
            // getting the selected task from the table View
            Task selectedTask = highPriorityTableView.getSelectionModel().getSelectedItem();
            ColourItGui.setSelectedTask(selectedTask);
            popUpTaskDetails();
        } else if (selectedTableId.equals("lowPriorityTableView")) {
            Task selectedTask = lowPriorityTableView.getSelectionModel().getSelectedItem();
            ColourItGui.setSelectedTask(selectedTask);
            popUpTaskDetails();
        }

    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
