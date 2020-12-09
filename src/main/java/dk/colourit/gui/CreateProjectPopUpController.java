package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateProjectPopUpController extends Controller {

  @FXML private TextField projectName;
  @FXML private DatePicker startDate;
  @FXML private DatePicker deadLine;

  @FXML private ComboBox selectMember;
  @FXML private Button addMember;
  @FXML private Button confirm;
  @FXML private Button reject;

  @Override
  public void init() {

  }

  @Override public void goBack()
  {

  }

  public void confirmCreateProject() {
    String projectName = this.projectName.getText();







//    model.createProject();


  }





  /*
  Mangler noget til TableView
  De 3 kolloner
  Name
  ID
  Role
  */




}
