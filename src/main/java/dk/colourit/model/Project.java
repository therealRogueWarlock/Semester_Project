package dk.colourit.model;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class Project implements Serializable {

	private String projectName;
	private MyDate projectCreationDate;
	private MyDate projectStartDate;
	private MyDate projectDeadline;
	private MyDate projectEndDate;
	//private double status; // TODO: Forklar denne til Andreas - Kan vi få den over i vores parser uden dette?

	private RequirementList requirementList;
	private TeamMemberList teamMemberList;

	// Throws second Error and not the First error when all fields are blank | ???
	public Project(String projectName, MyDate projectStartDate, MyDate projectDeadline) {
		this.projectCreationDate = MyDate.now( );
		this.projectEndDate = null;
		//status = 0;
		requirementList = new RequirementList( );
		teamMemberList = new TeamMemberList( );

		if ( projectName.isEmpty( ) || projectName.isBlank( ) ) {
			throw new MissingFormatArgumentException("Empty Name Field");
		} else {
			this.projectName = projectName;
		}
		if ( projectStartDate.isBefore(projectCreationDate) || projectDeadline.isBefore(projectCreationDate) || projectDeadline.isBefore(projectStartDate) ) {
			throw new DateTimeException("Invalid Date");
		} else {
			this.projectStartDate = projectStartDate;
			this.projectDeadline = projectDeadline;
		}
	}

	public void setProjectStartDate(MyDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public void setProjectDeadline(MyDate projectDeadline) {
		this.projectDeadline = projectDeadline;
	}

	public int getTotalTime( ) {
		int time = 0;
		for ( Requirement req : requirementList.getRequirements( ) ) {
			time += req.getTotalTimeSpent();
		}
		return time;
	}

	public String getProjectStatus( ) {
		ArrayList<Requirement> requirements = requirementList.getRequirements( );

		int totalRequirements = requirements.size( );

		int percentage, finishedRequirement = 0;

		for ( Requirement requirement : requirements ) {
			if ( requirement.getStatus( ).equals("Approved") )
				finishedRequirement++;
		}

		if ( totalRequirements < 1 )
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

	public MyDate getProjectDeadline( ) {
		return projectDeadline;
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
		this.projectEndDate = MyDate.now( );
	}
}


