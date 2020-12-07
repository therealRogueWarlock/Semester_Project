package dk.colourit.mediator;

import dk.colourit.model.ColourItFileHandler;
import dk.colourit.model.MyDate;
import dk.colourit.model.ProjectList;
import dk.colourit.model.TeamMemberList;

public class ColourITProjectManagement
{

	private ProjectList projectList;

	private TeamMemberList teamMemberList;

	private ColourItFileHandler colourItFileHandler;

	public ColourITProjectManagement()
	{

	}

	public void selectUserRole()
	{

	}

	public void createProject()
	{

	}

	public void deleteProject(String projectName)
	{

	}

	public void addMemberToProject(String projectName, String memberName,
		int memberRole)
	{

	}

	public void removeMemberFromProject(String projectName, String memberName)
	{

	}

	public void assignRoleToTeamMember(String projectName, String memberName,
		String memberRole)
	{

	}

	public void taskDocumentation(String projectName, String requirementName,
		String taskName, int hours, MyDate date, String memberName)
	{

	}

	public void finishTask(String taskName)
	{

	}

	public void setRequirementReady(String requirementName, boolean ready)
	{

	}

	public void setRequirementApproval(String requirementName, boolean approval)
	{

	}

	public void addRequirement(String requirementName)
	{

	}

	public void removeRequirement(String requirementName)
	{

	}

	public void setRequirementPriority(String requirementName, int priority)
	{

	}

	public void addTask(String taskName)
	{

	}

	public void editTask(String taskName)
	{

	}

	public void removeTask(int taskName)
	{

	}

}
