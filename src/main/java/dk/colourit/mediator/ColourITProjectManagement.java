package dk.colourit.mediator;


import dk.colourit.model.*;

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

            int j = 0;

            for (String name : names){
                project.getTeamMemberList()
                    .addTeamMember(teamMemberList.getTeamMember("name", name));


                project.getRequirementList().addRequirement(
                    new Requirement(("requirement" + j), 10 + j, j));

                Requirement requirement = project.getRequirementList()
                    .getRequirementByName(("requirement" + j));
                requirement.getTaskList()
                    .addTask(new Task(("randomTask" + j), names[j], 10 + j, (j%2 == 0)));

                Task task = requirement.getTaskList()
                    .getTaskByName(("randomTask" + j));
                task.getDocumentations()
                    .add(new Documentation(names[j], 10 + j, MyDate.now()));

                j++;

            }

        }
    }

    public void selectUserRole(int role)
    {
        userRole = role;
    }

    public int getUserRole() {
        return userRole;
    }

    public ProjectList getProjectList()
    {
        return projectList;
    }

    public TeamMemberList getTeamMemberList()
    {
        return teamMemberList;
    }

    public void createProject(String projectName, MyDate getStartDate, MyDate deadline)
    {
        projectList.addProject(new Project(projectName, getStartDate, deadline));
    }

    public void deleteProject(String projectName)
    {
        projectList.removeProject(projectName);
    }

	public void addMemberToProject(String projectName, String memberName, int memberRole)
	{
		// Finds Member from Member List and adds to project
		TeamMember member = teamMemberList.getTeamMember("name", memberName);
		projectList.getProjectByName(projectName).getTeamMemberList().addTeamMember(member);




		// Mangler vi ikke at tilføje en member
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

    public void addRequirement(String projectName, String requirementName, int timeEstimate, int priority)
    {
        //Creating a Requirement
        Requirement requirement = new Requirement(requirementName, timeEstimate, priority);

        projectList.getProjectByName(projectName)
            .getRequirementList().addRequirement(requirement);
    }

    public void removeRequirement(String projectName, String requirementName)
    {
        projectList.getProjectByName(projectName)
            .getRequirementList().removeRequirement(requirementName);
    }

    public void setRequirementPriority(String projectName, String requirementName, int priority){
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName).setPriority(priority);
    }

    public void addTask(String projectName, String requirementName, String taskName, String teamMemberName, int timeEstimateHour, boolean isHighPriority){
        //Creating a task
        Task task = new Task(taskName, teamMemberName, timeEstimateHour, isHighPriority);

        //Adding task to list.
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().addTask(task);
    }

    public void editTask(String projectName, String requirementName, String taskName){
        //Getting task by task name
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().getTaskByName(taskName);
            //TODO: Hvordan edited vi igennem den her funktion, skal tilføjes efter sidste getter!
    }

    public void removeTask(String projectName, String requirementName, String taskName)
    {
        projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().removeTask(taskName);
    }

}
