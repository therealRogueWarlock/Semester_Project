package dk.colourit.gui;

import dk.colourit.model.Task;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskDetailsPopUpController extends Controller {

    public Button confirmEditButton;
    public Button deleteTask;

    public TextField taskNameEditTextField;
    public TextField estimatedHoursTextField;
    public TextField responsibleTeamMemberTextField;

    public CheckBox highPriorityCheckBox;

    public TextArea taskTextArea;


    public TaskDetailsPopUpController(){

    }

    public void deleteTask(){
        //TODO: Implement Task Deletion
            ((Stage) deleteTask.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }

    @Override
    public void init() {
        Task task =  ColourItGui.getSelectedTask();

        System.out.println("init task info for popup");
        taskNameEditTextField.setText(task.getName());
        estimatedHoursTextField.setText(Integer.toString(task.getTimeEstimateHour()));
        responsibleTeamMemberTextField.setText(task.getResponsible());
        taskTextArea.setText(task.getDescription());
    }

    @Override public void goBack()
    {
        //TODO: Der skal laves en knap der går tilbage
    }


}
