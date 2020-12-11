package dk.colourit.gui;

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

public class  Controller_TaskList extends Controller {

	public GridPane mainContainer;
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
	public Button rejectButton;
	public Button approveButton;
	public Button editRequirementButton;
    public Label roleSelectedLabel;

    private TaskList taskList;

	public void init( ) {
		Requirement requirement = ColourItGui.getModel().getSelectedRequirement( );
		taskList = requirement.getTaskList( );

		populateHighPriorityTable();
		populateLowPriorityTable();
		populateInformationText(requirement);

		// logic for buttons
		generalButtonLogic();

		// checking logic for buttons for the different roles.
		activateRoleButtonLogic();
	}

	// functions for populating data / tables on scene
	private void populateHighPriorityTable( ) {
		highPriorityTableView.getItems( ).clear( );
		// getting high priority task from task list
		ArrayList<Task> highPriorityTasks = taskList.getHighPriority( );
		ObservableList<Task> observableHighPriorityTasks = FXCollections.observableArrayList( );

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

	private void populateLowPriorityTable( ) {
		lowPriorityTableView.getItems( ).clear( );
		// getting the low priority task from task list
		ArrayList<Task> lowPriorityTasks = taskList.getLowPriority( );
		ObservableList<Task> observableLowPriorityTasks = FXCollections.observableArrayList( );

		observableLowPriorityTasks.addAll(lowPriorityTasks);

		taskNameLowColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		estimatedTimeLowColumn.setCellValueFactory(new PropertyValueFactory<>("timeEstimateHour"));
		totalTimeSpentLowColumn.setCellValueFactory(new PropertyValueFactory<>("totalTimeSpent"));
		responsibleLowColumn.setCellValueFactory(new PropertyValueFactory<>("responsible"));
		taskStatusLowColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		lowPriorityTableView.setItems(observableLowPriorityTasks);
	}

	private void populateInformationText(Requirement requirement){
		// setting information text on scene
		projectNameText.setText(ColourItGui.getModel().getSelectedProject( ).getProjectName( ));
		statusText.setText(requirement.getStatus( ));
		requirementNameText.setText(requirement.getRequirementName( ));

		roleSelectedLabel.setText(ColourItGui.getModel().getUseRoleString());
	}


	// functions for button disable/enable logic
	private void generalButtonLogic(){
		// if the requirement is Approved or the project team mebmer list is 0 you cant add a task.
		if (ColourItGui.getModel().getSelectedRequirement().getStatus().equalsIgnoreCase("Approved") ||
				ColourItGui.getModel().getSelectedProject().getTeamMemberList().getTeamMembers().size() == 0 ) {
			addTaskButton.setDisable(true);
		}
	}

	private void activateRoleButtonLogic(){

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

	private void removeProductOwnerButtons(){
		editRequirementButton.setVisible(false);
		approveButton.setVisible(false);
		rejectButton.setVisible(false);
	}

	private void productOwnerButtonsLogic(){
		// if the requirement is ready for review the approve or reject button will show
		if ( ( ColourItGui.getModel().getSelectedRequirement( ).getStatus( )
				.equalsIgnoreCase("ready for review"))) {
			approveButton.setDisable(false);
			rejectButton.setDisable(false);
		} else {
			approveButton.setDisable(true);
			rejectButton.setDisable(true);
		}
	}


	// functions for button functionality
	public void approve( ) throws IOException {
		ColourItGui.getModel().getSelectedRequirement( ).setStatus("Approved");
		goBack( );
	}

	public void reject( ) throws IOException {
		ColourItGui.getModel().getSelectedRequirement( ).setStatus("Rejected");
		goBack( );
	}

	@Override
	public void goBack( ) throws IOException {
		init( );
		ColourItGui.setRoot("requirementList");
	}

	@FXML
	private void popUpAddTask( ) throws IOException {
		createPopUp("popUp_TaskList_Add");
	}

	@FXML
	private void editRequirement( ) throws IOException {
		createPopUp("popUp_Requirement_Edit");
	}

	@FXML
	private void popUpTaskDetails( ) throws IOException {

		createPopUp("popUp_Task_Details");

	}

	public void itemSelected(Event event) throws IOException {//SANDER DON'T FUCKING REMOVE THIS PLEASE
		// getting what table is clicked by id

		String selectedTableId = ( (Control) event.getSource( ) ).getId( );

		if ( selectedTableId != null ) {
			if ( selectedTableId.equals("highPriorityTableView") ) {
				// getting the selected task from the table View
				Task selectedTask = highPriorityTableView.getSelectionModel( ).getSelectedItem( );

				if(selectedTask!=null)
				{
					ColourItGui.getModel().setSelectedTask(selectedTask);
					popUpTaskDetails( );
				}
			} else if ( selectedTableId.equals("lowPriorityTableView") ) {
				Task selectedTask = lowPriorityTableView.getSelectionModel( ).getSelectedItem( );

				if(selectedTask!=null)
				{
					ColourItGui.getModel().setSelectedTask(selectedTask);
					popUpTaskDetails( );
				}
			}
		}
	}
}
