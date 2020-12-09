package dk.colourit.gui;

import dk.colourit.model.TeamMember;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TaskListAddPopUpController extends Controller {

	public Button confirmButton;
	public CheckBox highPriorityCheckBox;
	public TextField taskNameTextField;
	public TextField estimatedHoursTextField;
	public TextArea taskDescription;
	public Button cancelButton;
	public ChoiceBox<TeamMember> responsibleTeamMember;

	@Override
	public void init() {
		responsibleTeamMember.getItems().addAll(ColourItGui.getSelectedProject().getTeamMemberList().getTeamMembers());
	}

	@FXML
	private void addTask() {
		String name = taskNameTextField.getText();
		int time = Integer.parseInt(estimatedHoursTextField.getText());
		TeamMember member = responsibleTeamMember.getSelectionModel().getSelectedItem();
		boolean priority = highPriorityCheckBox.isSelected();
		String taskDesc = taskDescription.getText();
//		ColourItGui.getSelectedRequirement().getTaskList().addTask(new Task(name, time, member, priority, taskDesc));

		ColourItGui.getModel().addTask(ColourItGui.getSelectedProject().getName(), ColourItGui.getSelectedRequirement().getName(), name, member.getName(), time, priority, taskDesc);
		goBack();
	}

	@Override
	public void goBack() {
		getParentController().init();
		((Stage) confirmButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
}
