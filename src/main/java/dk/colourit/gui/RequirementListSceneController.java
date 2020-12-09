package dk.colourit.gui;

import dk.colourit.model.Project;
import dk.colourit.model.Requirement;
import dk.colourit.model.TeamMember;
import dk.colourit.model.TeamMemberList;
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

public class RequirementListSceneController extends Controller
{
    public Button editButton;
    public Button backButton;

    public Button addRequirementButton;


    public ChoiceBox<Requirement> requirementChoiceBox;

    public Button removeRequirementButton;
    public Button deleteProjectButton;

    public Button addTeamMemberButton;
    public Button removeTeamMemberButton;

    public TableView<Requirement> requirementTable;
    public TableColumn<Requirement, Integer> requirementPriorityColumn;
    public TableColumn<Requirement, String> requirementNameColumn;
    public TableColumn<Requirement, Integer> requirementStatusColumn;

    public TableView<TeamMember> teamMemberTable;
    public TableColumn<TeamMember, String> teamMemberNameColumn;
    public TableColumn<TeamMember, Integer> idNumberColumn;
    public TableColumn<TeamMember, Integer> roleColumn;

    public ChoiceBox<TeamMember> addTeamMemberChoiceBox;
    public ChoiceBox<TeamMember> removeTeamMemberChoiceBox;
    public ChoiceBox<String> selectRoleChoiceBox;

    @Override public void init()
    {
        Project project = ColourItGui.getSelectedProject();

        populateChoiceBoxes(project);

        populateRequirementTable(project);

        populateTeamMemberTable(project);

        selectRoleChoiceBox.getItems().addAll("Team Member", "Project Creator", "Scrum Master", "Product Owner");


    }

    public void populateChoiceBoxes(Project project){

        addTeamMemberChoiceBox.getItems().clear();
        removeTeamMemberChoiceBox.getItems().clear();
        requirementChoiceBox.getItems().clear();

        ArrayList<TeamMember> projectTeamMembers =  project.getTeamMemberList().getTeamMembers();

        TeamMemberList employees =  ColourItGui.getModel()
                .getTeamMemberList().getCopy();

        ArrayList<TeamMember> employeesNotInProject = employees.getRemaindingTeamMembers(projectTeamMembers);

        addTeamMemberChoiceBox.getItems().addAll(employeesNotInProject);

        removeTeamMemberChoiceBox.getItems().addAll(project.getTeamMemberList().getTeamMembers());

        ArrayList<Requirement> requirements = project.getRequirementList().getRequirements();
        requirementChoiceBox.getItems().addAll(requirements);

    }

    public void populateRequirementTable(Project project){

        ArrayList<Requirement> requirements = project.getRequirementList().getRequirements();
        ObservableList<Requirement> observableRequirementList =  FXCollections.observableArrayList();

        observableRequirementList.addAll(requirements);

        requirementNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        requirementPriorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        requirementStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        requirementTable.setItems(observableRequirementList);
    }

    public void populateTeamMemberTable(Project project){

        ArrayList<TeamMember> teamMembers = project.getTeamMemberList().getTeamMembers();
        ObservableList<TeamMember> observableTeamMembers =  FXCollections.observableArrayList();

        observableTeamMembers.addAll(teamMembers);

        teamMemberNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        teamMemberTable.setItems(observableTeamMembers);


    }


    public void editButton()
    {
    }

    public void addRequirementButton() throws IOException
    {

        createPopUp("addRequirementScenePopUp");

    }

    public void removeRequirementButton()
    {

    }

    public void addTeamMemberButton() throws IOException
    {

        TeamMember selectedTeamMember = addTeamMemberChoiceBox.getSelectionModel().getSelectedItem();

        if (selectedTeamMember != null) {

            Project selectedProject = ColourItGui.getSelectedProject();
            selectedProject.getTeamMemberList().addTeamMember(selectedTeamMember);

            init();
        }


    }

    public void removeTeamMemberButton()
    {

        TeamMember selectedTeamMember = removeTeamMemberChoiceBox.getSelectionModel().getSelectedItem();

        if (selectedTeamMember != null) {
            Project selectedProject = ColourItGui.getSelectedProject();

            selectedProject.getTeamMemberList().removeTeamMember(selectedTeamMember);

            init();
        }

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

    public void goBack() throws IOException
    {
        ColourItGui.setRoot("projectListView");
    }

    public void itemSelected() throws IOException //SANDER DON'T FUCKING REMOVE THIS PLEASE
    {

        Requirement selectedRequirement = requirementTable.getSelectionModel().getSelectedItem();
        ColourItGui.setSelectedRequirement(selectedRequirement);
        ColourItGui.setRoot("taskListScene");

    }


}


