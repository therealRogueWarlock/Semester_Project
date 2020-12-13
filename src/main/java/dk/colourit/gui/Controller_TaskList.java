package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.Task;
import dk.colourit.model.TaskList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Controller_TaskList extends Controller {
	@FXML private GridPane mainContainer;
	@FXML private TableView<Task> highPriorityTableView;
	@FXML private TableColumn<Task, String> taskNameHighColumn;
	@FXML private TableColumn<Task, Integer> estimatedTimeHighColumn;
	@FXML private TableColumn<Task, Integer> totalTimeSpentHighColumn;
	@FXML private TableColumn<Task, String> responsibleHighColumn;
	@FXML private TableColumn<Task, String> taskStatusHighColumn;

	@FXML private TableView<Task> lowPriorityTableView;
	@FXML private TableColumn<Task, String> taskNameLowColumn;
	@FXML private TableColumn<Task, Integer> estimatedTimeLowColumn;
	@FXML private TableColumn<Task, Integer> totalTimeSpentLowColumn;
	@FXML private TableColumn<Task, String> responsibleLowColumn;
	@FXML private TableColumn<Task, String> taskStatusLowColumn;

	@FXML private Text projectNameText;
	@FXML private Text statusText;
	@FXML private Text requirementNameText;
	@FXML private Button deleteRequirementButton;
	@FXML private Button addTaskButton;
	@FXML private Button rejectButton;
	@FXML private Button approveButton;
	@FXML private Button editRequirementButton;
	@FXML private Label roleSelectedLabel;

	@FXML private Text priorityText;
	@FXML private Text timeEstimateText;
	@FXML private TextArea requirementDescriptionText;

	// fields for selected objects
	private Requirement selectedRequirement;
	private TaskList taskList;

	public void init( ) {
		selectedRequirement = ColourItGui.getModel().getSelectedRequirement();
		taskList = selectedRequirement.getTaskList();

		populateHighPriorityTable();
		populateLowPriorityTable();
		populateInformationText();

		// logic for buttons
		generalButtonLogic();

		// checking logic for buttons for the different roles.
		activateRoleButtonLogic();
	}

	// functions for populating data / tables on scene
	private void populateHighPriorityTable( ) {
		highPriorityTableView.getItems().clear();
		// getting high priority task from task list
		ArrayList<Task> highPriorityTasks = taskList.getHighPriority();
		ObservableList<Task> observableHighPriorityTasks = FXCollections.observableArrayList();

		// creating an observable list from the high Priority tasks list
		observableHighPriorityTasks.addAll(highPriorityTasks);

		taskNameHighColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
		estimatedTimeHighColumn.setCellValueFactory(new PropertyValueFactory<>("taskTimeEstimate"));
		totalTimeSpentHighColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));
		responsibleHighColumn.setCellValueFactory(new PropertyValueFactory<>("taskResponsible"));
		taskStatusHighColumn.setCellValueFactory(new PropertyValueFactory<>("taskStatus"));

		// adding the observable list to the high priority table
		highPriorityTableView.setItems(observableHighPriorityTasks);
	}

	private void populateLowPriorityTable( ) {
		lowPriorityTableView.getItems().clear();
		// getting the low priority task from task list
		ArrayList<Task> lowPriorityTasks = taskList.getLowPriority();
		ObservableList<Task> observableLowPriorityTasks = FXCollections.observableArrayList();

		observableLowPriorityTasks.addAll(lowPriorityTasks);

		taskNameLowColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
		estimatedTimeLowColumn.setCellValueFactory(new PropertyValueFactory<>("taskTimeEstimate"));
		totalTimeSpentLowColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));
		responsibleLowColumn.setCellValueFactory(new PropertyValueFactory<>("taskResponsible"));
		taskStatusLowColumn.setCellValueFactory(new PropertyValueFactory<>("taskStatus"));
		lowPriorityTableView.setItems(observableLowPriorityTasks);
	}

	private void populateInformationText( ) {
		// setting information text on scene
		projectNameText.setText(ColourItGui.getModel().getSelectedProject().getProjectName());
		statusText.setText(selectedRequirement.getStatus());
		requirementNameText.setText(selectedRequirement.getRequirementName());

		roleSelectedLabel.setText(ColourItGui.getModel().getUseRoleString());

		priorityText.setText(Integer.toString(selectedRequirement.getPriority()));
		timeEstimateText.setText(Integer.toString(selectedRequirement.getRequirementTimeEstimate()));
		requirementDescriptionText.setText(selectedRequirement.getRequirementDescription());
	}

	// functions for button disable/enable logic
	private void generalButtonLogic( ) {
		// if the requirement is Approved or the project team mebmer list is 0 you cant add a task.
		if (selectedRequirement.getStatus().equalsIgnoreCase("Approved") ||
				ColourItGui.getModel().getSelectedProject().getTeamMemberList().getTeamMembers().size() == 0) {
			addTaskButton.setDisable(true);
		}
	}

	private void activateRoleButtonLogic( ) {
		// if the role is not admin check what buttons should be removed. else skip.
		if (ColourItGui.getModel().getUserRole() != 4) {
			if (ColourItGui.getModel().getUserRole() != 1) {
				removeProductOwnerButtons();
			}
		}

		// if the role is product Owner or admin activate logic for product owner buttons
		if (ColourItGui.getModel().getUserRole() == 1
				|| ColourItGui.getModel().getUserRole() == 4) {
			productOwnerButtonsLogic();
		}
	}

	private void removeProductOwnerButtons( ) {
		editRequirementButton.setVisible(false);
		deleteRequirementButton.setVisible(false);
		approveButton.setVisible(false);
		rejectButton.setVisible(false);
	}

	private void productOwnerButtonsLogic( ) {
		// if the requirement is ready for review the approve or reject button will show
		if ((selectedRequirement.getStatus()
				.equalsIgnoreCase("ready for review"))) {
			approveButton.setDisable(false);
			rejectButton.setDisable(false);
		} else {
			approveButton.setDisable(true);
			rejectButton.setDisable(true);
		}
	}

	// functions for button functionality
	@FXML
	private void approve( ) throws IOException {
		selectedRequirement.setStatus("Approved");
		goBack();
	}

	@FXML
	private void reject( ) throws IOException {
		selectedRequirement.setStatus("Rejected");
		goBack();
	}

	@FXML
	private void editRequirement( ) throws IOException {
		createPopUp("popUp_Requirement_Edit");
	}

	@FXML
	private void removeRequirement( ) {
		String requirementName = selectedRequirement.getRequirementName();
		String requirementStatus = selectedRequirement.getStatus();
		int totalTimeSpent = selectedRequirement.getTotalTimeSpent();

		// creation a confirmation alert
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		// setting Displayed text for Confirmation
		alert.setTitle("Delete Requirement");
		alert.setHeaderText("Are you sure you want to delete: \n" + requirementName + " ?");
		alert.setContentText("Name: " + requirementName + "\nStatus: "
				+ requirementStatus + "\nTime spent: " + totalTimeSpent + "");

		// getting what button was clicked
		Optional<ButtonType> result = alert.showAndWait();
		// if the button type is OK, delete selected requirement
		if (result.get() == ButtonType.OK) {
			Project selectedProject = ColourItGui.getModel().getSelectedProject();

			selectedProject.getRequirementList().removeRequirement(selectedRequirement.getRequirementName());
			init();
		}
	}

	@FXML
	private void popUpAddTask( ) throws IOException {
		createPopUp("popUp_TaskList_Add");
	}

	@FXML
	private void popUpTaskDetails( ) throws IOException {
		createPopUp("popUp_Task_Details");
	}

	@FXML private void itemSelected(Event event) throws IOException {//SANDER DON'T FUCKING REMOVE THIS PLEASE
		// getting what table is clicked by id

		String selectedTableId = ((Control) event.getSource()).getId();

		if (selectedTableId != null) {
			if (selectedTableId.equals("highPriorityTableView")) {
				// getting the selected task from the table View
				Task selectedTask = highPriorityTableView.getSelectionModel().getSelectedItem();
				if (selectedTask != null) {
					ColourItGui.getModel().setSelectedTask(selectedTask);
					popUpTaskDetails();
				}
			} else if (selectedTableId.equals("lowPriorityTableView")) {
				Task selectedTask = lowPriorityTableView.getSelectionModel().getSelectedItem();
				if (selectedTask != null) {
					ColourItGui.getModel().setSelectedTask(selectedTask);
					popUpTaskDetails();
				}
			}
		}
	}

	@Override
	public void goBack( ) throws IOException {
		init();
		ColourItGui.setRoot("requirementList");
	}
}
