package dk.colourit.gui;

import dk.colourit.model.Documentation;
import dk.colourit.model.MyDate;
import dk.colourit.model.TeamMember;
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
    list.add(new Documentation(new TeamMember("Peter", 123, MyDate.now()), 30, MyDate.now()));
    list.add(new Documentation(new TeamMember("Bob", 123, MyDate.now()), 33, MyDate.now()));
    list.add(new Documentation(new TeamMember("Bent", 123, MyDate.now()), 55, MyDate.now()));
    list.add(new Documentation(new TeamMember("John", 123, MyDate.now()), 26, MyDate.now()));

    ObservableList<Documentation> documentationsList = FXCollections.observableArrayList();

    documentationsList.addAll(list);

    memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamMemberName"));
    timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpent"));
    daySelectedColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

    documentationTableView.setItems(documentationsList);

  }

  @Override public void goBack()
  {

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
