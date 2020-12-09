package dk.colourit.gui;

import dk.colourit.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;

public class TaskListSceneController extends Controller {

    public GridPane mainContainer;



    private TaskList taskList;

    public TableView<Task> highPriorityTableView;
    public TableColumn<Task, String> taskNameHighColumn;
    public TableColumn<Task, Integer> estimatedTimeHighColumn;
    public TableColumn<Task, Integer> totalTimeSpentHighColumn;
    public TableColumn<Task, String> responsibleHighColumn;
    public TableColumn<Task, String> taskStatusHighColumn;

    public TableView<Task> lowPriorityTableView;
    public TableColumn<Task, String> taskNameLowColumn;
    public TableColumn<Task, Integer> estimatedTimeLowColumn;
    public TableColumn<Task, Integer> totalTimeSpentLowColumn;
    public TableColumn<Task, String> responsibleLowColumn;
    public TableColumn<Task, String> taskStatusLowColumn;

    public Text projectNameText;
    public Text statusText;
    public Text requirementNameText;
    public Button addTaskButton;
    public Button backButton;

    public void init(){
        Requirement requirement = ColourItGui.getSelectedRequirement();
        taskList = requirement.getTaskList();

        populateHighPriorityTable();
        populateLowPriorityTable();

        // setting information text on scene
        projectNameText.setText(ColourItGui.getSelectedProject().getName());
        statusText.setText(requirement.getStatus());
        requirementNameText.setText(requirement.getName());
    }


    private void populateHighPriorityTable(){
        highPriorityTableView.getItems().clear();
        // getting high priority task from task list
        ArrayList<Task> highPriorityTasks = taskList.getHighPriority();
        ObservableList<Task> observableHighPriorityTasks = FXCollections.observableArrayList();

        // creating an observable list from the high Priority tasks list
        observableHighPriorityTasks.addAll(highPriorityTasks);

        taskNameHighColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeHighColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentHighColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));
        responsibleHighColumn.setCellValueFactory(new PropertyValueFactory<>("responsible"));
        taskStatusHighColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // adding the observable list to the high priority table
        highPriorityTableView.setItems(observableHighPriorityTasks);

    }

    private void populateLowPriorityTable(){
        lowPriorityTableView.getItems().clear();
        // getting the low priority task from task list
        ArrayList<Task> lowPriorityTasks = taskList.getLowPriority();
        ObservableList<Task> observableLowPriorityTasks = FXCollections.observableArrayList();

        observableLowPriorityTasks.addAll(lowPriorityTasks);

        taskNameLowColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeLowColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentLowColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));
        responsibleLowColumn.setCellValueFactory(new PropertyValueFactory<>("responsible"));
        taskStatusLowColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        lowPriorityTableView.setItems(observableLowPriorityTasks);
    }


    @Override public void goBack() throws IOException
    {
        ColourItGui.setRoot("requirementListScene");
    }

    @FXML
    private void popUpAddTask() throws IOException{
        createPopUp("taskListAddPopUp");

    }

    @FXML
    private void popUpTaskDetails() throws IOException{

        createPopUp("taskDetailsPopUp");

    }

    public void itemSelected(Event event) throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
    {
        // getting what table is clicked by id


        String selectedTableId = ((Control) event.getSource()).getId();

        if (selectedTableId != null) {
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
    }

}
