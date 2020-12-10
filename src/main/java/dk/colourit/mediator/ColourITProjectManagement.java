package dk.colourit.mediator;

import dk.colourit.model.*;

import java.util.concurrent.ThreadLocalRandom;

public class ColourITProjectManagement {

	private ProjectList projectList;
	private TeamMemberList teamMemberList;
	private ColourItFileHandler colourItFileHandler;
	private int userRole;

	public ColourITProjectManagement() {
		//Dummy Data ??
		projectList = new ProjectList();
		teamMemberList = new TeamMemberList();

		String[] names = {"Sander", "Andreas", "Seb", "Marker", "Crimmer", "Peter"};

		projectList.addProject(new Project("project1", MyDate.now(), new MyDate(12, 12, 2021)));
		projectList.addProject(new Project("project2", MyDate.now(), new MyDate(12, 1, 2023)));
		projectList.addProject(new Project("project3", MyDate.now(), new MyDate(1, 12, 2024)));
		projectList.addProject(new Project("project4", MyDate.now(), new MyDate(12, 1, 2025)));
		projectList.addProject(new Project("project5", MyDate.now(), new MyDate(12, 1, 2026)));
		projectList.addProject(new Project("project6", MyDate.now(), new MyDate(1, 12, 2027)));


		teamMemberList.addTeamMember(new TeamMember("Sander", 16233, MyDate.now()));
		teamMemberList.addTeamMember(new TeamMember("john", 12833, MyDate.now()));
		teamMemberList.addTeamMember(new TeamMember("seb", 12333, MyDate.now()));
		teamMemberList.addTeamMember(new TeamMember("pølle", 12833, MyDate.now()));
		teamMemberList.addTeamMember(new TeamMember("marker", 12303, MyDate.now()));
		teamMemberList.addTeamMember(new TeamMember("johnbob", 12133, MyDate.now()));


		for (int i = 0; i < projectList.getProjects().size(); i++) {
			Project project = projectList.getProjects().get(i);

			int j = 0;

			for (String name : names) {

				project.getRequirementList().addRequirement(new Requirement(("requirement" + j), 10 + j, j));

				Requirement requirement = project.getRequirementList().getRequirementByName(("requirement" + j));


				requirement.setStatus("Not Done");

				for (int k = 0; k < 5; k++) {
					Task randomTask = new Task(("randomTask" + k), 10 + k, names[k], (k % 2 == 0), "Gay person: " + names[k]);

					//requirement.getTaskList().addTask(randomTask);
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
		//Dummy data ??
	}

	public void selectUserRole(int role) {
		userRole = role;
	}

	public int getUserRole() {
		return userRole;
	}

	public ProjectList getProjectList() {
		return projectList;
	}

	public TeamMemberList getTeamMemberList() {
		return teamMemberList;
	}

	public void createProject(String projectName, MyDate getStartDate, MyDate deadline) {
		projectList.addProject(new Project(projectName, getStartDate, deadline));
	}

	public void deleteProject(Project project) {
		projectList.removeProject(project);
	}

	public void addEmployee(String name, int employeeNumber, MyDate birthday) {

		teamMemberList.addTeamMember(new TeamMember(name, employeeNumber, birthday));

	}

	public void addMemberToProject(Project project, TeamMember teamMember, String memberRole) {

		teamMember.setRole(memberRole);
		project.getTeamMemberList().addTeamMember(teamMember);

	}

	public void assignRoleToTeamMember(String projectName, String memberName, String memberRole) {
		projectList.getProjectByName(projectName).getTeamMemberList().getTeamMember("name", memberName)
				.setRole(memberRole);
	}

	public void taskDocumentation(String projectName, String requirementName, String taskName, int hours, MyDate date,
								  String memberName) {
		Documentation documentation = new Documentation(teamMemberList.getTeamMember("name", memberName), hours, date);
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.getTaskList().getTaskByName(taskName).setDocumentation(documentation);
	}

	public void finishTask(String projectName, String requirementName, String taskName, boolean trueFalse) {
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.getTaskList().getTaskByName(taskName).setFinito(trueFalse);
	}

	public void setRequirementStatus(String projectName, String requirementName, String status) {
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.setStatus(status);
	}

	public void addRequirement(Project project, String requirementName, int timeEstimate, int priority) {
		//Creating a Requirement
		Requirement requirement = new Requirement(requirementName, timeEstimate, priority);

		project.getRequirementList().addRequirement(requirement);

	}

	public void removeRequirement(String projectName, String requirementName) {
		projectList.getProjectByName(projectName).getRequirementList().removeRequirement(requirementName);
	}

	public void setRequirementPriority(String projectName, String requirementName, int priority) {
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.setPriority(priority);
	}

	public void addTask(String projectName, String requirementName, String taskName, String teamMemberName,
						int timeEstimateHour, boolean isHighPriority, String taskDesc) {
		//Creating a task
		Task task = new Task(taskName, timeEstimateHour, teamMemberName, isHighPriority, taskDesc);

		//Adding task to list.
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.getTaskList().addTask(task);
	}

	public void editTask(String projectName, String requirementName, String taskName) {
		// Getting task by task name
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.getTaskList().getTaskByName(taskName);
	}

	public void removeTask(String projectName, String requirementName, String taskName) {
		projectList.getProjectByName(projectName).getRequirementList().getRequirementByName(requirementName)
				.getTaskList().removeTask(taskName);
	}
}
