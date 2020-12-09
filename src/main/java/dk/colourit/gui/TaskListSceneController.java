package dk.colourit.gui;

import dk.colourit.model.*;
import javafx.application.Platform;
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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        taskList = requirement.getTaskList();

        populateHighPriorityTable();
        populateLowPriorityTable();

        // setting information text on scene
        projectNameText.setText(ColourItGui.getSelectedProject().getName());
        statusText.setText(requirement.getStatus());
        requirementNameText.setText(requirement.getName());

    }


    private void populateHighPriorityTable(){

        // getting high priority task from task list
        ArrayList<Task> highPriorityTasks = taskList.getHighPriority();
        ObservableList<Task> observableHighPriorityTasks = FXCollections.observableArrayList();

        // creating an observable list from the high Priority tasks list
        observableHighPriorityTasks.addAll(highPriorityTasks);

        taskNameHighColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeHighColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentHighColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));

        // adding the observable list to the high priority table
        highPriorityTableView.setItems(observableHighPriorityTasks);

    }

    private void populateLowPriorityTable(){
        // getting the low priority task from task list
        ArrayList<Task> lowPriorityTasks = taskList.getLowPriority();
        ObservableList<Task> observableLowPriorityTasks = FXCollections.observableArrayList();

        observableLowPriorityTasks.addAll(lowPriorityTasks);

        taskNameLowColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        estimatedTimeLowColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
        totalTimeSpentLowColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));

        lowPriorityTableView.setItems(observableLowPriorityTasks);
    }


    @Override public void goBack() throws IOException
    {
        ColourItGui.setRoot("requirementListScene");
    }

    @FXML
    private void popUpAddTask() throws IOException{

        scene = new Scene(loadFXML("taskListAddPopUp"));
        stage = new Stage();

        stage.setScene(scene);

        // when popup is open primary stage cant be accessed.
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    @FXML
    private void popUpTaskDetails() throws IOException{
        // Disabling the main container for the primary stage
        //mainContainer.setDisable(true);

        scene = new Scene(loadFXML("taskDetailsPopUp"));
        stage = new Stage();
        stage.setScene(scene);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();



        // An other was to disable the primary stage with out use of initModality

        // Disabling the main container for the primary stage
        //mainContainer.setDisable(true)

        // adding an on close request to the pop up, that enable the main container.
        //stage.setOnCloseRequest(windowEvent -> mainContainer.setDisable(false));

        // show pop up
        //stage.show();
    }

    public void itemSelected(Event event) throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();

        controller.setModel(ColourItGui.getModel());
        controller.init();

        return root;
    }

}
