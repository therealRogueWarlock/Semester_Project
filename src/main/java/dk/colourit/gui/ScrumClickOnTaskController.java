package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScrumClickOnTaskController
{

  @FXML private Label taskName;
  @FXML private Label totalTimeSpent;
  @FXML private CheckBox taskFinished;
  @FXML private TextArea documentationText;
  @FXML private ComboBox selectMember;
  @FXML private TextField addTimeSpent;
  @FXML private DatePicker selectDate;
  @FXML private Button logSpentTime;

  @FXML private TableView<Documentation> logList;
  @FXML private TableColumn<Documentation, String> memberNameList;
  @FXML private TableColumn<Documentation, Integer> timeSpentList;
  @FXML private TableColumn<Documentation, MyDate> daySelectedList;

  public void init()
  {
    ArrayList<Documentation> list = new ArrayList<>();
    list.add(new Documentation("Peter", 30, MyDate.now()));
    list.add(new Documentation("Bob", 33, MyDate.now()));
    list.add(new Documentation("Bent", 55, MyDate.now()));
    list.add(new Documentation("John", 26, MyDate.now()));

    ObservableList<Documentation> documentationsList = FXCollections.observableArrayList();

    documentationsList.addAll(list);

    memberNameList.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
    timeSpentList.setCellValueFactory(new PropertyValueFactory<>("timeSpent"));
    daySelectedList.setCellValueFactory(new PropertyValueFactory<>("date"));

    logList.setItems(documentationsList);
  }


  /*
  Mangler noget til TableView
  Team Member
  Time Spent
  https://www.tutorialspoint.com/how-to-add-data-to-a-tableview-in-javafx
   */
  @FXML private Button confirm;
  @FXML private Button reject;

  public void onAddItem(ActionEvent event) {
  }

}
