package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ColourItGui extends Application {

	private static final ColourITProjectManagement model = new ColourITProjectManagement( );

	protected static Scene scene;

	public static Scene getScene( ) {
		System.out.println("ColourItGui.java | getScene() " + scene);
		return scene;
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
		Pane mainContainer = (Pane) scene.lookup("#mainContainer");
		scene.getWindow().setHeight(mainContainer.getPrefHeight());
		scene.getWindow().setWidth(mainContainer.getPrefWidth());
	}

	private static Region loadFXML(String fxml) throws IOException {

		FXMLLoader loader = new FXMLLoader( );
		loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
		Region root = loader.load( );

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
		scene = new Scene(loadFXML("loginScreen"),440,340);
		scene.setCursor(new ImageCursor(new Image("file:colourItCursor.png")));
		stage.setScene(scene);
		stage.show( );
		System.out.println("ColourItGui.java | start() " + scene);
		// when primary stage closes save to bin files.
		stage.setOnCloseRequest(e -> getModel( ).saveToFile( ));
	}
}

