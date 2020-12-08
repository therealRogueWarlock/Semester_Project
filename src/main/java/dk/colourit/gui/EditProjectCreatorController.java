package dk.colourit.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class EditProjectCreatorController extends Controller{

  @FXML public Button editButton;
  @FXML public Button addTeamMemberButton;
  @FXML public Button deleteProjectButton;
  @FXML public Button removeTeamMemberButton;
  @FXML public ChoiceBox teamMemberList;
  public TableView requirementTable;
  public TableColumn requirementNameColumn;
  public TableView teamMemberTable;
  public TableColumn teamMemberNameColumn;
  public TableColumn IDNumberColumn;
  public TableColumn roleColumn;

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

  }
}
