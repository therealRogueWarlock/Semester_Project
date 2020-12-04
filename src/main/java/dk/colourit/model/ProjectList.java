package dk.colourit.model;

import java.util.ArrayList;

public class ProjectList {

	private Project project;

	private ArrayList<Project> projects;


	public ProjectList() {


	}

	public ArrayList getProjects() {
		return projects;
	}


	public void addProject(Project project) {

	}

	public Project getProjectByName(String projectName) {
		for (Project project:projects){
			if (project.getName().equals(projectName)){

				return project;
			}
		}
		return null;
	}


	public ArrayList getProjectsByTeamMember(String name) {
		return null;
	}

	public void removeProject(String projectName) {

	}

}
