package dk.colourit.model;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class Project implements Serializable {

	private final MyDate projectCreationDate;
	private final RequirementList requirementList;
	private String projectName;
	private MyDate projectStartDate;
	private MyDate projectDeadline;
	private MyDate projectEndDate;
	private String projectDescription;
	private TeamMemberList teamMemberList;

	// Throws second Error and not the First error when all fields are blank | ???
	public Project(String projectName, MyDate projectStartDate, MyDate projectDeadline) {
		projectCreationDate = MyDate.now();
		projectEndDate = null;
		projectDescription = "";

		requirementList = new RequirementList();
		teamMemberList = new TeamMemberList();

		if (projectName.isEmpty() || projectName.isBlank()) {
			throw new MissingFormatArgumentException("Empty Name Field");
		} else {
			this.projectName = projectName;
		}
		if (projectStartDate.isBefore(projectCreationDate) || projectDeadline.isBefore(projectCreationDate) || projectDeadline.isBefore(projectStartDate)) {
			throw new DateTimeException("Invalid Date");
		} else {
			this.projectStartDate = projectStartDate;
			this.projectDeadline = projectDeadline;
		}

	}

	public int getTotalTime( ) {
		int time = 0;
		for (Requirement req : requirementList.getRequirements()) {
			time += req.getTotalTimeSpent();
		}
		return time;
	}

	public String getProjectStatus( ) {
		ArrayList<Requirement> requirements = requirementList.getRequirements();

		int totalRequirements = requirements.size();

		int percentage, finishedRequirement = 0;

		for (Requirement requirement : requirements) {
			if (requirement.getStatus().equals("Approved"))
				finishedRequirement++;
		}

		if (totalRequirements < 1)
			percentage = Math.floorDiv(finishedRequirement, 1);
		else
			percentage = Math.floorDiv(100 * finishedRequirement, totalRequirements);
		return percentage + "% Completed";
	}

	public String getProjectName( ) {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public MyDate getProjectStartDate( ) {
		return projectStartDate;
	}

	public void setProjectStartDate(MyDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public MyDate getProjectDeadline( ) {
		return projectDeadline;
	}

	public void setProjectDeadline(MyDate projectDeadline) {
		this.projectDeadline = projectDeadline;
	}

	public RequirementList getRequirementList( ) {
		return requirementList;
	}

	public TeamMemberList getTeamMemberList( ) {
		return teamMemberList;
	}

	public void setTeamMemberList(TeamMemberList teamMemberList) {
		// Used in PopUpController_Project_Create when creating a project to put the local teamMemberList onto the project
		this.teamMemberList = teamMemberList;
	}

	public void setEndDate( ) {
		this.projectEndDate = MyDate.now();
	}
}


