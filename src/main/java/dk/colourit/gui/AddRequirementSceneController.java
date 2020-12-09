package dk.colourit.gui;

import dk.colourit.model.Project;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRequirementSceneController extends Controller
{
  public TextField requirementNameTextField;
  public TextField priorityTextField;
  public TextArea requirementDescriptionTextArea;
  public Button addRequirementButton;

  public void addRequirement()
  {
    Project selectedProject = ColourItGui.getSelectedProject();
    String requirementNameTextFieldText = requirementNameTextField.getText();
    //model.addRequirement(selectedProject);
  }

  @Override
  public void init() {

  }

  @Override
  public void goBack() throws IOException {

  }

}
