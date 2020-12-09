package dk.colourit.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmDeleteProjectController extends Controller
{
  public Button confirmDeleteButton;
  public Button cancelDeleteButton;

  public void confirmDelete() throws IOException {
    ColourItGui.getModel().deleteProject(ColourItGui.getSelectedProject());
    ((Stage) cancelDeleteButton.getScene().getWindow()).close();
    ColourItGui.setRoot("projectListView");
  }

  public void cancelDelete()
  {
    ((Stage) cancelDeleteButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
  }

  @Override
  public void init() {

  }

  @Override
  public void goBack() throws IOException {

  }


}
