package dk.colourit.gui;

import dk.colourit.model.MyDate;
import dk.colourit.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddTeamMemberSceneController extends Controller {
    public TextField nameTextField;
    public TextField idNumberTextField;
    public DatePicker birthdateDatePicker;
    public ComboBox<String> roleComboBox;


    @FXML
    private Button addTeamMemberButton;

    @FXML
    private void addTeamMember() throws IOException {

        String teamMemberName = nameTextField.getText();
        int employeeIdNumber = Integer.parseInt(idNumberTextField.getText());
        MyDate birthday = new MyDate(birthdateDatePicker.getValue());

        ColourItGui.getModel().addEmployee(teamMemberName, employeeIdNumber,birthday);

        //((Stage) addTeamMemberButton.getScene().getWindow()).close(); // Get's the Window the button is in, and casts to a Stage, which can be closed with .close()
    }

    @Override
    public void init() {
        roleComboBox.getItems().addAll("Team Member", "Project Creator", "Scrum Master", "Product Owner");


    }

    @Override public void goBack()
    {

    }

}
