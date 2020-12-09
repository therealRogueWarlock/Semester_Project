package dk.colourit.gui;

import dk.colourit.model.MyDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

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
    LocalDate startDate = this.startDate.getValue();
    LocalDate deadLine = this.deadLine.getValue();

    ColourItGui.getModel().createProject(projectName,new MyDate(startDate), new MyDate(deadLine));


  }

  public void closePopUp() {
  }





  /*
  Mangler noget til TableView
  De 3 kolloner
  Name
  ID
  Role
  */




}
