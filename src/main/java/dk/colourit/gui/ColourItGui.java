package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;
import dk.colourit.model.Documentation;
import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.Task;
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

    private static Project selectedProject;
    private static Requirement selectedRequirement;
    private static Task selectedTask;
    private static Documentation selectedDocumentation;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loginScreen"), 1280, 720);
        stage.setScene(scene);
        stage.show();

        // when primary stage is closed, close all other open windows.
        stage.setOnCloseRequest(e -> Platform.exit());
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    public static void setSelectedProject(Project selectedProject) {
        ColourItGui.selectedProject = selectedProject;
    }

    public static Project getSelectedProject() {
        return selectedProject;
    }

    public static void setSelectedRequirement(Requirement selectedRequirement) {
        ColourItGui.selectedRequirement = selectedRequirement;
    }

    public static Requirement getSelectedRequirement() {
        return selectedRequirement;
    }

    public static void setSelectedTask(Task selectedTask) {
        ColourItGui.selectedTask = selectedTask;
    }

    public static Task getSelectedTask() {
        return selectedTask;
    }

    public static void setSelectedDocumentation(Documentation selectedDocumentation) {
        ColourItGui.selectedDocumentation = selectedDocumentation;
    }

    public static Documentation getSelectedDocumentation() {
        return selectedDocumentation;
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


    public static ColourITProjectManagement getModel(){
        return model;
    }

    public static void launchApp() {
        launch();
    }

}

