package dk.colourit.gui;

import dk.colourit.model.MyDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController_Project_Edit extends Controller {

	@FXML
	private Button confirmationButton;
	@FXML
	private TextField nameField;
	@FXML
	private DatePicker startDate;
	@FXML
	private DatePicker deadLine;

	@FXML
	private void confirm( ) throws IOException {
		if ( ! nameField.getText( ).isBlank( ) && ! nameField.getText( ).isEmpty( ) ) {
			ColourItGui.getModel().getSelectedProject( ).setProjectName(nameField.getText( ));
			if ( ! ( startDate.getValue() == null ) )
				ColourItGui.getModel().getSelectedProject( ).setProjectStartDate(new MyDate(startDate.getValue( )));
			if ( ! ( deadLine.getValue() == null ) && ColourItGui.getModel().getSelectedProject( ).getProjectStartDate( ).isBefore(new MyDate(deadLine.getValue( ))) )
				ColourItGui.getModel().getSelectedProject( ).setProjectDeadline(new MyDate(deadLine.getValue( )));
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
