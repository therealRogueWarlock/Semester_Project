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
		Task task = ColourItGui.getSelectedTask();

		System.out.println("init task info for popup");
		taskNameEditTextField.setText(task.getName());
		estimatedHoursTextField.setText(Integer.toString(task.getTimeEstimateHour()));
		responsibleTeamMemberTextField.setText(task.getResponsible());
		taskTextArea.setText(task.getDescription());
		highPriorityCheckBox.setSelected(task.getPriority());
	}

	public PopUpController_Task_Details() {

	}

	public void deleteTask() {
		ColourItGui.getSelectedRequirement().getTaskList().removeTask(ColourItGui.getSelectedTask().getName());

		goBack();
	}

	public void confirmEdit() {
		String name = taskNameEditTextField.getText();
		int time = Integer.parseInt(estimatedHoursTextField.getText());
		String memberName = responsibleTeamMemberTextField.getText();
		boolean checked = highPriorityCheckBox.isSelected();
		String taskDescription = taskTextArea.getText();

//		System.out.println(ColourItGui.getSelectedTask().getName());
		ColourItGui.getSelectedTask().editTask(name, time, memberName, checked, taskDescription);
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
