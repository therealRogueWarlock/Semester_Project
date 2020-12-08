package dk.colourit.mediator;

import dk.colourit.Main;
import dk.colourit.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ColourITProjectManagement
{

    private ProjectList projectList;
    private TeamMemberList teamMemberList;
    private ColourItFileHandler colourItFileHandler;
    private int userRole;

    public ColourITProjectManagement()
    {

        projectList = new ProjectList();
        teamMemberList = new TeamMemberList();

        String[] names = {"Sander", "Andreas", "Seb", "Marker", "Crimmer",
            "Peter"};
        teamMemberList
            .addTeamMember(new TeamMember("Sander", 12195, MyDate.now()));
        teamMemberList
            .addTeamMember(new TeamMember("Andreas", 124312, MyDate.now()));
        teamMemberList
            .addTeamMember(new TeamMember("Seb", 12825, MyDate.now()));
        teamMemberList
            .addTeamMember(new TeamMember("Marker", 15125, MyDate.now()));
        teamMemberList
            .addTeamMember(new TeamMember("Crimmer", 11825, MyDate.now()));
        teamMemberList
            .addTeamMember(new TeamMember("Peter", 21295, MyDate.now()));

        projectList.addProject(
            new Project("project1", MyDate.now(), new MyDate(12, 12, 2021)));
        projectList.addProject(
            new Project("project2", MyDate.now(), new MyDate(12, 1, 2023)));
        projectList.addProject(
            new Project("project3", MyDate.now(), new MyDate(1, 12, 2024)));
        projectList.addProject(
            new Project("project4", MyDate.now(), new MyDate(12, 1, 2025)));
        projectList.addProject(
            new Project("project5", MyDate.now(), new MyDate(12, 1, 2026)));
        projectList.addProject(
            new Project("project6", MyDate.now(), new MyDate(1, 12, 2027)));

        for (int i = 0; i < projectList.getProjects().size(); i++)
        {
            Project project = projectList.getProjects().get(i);
            System.out.println(project + " dummy data " + project.getName());
            for (String name : names)
            {
                project.getTeamMemberList()
                    .addTeamMember(teamMemberList.getTeamMember("name", name));

            }

            project.getRequirementList().addRequirement(
                new Requirement(("requirement" + i), 10 + i, true));

            Requirement requirement = project.getRequirementList()
                .getRequirementByName(("requirement" + i));
            requirement.getTaskList()
                .addTask(new Task(("randomTask" + i), names[i], 10 + i));

            Task task = requirement.getTaskList()
                .getTaskByName(("randomTask" + i));
            task.getDocumentations()
                .add(new Documentation(names[i], 10 + i, MyDate.now()));

        }
    }

    public void selectUserRole(int role)
    {
        userRole = role;
    }

    public int getUserRole() {
        return userRole;
    }

    public void createProject(){


    public void createProject(String projectName, MyDate getStartDate, MyDate deadline)
    {
        projectList.addProject(new Project(projectName, getStartDate, deadline));
    }

    public void deleteProject(String projectName)
    {
        projectList.removeProject(projectName);
    }

    public void addMemberToProject(String projectName, String memberName,
        int memberRole)
    {
        projectList.getProjectByName(projectName).getTeamMemberList().
            getTeamMember("name", memberName).setRole(memberRole);
        /*
        Hvad med setRole, er dette nødvendigt når man laver den?
         */
    }

    public void removeMemberFromProject(String projectName, String memberName)
    {
        projectList.getProjectByName(projectName).getTeamMemberList()
            .removeTeamMember(memberName);
    }

    public void assignRoleToTeamMember(String projectName, String memberName,
        int memberRole)
    {
        projectList.getProjectByName(projectName).getTeamMemberList()
            .getTeamMember("name", memberName).setRole(memberRole);
    }

    public void taskDocumentation(String projectName, String requirementName,
        String taskName, int hours, MyDate date, String memberName)
    {
        /*projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().getTaskByName(taskName).////.getDocumentation

         */
        //Vi skal vidst lave en Documentation method i vores Task, så vi kan komme ned i den.
        //TODO:Mangler documentation method i Task
    }

    public void finishTask(String projectName, String requirementName, String taskName)
    {
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().getTaskByName(taskName).setFinito(true);
        /*
        Skal det også være muligt at sætte til false i denne funktion?
        Jeg tænker ja, da det ville være fjollet at have en seperat funktion for det.
         */
    }

    public void setRequirementReady(String projectName, String requirementName, boolean ready)
    {
        /*
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName).set

         */
            //Mangler at tilføje
        //TODO:Ready, approval, finished
    }

    public void setRequirementApproval(String projectName, String requirementName, boolean approval)
    {
        //TODO: mangler approval i Task
    }

    public void addRequirement(String projectName, String requirementName)
    {

    }

    public void removeRequirement(String projectName, String requirementName)
    {

    }

    public void setRequirementPriority(String requirementName, int priority){

    }

    public void addTask(String taskName){

    }

    public void editTask(Project project,String taskName){


    }

    public void removeTask(int taskName)
    {

    }

    public ProjectList getProjectList()
    {
        return projectList;
    }

    public TeamMemberList getTeamMemberList()
    {
        return teamMemberList;
    }

}
