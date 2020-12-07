package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskListSceneController extends Controller {

    public TableView highPriorityTableView;
    public TableView lowPriorityTableView;
    private Scene scene;
    private Stage stage;

    public Text projectNameText;
    public Text statusText;
    public Text requirementNameText;
    public Button addTaskButton;



    public void init(){

    }


    @FXML
    private void popUpAddTask() throws IOException{
        scene = new Scene(loadFXML("taskListAddPopUp"));
        stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void popUpTaskDetails() throws IOException{
        scene = new Scene(loadFXML("taskDetailsPopUp"));
        stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }


    public void backToPrevScene() throws IOException {
        ColourItGui.setRoot("secondary");
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}