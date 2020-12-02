package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class requirementListSceneController {

    private Scene scene;
    private Stage stage;

    public Text projectNameText;
    public Text statusText;
    public Text requirementNameText;
    public Button addTaskButton;


    @FXML
    private void popUpAddTask() throws IOException{
        scene = new Scene(loadFXML("requirementListAddPopUp"));
        stage = new Stage();

        stage.setScene(scene);
        stage.show();

    }



    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }





}
