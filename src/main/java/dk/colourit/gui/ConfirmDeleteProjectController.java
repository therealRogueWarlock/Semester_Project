package dk.colourit.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmDeleteProjectController
{
  public Button confirmDeleteButton;
  public Button cancelDeleteButton;

  public void confirmDelete()
  {
  }

  public void cancelDelete()
  {
    ((Stage) cancelDeleteButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
  }
}
