package dk.colourit.gui;

import javafx.fxml.FXML;
import java.io.IOException;

public class Controller_LoginScreen extends Controller {

	@FXML
	private void selectedProjectCreatorRole( ) throws IOException {
		ColourItGui.getModel().selectUserRole(3);
		ColourItGui.setRoot("projectList");
	}

	@FXML
	private void selectedScrumMasterRole( ) throws IOException {
		ColourItGui.getModel().selectUserRole(2);
		ColourItGui.setRoot("projectList");
	}

	@FXML
	private void selectedProductOwnerRole( ) throws IOException {
		ColourItGui.getModel().selectUserRole(1);
		ColourItGui.setRoot("projectList");
	}

	@FXML
	private void selectedTeamMemberRole( ) throws IOException {
		ColourItGui.getModel().selectUserRole(0);
		ColourItGui.setRoot("projectList");
	}

	@Override
	public void init() {}

	@Override
	public void goBack(){}


	@FXML
	private void selectedAdminRole( ) throws IOException {
		ColourItGui.getModel().selectUserRole(4);
		ColourItGui.setRoot("projectList");
	}

}
