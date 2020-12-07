package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ScrumClickOnTaskController extends Controller{

  @FXML private Label taskName;
  @FXML private Label totalTimeSpent;
  @FXML private CheckBox taskFinished;
  @FXML private TextArea documentationText;
  @FXML private ComboBox selectMember;
  @FXML private TextField addTimeSpent;
  @FXML private DatePicker selectDate;
  @FXML private Button logSpentTime;

  @FXML private TableView<Documentation> documentationTableView;
  @FXML private TableColumn<Documentation, String> memberNameColumn;
  @FXML private TableColumn<Documentation, Integer> timeSpentColumn;
  @FXML private TableColumn<Documentation, MyDate> daySelectedColumn;

  public void init() {
    ArrayList<Documentation> list = new ArrayList<>();
    list.add(new Documentation("Peter", 30, MyDate.now()));
    list.add(new Documentation("Bob", 33, MyDate.now()));
    list.add(new Documentation("Bent", 55, MyDate.now()));
    list.add(new Documentation("John", 26, MyDate.now()));

    ObservableList<Documentation> documentationsList = FXCollections.observableArrayList();

    documentationsList.addAll(list);

    memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
    timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpent"));
    daySelectedColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

    documentationTableView.setItems(documentationsList);

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
