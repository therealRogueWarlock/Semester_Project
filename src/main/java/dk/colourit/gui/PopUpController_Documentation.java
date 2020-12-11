package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.DateTimeException;
import java.util.ArrayList;

public class PopUpController_Documentation extends Controller {

	public Label taskName;
	public Label totalTimeSpent;

	@FXML
	private Button logSpentTime;
	@FXML
	private Button confirm;

	@FXML
	private TextField addTimeSpent;

	@FXML
	private ComboBox<TeamMember> selectMember;

	@FXML
	private DatePicker selectDate;

	@FXML
	private CheckBox taskFinished;

	@FXML
	private TableView<Documentation> documentationTableView;
	@FXML
	private TableColumn<Documentation, String> memberNameColumn;
	@FXML
	private TableColumn<Documentation, Integer> timeSpentColumn;
	@FXML
	private TableColumn<Documentation, MyDate> daySelectedColumn;
	@FXML
	private Label validationLabel;

	public void init( ) {
		populateComboBox( );
		populateTableView( );

		//Editable false, to make sure user can't make invalid input. Like strings and invalid MyDate data.
		selectDate.setEditable(false);
	}

	// functions for populating data on popup.

    private void populateComboBox( ) {
		selectMember.getItems( ).clear( );
		ArrayList<TeamMember> teamMembers = ColourItGui.getModel( ).getSelectedProject( ).getTeamMemberList( ).getTeamMembers( );
		selectMember.getItems( ).addAll(teamMembers);
	}
	private void populateTableView( ) {
		ArrayList<Documentation> documentations = ColourItGui.getModel( ).getSelectedTask( ).getDocumentations( );

		ObservableList<Documentation> observableDocumentations = FXCollections.observableArrayList( );

		observableDocumentations.addAll(documentations);

		memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
		timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpentDocumentation"));
		daySelectedColumn.setCellValueFactory(new PropertyValueFactory<>("documentationDate"));

		documentationTableView.setItems(observableDocumentations);
	}

	// functions for button functionality

    @Override
	public void goBack( ) {
		getParentController( ).init( );
		( (Stage) confirm.getScene( ).getWindow( ) ).close( ); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
	}
	public void confirm( ) {
		ColourItGui.getModel( ).getSelectedTask( ).setFinito(taskFinished.isSelected( ));
		getParentController( ).getParentController( ).init( );
		goBack( );
	}

	public void toggleDisabledLogSpentTimeButton( ) {
		logSpentTime.setDisable(! ( logSpentTime.isDisable( ) ));
	}

	@FXML
	private void addDocumentation( ) {
		try {
			TeamMember member = (TeamMember) selectMember.getSelectionModel( ).getSelectedItem( );
			int timeSpent = Integer.parseInt(addTimeSpent.getText( ));
			if ( MyDate.now( ).isBefore(new MyDate(selectDate.getValue( ))) )
				throw new DateTimeException("Date can't be later than current day");
			MyDate date = new MyDate(selectDate.getValue( ));
			ColourItGui.getModel( ).getSelectedTask( ).getDocumentations( ).add(new Documentation(member, timeSpent, date));
			init( );
//			getParentController( ).init( );
//			getParentController( ).getParentController( ).init( );
		} catch ( DateTimeException dateTimeException ) {
			validationLabel.setText("Invalid date");
		}
	}

    public void removeTeamMember( ) {
        ColourItGui.getModel().getSelectedTask().getDocumentations().remove(documentationTableView.getSelectionModel().getSelectedItem());
        init();
    }
}
