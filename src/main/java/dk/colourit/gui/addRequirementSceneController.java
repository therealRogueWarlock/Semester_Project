package dk.colourit.gui;

import dk.colourit.model.Project;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class addRequirementSceneController
{
  public TextField requirementNameTextField;
  public TextField priorityTextField;
  public TextArea requirementDescriptionTextArea;
  public Button addRequirementButton;

  public void addRequirementMember()
  {
    Project selectedProject = ColourItGui.getSelectedProject();
    String requirementNameTextFieldText = requirementNameTextField.getText();
    //model.addRequirement(selectedProject);
  }
}
