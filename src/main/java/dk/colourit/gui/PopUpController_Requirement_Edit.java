package dk.colourit.gui;

import dk.colourit.model.Requirement;
import dk.colourit.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Requirement_Edit extends Controller{

    @FXML private TextField requirementNameTextField;
    @FXML private TextField priorityTextField;
    @FXML private TextField timeEstimateField;

    @FXML private TextArea requirementDescriptionTextArea;

    @FXML private Button editRequirementButton;



        @Override
        public void init( ) {
            Requirement requirement = ColourItGui.getSelectedRequirement();

            requirementNameTextField.setText(requirement.getName());
            priorityTextField.setText(Integer.toString(requirement.getPriority()));
            timeEstimateField.setText(Integer.toString(requirement.getTimeEstimate()));
            //TODO:Få linjen under til at fungere. (Tror ikke vi har en Description på vores Requirements lige nu?)

            /*
            requirementDescriptionTextArea.setText(requirement.set); - Kan denne laves endnu? - Se nedeunder for eksempel
            taskTextArea.setText(task.getDescription());
             */
        }

    @Override
    public void goBack() throws IOException {
        getParentController().init();
    }

    public void confirmEdit()
    {
        String name = requirementNameTextField.getText();
        int priority = Integer.parseInt(priorityTextField.getText());
        int timeEstimate = Integer.parseInt(timeEstimateField.getText());

        ColourItGui.getSelectedRequirement().setName(name);
        ColourItGui.getSelectedRequirement().setPriority(priority);
        ColourItGui.getSelectedRequirement().setTimeEstimate(timeEstimate);
        //TODO: requirementDescriptionTextArea - Virker ikke endnu..

        //String taskDescription = taskTextArea.getText();

        //goBack(); ??
    }

}
