package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller
{

    private Controller parentController;

    protected Controller(){

    }

    public void loginScreen() throws IOException
    {
        ColourItGui.setRoot("loginScreen");
    }

    public abstract void init();

    public abstract void goBack() throws IOException;


    public void createPopUp(String fxmlName) throws IOException {

        Scene scene = new Scene(loadFXML(fxmlName));
        Stage stage = new Stage();

        stage.setScene(scene);


        // when the popUp closes the this controller updates data on scene
        stage.setOnCloseRequest(WindowEvent -> this.init());

        // when popup is open primary stage cant be accessed.
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    public static void refreshRoot(){

    }

    public void setParentController(Controller parentController) {
        this.parentController = parentController;
    }

    public Controller getParentController() {
        return parentController;
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ColourItGui.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();

        controller.init();

        controller.setParentController(this);

        return root;
    }

}
