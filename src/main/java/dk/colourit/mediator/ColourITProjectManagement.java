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

		String[] names = {"Sander", "Andreas", "Seb", "Marker", "Crimmer", "Peter"};

		projectList.addProject(new Project("project1", MyDate.now(), new MyDate(12, 12, 2021)));
		projectList.addProject(new Project("project2", MyDate.now(), new MyDate(12, 1, 2023)));
		projectList.addProject(new Project("project3", MyDate.now(), new MyDate(1, 12, 2024)));
		projectList.addProject(new Project("project4", MyDate.now(), new MyDate(12, 1, 2025)));
		projectList.addProject(new Project("project5", MyDate.now(), new MyDate(12, 1, 2026)));
		projectList.addProject(new Project("project6", MyDate.now(), new MyDate(1, 12, 2027)));

		for (int i = 0; i < projectList.getProjects().size(); i++)
		{
			Project project = projectList.getProjects().get(i);

			int j = 0;

			for (String name : names)
			{

				project.getRequirementList().addRequirement(new Requirement(("requirement" + j), 10 + j, j));

				Requirement requirement = project.getRequirementList().getRequirementByName(("requirement" + j));

				for (int k = 0; k < 5; k++)
				{
					Task randomTask = new Task(("randomTask" + k), names[k], 10 + k, (k % 2 == 0));

					requirement.getTaskList().addTask(randomTask);
				}

                /*
                Task task = requirement.getTaskList()
                    .getTaskByName(("randomTask" + j));

                for (int l = 0; l <5 ; l++) {
                    task.getDocumentations().add(new Documentation(names[l], 10 + l, MyDate.now()));
                }*/

				j++;
			}

		}
	}

	public void selectUserRole(int role)
	{
		userRole = role;
	}

	public int getUserRole()
	{
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
		// TODO: add validation logic to projectList.addProject
		projectList.addProject(new Project(projectName, getStartDate, deadline));
	}

	public void deleteProject(String projectName)
	{
		projectList.removeProject(projectName);
	}

	public void addEmployee(String name, int employeeNumber, MyDate birthday)
	{

		teamMemberList.addTeamMember(new TeamMember(name, employeeNumber, birthday));

	}

	public void addMemberToProject(Project project, String memberName, int memberRole)
	{
		// Finds Member from Member List and adds to project

		TeamMember member = teamMemberList.getTeamMember("name", memberName);

		project.getTeamMemberList().addTeamMember(member);

		// Mangler vi ikke at tilføje en member
		project.getTeamMemberList().
			getTeamMember("name", memberName).setRole(memberRole);
        /*
        Hvad med setRole, er dette nødvendigt når man laver den?
         */
	}

    /*
    public void removeMemberFromProject(String projectName, String memberName)
    {
        projectList.getProjectByName(projectName).getTeamMemberList()
            .removeTeamMember(memberName);
    }*/

	public void assignRoleToTeamMember(String projectName, String memberName, int memberRole)
	{
		projectList.getProjectByName(projectName).getTeamMemberList().getTeamMember("name", memberName)
			.setRole(memberRole);
	}

	public void taskDocumentation(String projectName, String requirementName, String taskName, int hours, MyDate date,
		String memberName)
	{
        /*projectList.getProjectByName(projectName)
            .getRequirementList().getRequirementByName(requirementName)
            .getTaskList().getTaskByName(taskName).////.getDocumentation

         */
		//Vi skal vidst lave en Documentation method i vores Task, så vi kan komme ned i den.
		//TODO:Mangler documentation method i Task

		Documentation documentation = new Documentation(teamMemberList.getTeamMember("name", memberName), hours, date);
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.getTaskList().getTaskByName(taskName).setDocumentation(documentation);
	}

	public void finishTask(String projectName, String requirementName, String taskName, boolean trueFalse)
	{
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.getTaskList().getTaskByName(taskName).setFinito(trueFalse);
	}

	public void setRequirementStatus(String projectName, String requirementName, int status)
	{
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.setStatus(status);
        /*
        All choices are via GUI
        Status via ComboBox, with selection of following:
        0 = notDone
        1 = readyForApproval
        2 = rejected
        3 = finished
        */
	}

	public void addRequirement(Project project, String requirementName, int timeEstimate, int priority)
	{
		//Creating a Requirement
		Requirement requirement = new Requirement(requirementName, timeEstimate, priority);

		project.getRequirementList().addRequirement(requirement);

	}

	public void removeRequirement(String projectName, String requirementName)
	{
		projectList.getProjectByName(projectName).getRequirementList().removeRequirement(requirementName);
	}

	public void setRequirementPriority(String projectName, String requirementName, int priority)
	{
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.setPriority(priority);
	}

	public void addTask(String projectName, String requirementName, String taskName, String teamMemberName,
		int timeEstimateHour, boolean isHighPriority)
	{
		//Creating a task
		Task task = new Task(taskName, teamMemberName, timeEstimateHour, isHighPriority);

		//Adding task to list.
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.getTaskList().addTask(task);
	}

	public void editTask(String projectName, String requirementName, String taskName)
	{
		//Getting task by task name
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.getTaskList().getTaskByName(taskName);
		//TODO: Hvordan edited vi igennem den her funktion, skal tilføjes efter sidste getter!
	}

	public void removeTask(String projectName, String requirementName, String taskName)
	{
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
			.getTaskList().removeTask(taskName);
	}

}
