package dk.colourit.gui;

import dk.colourit.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTeamMemberSceneController extends Controller {
    public TextField nameTextField;
    public TextField idNumberTextField;
    public ComboBox<String> roleComboBox;
    public DatePicker birthdateDatePicker;

    @FXML
    private Button addTeamMemberButton;

    @FXML
    private void addTeamMember() throws IOException {

        Project selectedProject = ColourItGui.getSelectedProject();
        String teamMemberName = nameTextField.getText();


        //ColourItGui.getModel().addMemberToProject();


        ((Stage) addTeamMemberButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }

    @Override
    public void init() {
        roleComboBox.getItems().addAll("Team Member", "Project Creator", "Scrum Master", "Product Owner");


    }

    @Override public void goBack()
    {

    }

}
