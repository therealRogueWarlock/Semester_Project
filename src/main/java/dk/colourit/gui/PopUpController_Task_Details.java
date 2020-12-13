package dk.colourit.gui;

import dk.colourit.model.Task;
import dk.colourit.model.TeamMember;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Task_Details extends Controller {

	@FXML
	private Button confirmEditButton;
	@FXML
	private Button deleteTask;
	@FXML
	private Button documentationButton;

	@FXML
	private TextField taskNameEditTextField;
	@FXML
	private TextField estimatedHoursTextField;
	@FXML
	private CheckBox highPriorityCheckBox;

	@FXML
	private TextArea taskTextArea;
	@FXML
	private ChoiceBox<TeamMember> responsibleTeamMember;

	@Override
	public void init( ) {
		Task task = ColourItGui.getModel().getSelectedTask();

		responsibleTeamMember.getItems().addAll(ColourItGui.getModel().getSelectedProject().getTeamMemberList().getTeamMembers());
		responsibleTeamMember.getSelectionModel().select(0);

		taskNameEditTextField.setText(task.getTaskName());
		estimatedHoursTextField.setText(Integer.toString(task.getTaskTimeEstimate()));

		taskTextArea.setText(task.getTaskDescription());
		highPriorityCheckBox.setSelected(task.getPriority());

		activateRoleButtonLogic();
	}

	private void activateRoleButtonLogic( ) {
		// if the role is not admin check what buttons should be removed. else skip.
		if (ColourItGui.getModel().getUserRole() != 4) {
			// if the user role is not scrum master, remove scrum masters buttons.
			if (ColourItGui.getModel().getUserRole() != 2) {
				removeScrumMasterButtons();
			}
		}
	}

	private void removeScrumMasterButtons( ) {
		documentationButton.setVisible(false);
	}

	@FXML
	private void deleteTask( ) {
		ColourItGui.getModel().getSelectedRequirement().getTaskList()
				.removeTask(ColourItGui.getModel().getSelectedTask().getTaskName());

		goBack();
	}

	@FXML
	private void confirmEdit( ) {
		String name = taskNameEditTextField.getText();
		int time = Integer.parseInt(estimatedHoursTextField.getText());
		String memberName = responsibleTeamMember.getSelectionModel().getSelectedItem().getMemberName();
		boolean checked = highPriorityCheckBox.isSelected();
		String taskDescription = taskTextArea.getText();

//		System.out.println(ColourItGui.getSelectedTask().getName());
		ColourItGui.getModel().getSelectedTask().editTask(name, time, memberName, checked, taskDescription);
		goBack();
	}

	@FXML
	private void documentationPopup( ) throws IOException {
		createPopUp("popUp_Documentation");
	}

	@FXML
	private void enableEditConfirmationButton( ) {
		confirmEditButton.setDisable(false);
	}

	@Override
	public void goBack( ) {
		getParentController().init();
		((Stage) deleteTask.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
}
