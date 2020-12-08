package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TaskListAddPopUpController extends Controller{

    @FXML
    private Button confirmButton;

    @FXML
    private void addTask() {
        //TODO: STORE TASK

        ((Stage) confirmButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()

    }

    @Override
    public void init() {

    }

    @Override public void back()
    {

    }
}
