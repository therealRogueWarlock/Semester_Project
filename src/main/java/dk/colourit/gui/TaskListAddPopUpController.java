package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskListAddPopUpController extends Controller {

	public Button confirmButton;
	public CheckBox highPriorityCheckBox;
	public TextField taskNameTextField;
	public TextField estimatedHoursTextField;
	public TextField responsibleTeamMemberTextField;
	public TextArea taskDescription;

	@FXML
	private void addTask() {
		String name = taskNameTextField.getText();
		int time = Integer.parseInt(estimatedHoursTextField.getText());
		String member = responsibleTeamMemberTextField.getText();
		boolean priority = highPriorityCheckBox.isSelected();
		String taskDesc = taskDescription.getText();
//		ColourItGui.getSelectedRequirement().getTaskList().addTask(new Task(name, time, member, priority, taskDesc));

		ColourItGui.getModel().addTask(ColourItGui.getSelectedProject().getName(), ColourItGui.getSelectedRequirement().getName(), name, member, time, priority, taskDesc);
		goBack();
	}

	@Override
	public void init() {

	}

	@Override
	public void goBack() {
		getParentController().init();
		((Stage) confirmButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
}
