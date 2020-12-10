package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;
import dk.colourit.model.Documentation;
import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.Task;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ColourItGui extends Application {

	private static final
	ColourITProjectManagement model = new ColourITProjectManagement( );
	private static Scene scene;


	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}


	private static Parent loadFXML(String fxml) throws IOException {

		FXMLLoader loader = new FXMLLoader( );
		loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
		Parent root = loader.load( );

		Controller controller = loader.getController( );

		controller.init( );

		return root;

	}

	public static ColourITProjectManagement getModel( ) {
		return model;
	}

	public static void launchApp( ) {
		launch( );
	}

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("loginScreen"), 1280, 720);
		scene.setCursor(new ImageCursor(new Image("file:colourItCursor.png")));
		stage.setScene(scene);
		stage.show( );

		// when primary stage is closed, close all other open windows.
		stage.setOnCloseRequest(e -> Platform.exit( ));
	}

}

