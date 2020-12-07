package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTeamMemberSceneController extends Controller {
    @FXML
    private Button addTeamMemberButton;

    @FXML
    private void addTeamMember() throws IOException {
        ((Stage) addTeamMemberButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }

    @Override
    public void init() {

    }

}
