package dk.colourit.gui;

import dk.colourit.model.Task;
import dk.colourit.model.TeamMember;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PopUpController_TaskList_Add extends Controller {

	@FXML
	private Button confirmButton;
	@FXML
	private CheckBox highPriorityCheckBox;
	@FXML
	private TextField taskNameTextField;
	@FXML
	private TextField estimatedHoursTextField;
	@FXML
	private TextArea taskDescription;

	@FXML
	private ChoiceBox<TeamMember> responsibleTeamMember;

	@Override
	public void init( ) {
		responsibleTeamMember.getItems().addAll(ColourItGui.getModel().getSelectedProject().getTeamMemberList().getTeamMembers());

		// preselect first team member in choice box
		responsibleTeamMember.getSelectionModel().select(0);
	}

	@FXML
	private void addTask( ) {
		String name = taskNameTextField.getText();

		int time = Integer.parseInt(estimatedHoursTextField.getText());
		String memberName = responsibleTeamMember.getSelectionModel().getSelectedItem().getMemberName();
		boolean priority = highPriorityCheckBox.isSelected();
		String taskDesc = taskDescription.getText();
		// getting the task list from selected requirement, adding a new task to the list
		ColourItGui.getModel().getSelectedRequirement().getTaskList().addTask(new Task(name, time, memberName, priority, taskDesc));
		ColourItGui.getModel().getSelectedRequirement().setChecked(false);

		goBack();
	}

	@Override
	public void goBack( ) {
		getParentController().init();
		((Stage) confirmButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
}
