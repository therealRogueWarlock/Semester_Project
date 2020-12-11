package dk.colourit.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable {

	private ArrayList<Project> projects;

	public ProjectList() {
		projects = new ArrayList<>();
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public ArrayList<Project> getAllProjects() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}

	public Project getProjectByName(String projectName)
	{
		for (Project project : projects)
		{
			if (project.getProjectName().equalsIgnoreCase(projectName))
			{
				return project;
			}
		}
		return null;
	}


	public ArrayList<Project> getProjectsByTeamMember(String name) {
		ArrayList<Project> returnArray = new ArrayList<>();

		for (Project project : projects)
		{
			if (project.getTeamMemberList().getTeamMember("name", name) != null)
			{

				returnArray.add(project);
			}
		}

		return returnArray;
	}

	public void removeProject(Project project)
	{
		projects.remove(project);
	}



}
