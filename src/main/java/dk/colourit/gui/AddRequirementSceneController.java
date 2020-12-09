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
  public TextField timeEstimateField;
  public TextArea requirementDescriptionTextArea;
  public Button addRequirementButton;

  public void addRequirement()
  {
    String requirementNameTextFieldText = requirementNameTextField.getText();

    String timeEstimateText = timeEstimateField.getText();
    int timeEstimate = Integer.parseInt(timeEstimateText);

    String priorityText = priorityTextField.getText();
    int priority = Integer.parseInt(priorityText);



    Project selectedProject = ColourItGui.getSelectedProject();

    ColourItGui.getModel().addRequirement(selectedProject, requirementNameTextFieldText, timeEstimate, priority);



    //model.addRequirement(selectedProject);
  }

  @Override
  public void init() {

  }

  @Override
  public void goBack() throws IOException {

  }

}
