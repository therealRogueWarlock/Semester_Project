package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ColourItGui extends Application {

    private static Scene scene;
    private static final
    ColourITProjectManagement model = new ColourITProjectManagement();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loginScreen"), 635, 604);
        stage.setScene(scene);
        stage.show();


        // when primary stage is closed, close all other open windows.
        stage.setOnCloseRequest(e -> Platform.exit());

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    private static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();

        controller.setModel(model);

        controller.init();

        return root;
    }

    public static void launchApp() {
        launch();
    }

}

