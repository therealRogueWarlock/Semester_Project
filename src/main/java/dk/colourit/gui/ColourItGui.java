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

	private static final ColourITProjectManagement model = new ColourITProjectManagement();

	protected static Scene scene;

	public static Scene getScene( ) {
		return scene;
	}


	static void setRoot(String fxml) throws IOException {
		double oldX = scene.getWindow().getX() + (scene.getWidth() / 2);

		// Get root from fxml
		Region root = loadFXML(fxml);
		// Setting root of scene
		scene.setRoot(root);
		// Setting different stage sizes from preferred height and width
		// setting stage height to preferred height from pane.
		scene.getWindow().setHeight(root.getPrefHeight());
		// Setting stage width to preferred height from pane.
		scene.getWindow().setWidth(root.getPrefWidth());

		scene.getWindow().setX(oldX - (root.getPrefWidth() / 2));
	}

	private static Region loadFXML(String fxml) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
		Region root = loader.load();

		Controller controller = loader.getController();

		controller.init();
		return root;
	}

	public static ColourITProjectManagement getModel( ) {
		return model;
	}

	public static void launchApp( ) {
		launch();
	}

	@Override
	public void start(Stage stage) throws IOException {
		Region root = loadFXML("loginScreen");
		scene = new Scene(root);
		scene.setCursor(new ImageCursor(new Image("file:colourItCursor.png")));
		// setting scene on stage
		stage.setScene(scene);

		stage.show();
		// Setting minimum size of the stage
		stage.setMinHeight(root.getHeight());
		stage.setMinWidth(root.getWidth());
		// Setting the maximum size of the stage
		stage.setMaxHeight(800);
		stage.setMaxWidth(1400);

		// When primary stage closes save to bin files.
		stage.setOnCloseRequest(e -> getModel().saveToFile());
	}
}

