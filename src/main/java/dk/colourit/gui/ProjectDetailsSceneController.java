package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.TeamMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectDetailsSceneController extends Controller
{
  public Button editButton;
  public TextField addRequirementInput;
  public Button addRequirementButton;
  public ChoiceBox requirementList;
  public Button removeRequirementButton;
  public Button addTeamMemberButton;
  public Button deleteProjectButton;
  public ChoiceBox teamMemberList;
  public Button removeTeamMemberButton;

  public TableView<Requirement> requirementTable;
  public TableColumn requirementPriorityColumn;
  public TableColumn<Requirement, String> requirementNameColumn;
  public TableColumn requirementStatusColumn;

  public TableView<TeamMember> teamMemberTable;
  public TableColumn<TeamMember, String> teamMemberNameColumn;
  public TableColumn<TeamMember, Integer> idNumberColumn;
  public TableColumn<TeamMember, Integer> roleColumn;

  public void editButton()
  {
  }

  public void addRequirementInput()
  {
  }

  public void addRequirementButton()
  {
  }

  public void requirementList()
  {
  }

  public void removeRequirementButton()
  {
  }

  public void addTeamMemberButton() throws IOException
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

  public void deleteProjectButton()
  {
  }

  public void teamMemberList()
  {
  }

  public void removeTeamMemberButton()
  {
  }

  public void backButton() throws IOException
  {
    ColourItGui.setRoot("projectListView");
  }

  @Override public void init()
  {
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
    idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
    teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
  }



}


