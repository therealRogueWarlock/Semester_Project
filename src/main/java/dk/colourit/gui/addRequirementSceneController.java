package dk.colourit.gui;

import dk.colourit.model.Project;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class addRequirementSceneController
{
  public TextField requirementNameTextField;
  public TextField priorityTextField;
  public TextArea requirementDescriptionTextArea;
  public Button addTeamMemberButton;

  public void addTeamMember()
  {
    Project selectedProject = ColourItGui.getSelectedProject();
    String requirementName = requirementNameTextField.getText();
    //model.addRequirement(selectedProject);
  }
}
