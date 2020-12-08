package dk.colourit.model;

import java.util.ArrayList;

public class ProjectList {

	private ArrayList<Project> projects;

	public ProjectList() {
		projects = new ArrayList<>();
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}


	public void addProject(Project project) {
		projects.add(project);
	}

	public Project getProjectByName(String projectName)
	{
		//TODO: getName = Peter - projectName = pEtER
		for (Project project : projects)
		{
			if (project.getName().equals(projectName))
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

	public void removeProject(String projectName)
	{
		projects.remove(getProjectByName(projectName));
	}

}
