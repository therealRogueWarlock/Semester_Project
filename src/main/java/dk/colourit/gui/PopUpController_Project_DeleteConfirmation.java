package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Project_DeleteConfirmation extends Controller {
	@FXML private Button cancelDeleteButton;

	@Override
	public void init( ) {
		// Abstract filler.
	}

	@FXML
	private void confirmDelete( ) throws IOException {
		ColourItGui.getModel().deleteProject(ColourItGui.getModel().getSelectedProject());
		ColourItGui.setRoot("projectList");
		goBack();
	}

	@Override
	public void goBack( ) throws IOException {
		// Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
		((Stage) cancelDeleteButton.getScene().getWindow()).close();
	}
}
