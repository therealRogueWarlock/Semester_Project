package dk.colourit.mediator;

import dk.colourit.gui.ColourItGui;
import dk.colourit.model.*;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ColourITProjectManagement {

	private ProjectList projectList;
	private TeamMemberList teamMemberList;

	private int userRole;

	private  Project selectedProject;
	private  Requirement selectedRequirement;
	private  Task selectedTask;
	private  Documentation selectedDocumentation;

	public ColourITProjectManagement() {

		projectList = new ProjectList();
		teamMemberList = new TeamMemberList();

		try {
			projectList= ColourItFileHandler.readProjectList();
			teamMemberList = ColourItFileHandler.readTeamMemberList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void saveToFile() {
		try {
			ColourItFileHandler.saveToBinary(projectList);
			ColourItFileHandler.saveToBinary(teamMemberList);
		}catch (IOException e){
			System.out.println(e);
		}
	}

	public void saveToXml(){
		ColourItFileHandler.saveToXML(projectList);
	}


	public Project getSelectedProject( ) {
		return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}

	public Requirement getSelectedRequirement( ) {
		return selectedRequirement;
	}

	public void setSelectedRequirement(Requirement selectedRequirement) {
		this.selectedRequirement = selectedRequirement;
	}

	public Task getSelectedTask( ) {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public  Documentation getSelectedDocumentation( ) {
		return selectedDocumentation;
	}

	public void setSelectedDocumentation(Documentation selectedDocumentation) {
		this.selectedDocumentation = selectedDocumentation;
	}

	public void selectUserRole(int role) {
		userRole = role;
	}

	public int getUserRole() {
		return userRole;
	}

	public String getUseRoleString(){
		switch (userRole){
			case 0: return "Team member";
			case 1: return "Product owner";
			case 2: return "Scrum master";
			case 3: return "Project creator";
		}
		return "";
	}

	public void addProject(Project project) {
		projectList.addProject(project);
	}

	public void deleteProject(Project project) {
		projectList.removeProject(project);
	}

	public void addEmployee(String name, int employeeNumber, MyDate birthday) {
		teamMemberList.addTeamMember(new TeamMember(name, employeeNumber, birthday));
	}

	public ProjectList getProjectList() {
		return projectList;
	}

	public TeamMemberList getTeamMemberList() {
		return teamMemberList;
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
