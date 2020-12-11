package dk.colourit.gui;

import dk.colourit.model.Requirement;

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
            Requirement requirement = ColourItGui.getModel().getSelectedRequirement();

            requirementNameTextField.setText(requirement.getRequirementName());
            priorityTextField.setText(Integer.toString(requirement.getPriority()));
            timeEstimateField.setText(Integer.toString(requirement.getRequirementTimeEstimate()));
            requirementDescriptionTextArea.setText(requirement.getRequirementDescription());

        }

    @Override
    public void goBack() throws IOException {
        getParentController().init();
        ((Stage) editRequirementButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }

    public void confirmEdit() throws IOException {
        String name = requirementNameTextField.getText();
        int priority = Integer.parseInt(priorityTextField.getText());
        int timeEstimate = Integer.parseInt(timeEstimateField.getText());
        String requiredDescription = requirementDescriptionTextArea.getText();

        ColourItGui.getModel().getSelectedRequirement().setRequirementName(name);
        ColourItGui.getModel().getSelectedRequirement().setPriority(priority);
        ColourItGui.getModel().getSelectedRequirement().setRequirementTimeEstimate(timeEstimate);
        ColourItGui.getModel().getSelectedRequirement().setRequirementDescription(requiredDescription);
        //TODO: requirementDescriptionTextArea - Virker den nu?

        goBack();
    }

}
