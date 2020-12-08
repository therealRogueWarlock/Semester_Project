package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EditProjectCreatorController extends Controller{

  @FXML public Button editButton;
  @FXML public Button addTeamMemberButton;
  @FXML public Button deleteProjectButton;
  @FXML public Button removeTeamMemberButton;
  @FXML public ChoiceBox teamMemberList;

  public TableView<TeamMember> teamMemberTable;
  public TableColumn<TeamMember, String> teamMemberNameColumn;
  public TableColumn<TeamMember, Integer> IDNumberColumn;
  public TableColumn<TeamMember, Integer> roleColumn;

  public TableView<Requirement> requirementTable;
  public TableColumn<Requirement, String> requirementNameColumn;

  @FXML private void editButton() {

  }

  @FXML private void addTeamMemberButton() throws IOException
  {
    Scene addTeamMemberScene = new Scene(loadFXML("addTeamMemberScene"));
    Stage stage = new Stage();

    stage.setScene(addTeamMemberScene);
    stage.show();
  }

  private static Parent loadFXML(String fxml) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }


  @FXML private void deleteProjectButton(){

  }

  @FXML private void removeTeamMemberButton(){

  }

  @FXML private void teamMemberList() {

  }

  @Override
  public void init() {
    Project project = (Project) getObjectHolderForInit();
    ArrayList<Requirement> requirements = project.getRequirementList().getRequirements();
    ObservableList<Requirement> observableRequirementList =  FXCollections.observableArrayList();

    observableRequirementList.addAll(requirements);


    requirementNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    requirementTable.setItems(observableRequirementList);


    ArrayList<TeamMember> teamMembers = project.getTeamMemberList().getTeamMembers();
    ObservableList<TeamMember> observableTeamMembers =  FXCollections.observableArrayList();

    observableTeamMembers.addAll(teamMembers);

    teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    IDNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
    teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

  }
}
