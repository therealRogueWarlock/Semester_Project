package dk.colourit.gui;

import dk.colourit.model.MyDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddTeamMemberSceneController extends Controller {
    public TextField nameTextField;
    public TextField idNumberTextField;

    public DatePicker birthdateDatePicker;

    @Override
    public void init() {

        /*Editable false, to make sure user can't make invalid input. Like strings
		and invalid MyDate data.*/
        birthdateDatePicker.setEditable(false);
    }

    @FXML
    private void addTeamMember() throws IOException {

        String teamMemberName = nameTextField.getText();
        int employeeIdNumber = Integer.parseInt(idNumberTextField.getText());
        MyDate birthday = new MyDate(birthdateDatePicker.getValue());

        ColourItGui.getModel().addEmployee(teamMemberName, employeeIdNumber,birthday);

        getParentController().init();
    }

    @Override public void goBack()
    {

    }

}
