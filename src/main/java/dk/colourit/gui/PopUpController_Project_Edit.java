package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Project_Edit extends Controller {

	@FXML
	private Button confirmationButton;
	@FXML
	private TextField nameField;

	@FXML
	private void confirm( ) throws IOException {
		if ( ! nameField.getText( ).isBlank( ) && ! nameField.getText( ).isEmpty( ) ) {
			ColourItGui.getSelectedProject( ).setName(nameField.getText( ));
			goBack( );
		}
	}

	@Override
	public void init( ) {
		nameField.clear( );
	}

	@Override
	public void goBack( ) throws IOException {
		getParentController( ).init( );
		( (Stage) confirmationButton.getScene( ).getWindow( ) ).close( );
	}
}
