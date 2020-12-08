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
        scene = new Scene(loadFXML("loginScreen",null), 1280, 720);
        stage.setScene(scene);
        stage.show();


        // when primary stage is closed, close all other open windows.
        stage.setOnCloseRequest(e -> Platform.exit());

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml, null));
    }

    static void setRoot(String fxml, Object obj) throws IOException {
        scene.setRoot(loadFXML(fxml, obj));

    }

    private static Parent loadFXML(String fxml, Object obj) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();


        controller.setObjectHolderForInit(obj);

        controller.setModel(model);



        controller.init();



        return root;
    }

    public static void launchApp() {
        launch();
    }

}

