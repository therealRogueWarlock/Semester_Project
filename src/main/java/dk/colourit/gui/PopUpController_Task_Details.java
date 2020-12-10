package dk.colourit.gui;

import dk.colourit.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Task_Details extends Controller {

	public Button confirmEditButton;
	public Button deleteTask;
	public Button documentationButton;
	public Button cancelButton;

	public TextField taskNameEditTextField;
	public TextField estimatedHoursTextField;
	public TextField responsibleTeamMemberTextField;

	public CheckBox highPriorityCheckBox;

	public TextArea taskTextArea;


	@Override
	public void init() {
		Task task = ColourItGui.getModel().getSelectedTask();

		taskNameEditTextField.setText(task.getName());
		estimatedHoursTextField.setText(Integer.toString(task.getTimeEstimateHour()));
		responsibleTeamMemberTextField.setText(task.getResponsible());
		taskTextArea.setText(task.getDescription());
		highPriorityCheckBox.setSelected(task.getPriority());

		activateRoleButtonLogic();
	}


	private void generalButtonLogic(){
	}


	private void activateRoleButtonLogic(){
		// if the role is not admin check what buttons should be removed. else skip.
		if (ColourItGui.getModel().getUserRole() != 4) {
			// if the user role is not scrum master, remove scrum masters buttons.
			if (ColourItGui.getModel().getUserRole() != 2) {
				removeScrumMasterButtons();
			}
		}
	}

	private void removeScrumMasterButtons(){
		documentationButton.setVisible(false);
	}


	public void deleteTask() {
		ColourItGui.getModel().getSelectedRequirement().getTaskList()
				.removeTask(ColourItGui.getModel().getSelectedTask().getName());

		goBack();
	}

	public void confirmEdit() {
		String name = taskNameEditTextField.getText();
		int time = Integer.parseInt(estimatedHoursTextField.getText());
		String memberName = responsibleTeamMemberTextField.getText();
		boolean checked = highPriorityCheckBox.isSelected();
		String taskDescription = taskTextArea.getText();

//		System.out.println(ColourItGui.getSelectedTask().getName());
		ColourItGui.getModel().getSelectedTask().editTask(name, time, memberName, checked, taskDescription);
		goBack();
	}

	@Override
	public void goBack()
	{
		getParentController().init();
		((Stage) deleteTask.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}


	@FXML
	private void documentationPopup() throws IOException {
		createPopUp("popUp_Documentation");
	}

	@FXML
	private void enableEditConfirmationButton() {
		confirmEditButton.setDisable(false);
	}
}
