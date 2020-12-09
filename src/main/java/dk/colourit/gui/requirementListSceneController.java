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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class requirementListSceneController extends Controller
{
    public Button editButton;
    public Button backButton;

    public TextField addRequirementInput;
    public Button addRequirementButton;

    public ChoiceBox<Requirement> requirementList;
    public Button removeRequirementButton;

    public Button deleteProjectButton;

    public Button addTeamMemberButton;
    public ChoiceBox<TeamMember> teamMemberList;
    public Button removeTeamMemberButton;

    public TableView<Requirement> requirementTable;
    public TableColumn<Requirement, Integer> requirementPriorityColumn;
    public TableColumn<Requirement, String> requirementNameColumn;
    public TableColumn<Requirement, Integer> requirementStatusColumn;

    public TableView<TeamMember> teamMemberTable;
    public TableColumn<TeamMember, String> teamMemberNameColumn;
    public TableColumn<TeamMember, Integer> idNumberColumn;
    public TableColumn<TeamMember, Integer> roleColumn;

    public void editButton()
    {
    }

    public void addRequirementButton() throws IOException
    {
        Scene addRequirementScene = new Scene(loadFXML("addRequirementScenePopUp"));
        Stage stage = new Stage();

        stage.setScene(addRequirementScene);
        stage.show();
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

        // when the popUp closes the this controller updates data on scene
        stage.setOnCloseRequest(WindowEvent -> this.init());

        // when popup is open primary stage cant be accessed.
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void deleteProjectButton() throws IOException
    {
        Scene confirmDeleteProjectScene = new Scene(loadFXML("confirmDeleteProject"));
        Stage stage = new Stage();

        stage.setScene(confirmDeleteProjectScene);
        stage.show();
    }

    public void teamMemberList()
    {
    }

    public void removeTeamMemberButton()
    {
    }

    public void goBack() throws IOException
    {
        ColourItGui.setRoot("projectListView");
    }

    @Override public void init()
    {
        Project project = ColourItGui.getSelectedProject();

        ArrayList<Requirement> requirements = project.getRequirementList().getRequirements();

        ObservableList<Requirement> observableRequirementList =  FXCollections.observableArrayList();

        observableRequirementList.addAll(requirements);

        requirementNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        requirementPriorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        requirementStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        requirementTable.setItems(observableRequirementList);


        ArrayList<TeamMember> teamMembers = project.getTeamMemberList().getTeamMembers();
        ObservableList<TeamMember> observableTeamMembers =  FXCollections.observableArrayList();

        observableTeamMembers.addAll(teamMembers);

        teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        teamMemberTable.setItems(observableTeamMembers);


    }


    public void itemSelected() throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
    {

        Requirement selectedRequirement = requirementTable.getSelectionModel().getSelectedItem();
        ColourItGui.setSelectedRequirement(selectedRequirement);
        ColourItGui.setRoot("taskListScene");

    }


}


