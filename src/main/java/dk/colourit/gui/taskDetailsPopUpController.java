package dk.colourit.gui;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class taskDetailsPopUpController {
    public Button confirmEditButton;
    public TextArea taskTextArea;
    public TextField responsibleTeamMemberTextField;
    public TextField estimatedHoursTextField;
    public TextField taskNameEditTextField;
    public CheckBox highPriorityCheckBox;
    public Button deleteTask;



    public void deleteTask(){
        //TODO: Implement Task Deletion
            ((Stage) deleteTask.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }
}
