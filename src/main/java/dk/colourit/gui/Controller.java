package dk.colourit.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

	// used in popUp controllers
	private Controller parentController;

	// initialize used to populate data as well as refresh data.
	public abstract void init( );

	// every controller has to implement a goBack methode, will go back to previous scene
	public abstract void goBack( ) throws IOException;

	// creating a popup using the fxml loader.
	public void createPopUp(String fxmlName) throws IOException {
		// loading scene and initializing controller for scene
		Parent root = loadFXML(fxmlName);
		// creating a scene from loaded root
		Scene scene = new Scene(root);

		Stage stage = new Stage();
		// setting sage with scene
		stage.setScene(scene);

		// When the user closes with X the popup calls init on this controller(Parent), this updates data on scene
		stage.setOnCloseRequest(WindowEvent -> this.init());
		// Popups will most often have a confirm/add button that calls getParentController.init()

		// when popup is open primary stage cant be accessed.
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}

	// used to get parent controller to call init on
	public Controller getParentController( ) {
		return parentController;
	}

	// Used to set parent controller when creating a pop up.
	public void setParentController(Controller parentController) {
		this.parentController = parentController;
	}

	// all controllers are able to load fxml to create there own stages(Popups)
	private Parent loadFXML(String fxml) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
		Parent root = loader.load();
		Controller controller = loader.getController();
		// calling init on controller, this will populate data views for scene.
		controller.init();

		// setting the parent controller for the popup
		// The popup is able to update the parent controller(the scene) when data is added,
		// giving instant feedback
		controller.setParentController(this);

		return root;
	}
}
