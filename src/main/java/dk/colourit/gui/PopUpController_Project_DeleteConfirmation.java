package dk.colourit.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Project_DeleteConfirmation extends Controller
{
  public Button confirmDeleteButton;
  public Button cancelDeleteButton;

  @Override
  public void init() {

  }

  public void confirmDelete() throws IOException {
    ColourItGui.getModel().deleteProject(ColourItGui.getSelectedProject());
    ((Stage) cancelDeleteButton.getScene().getWindow()).close();
    ColourItGui.setRoot("projectList");
  }


  @Override
  public void goBack() throws IOException {
    getParentController().init();
    ((Stage) cancelDeleteButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
  }

}
