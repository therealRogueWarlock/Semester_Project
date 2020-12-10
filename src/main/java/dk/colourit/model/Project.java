package dk.colourit.model;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class Project {

	private String name;
	private MyDate creationDate;
	private MyDate startDate;
	private MyDate deadLine;
	private MyDate endDate;
	private double status; // TODO: Forklar denne til Andreas

	private RequirementList requirementList;
	private TeamMemberList teamMemberList;

	// Throws second Error and not the First error when all fields are blank | ???
	public Project(String name, MyDate startDate, MyDate deadLine) {
		this.creationDate = MyDate.now( );
		this.endDate = null;
		status = 0;
		requirementList = new RequirementList( );
		teamMemberList = new TeamMemberList( );

		if ( name.isEmpty( ) || name.isBlank( ) ) {
			throw new MissingFormatArgumentException("Empty Name Field");
		} else {
			this.name = name;
		}
		if ( startDate.isBefore(creationDate) || deadLine.isBefore(creationDate) || deadLine.isBefore(startDate) ) {
			throw new DateTimeException("Invalid Date");
		} else {
			this.startDate = startDate;
			this.deadLine = deadLine;
		}
	}

	public int getTotalTime( ) {
		int time = 0;
		for ( Requirement req : requirementList.getRequirements( ) ) {
			for ( Task task : req.getTaskList( ).getTasks( ) ) {
				time += task.getTotalTimeSpent( );
			}
		}
		return time;
	}

	public String getStatus( ) {
		ArrayList<Requirement> requirements = requirementList.getRequirements( );

		int totalRequirements = requirements.size( );

		int finishedRequirement = 0;

		for ( Requirement requirement : requirements ) {
			if ( requirement.getStatus( ).equals("Finished") )
				finishedRequirement++;
		}

		return finishedRequirement + " / " + totalRequirements + " requirements finished";
		// TODO: Lege projekt - Skal fungere ordentligt! (Andreas er nysgerrig på hvad der menes)
	}

	public String getName( ) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getStartDate( ) {
		return startDate;
	}

	public MyDate getDeadLine( ) {
		return deadLine;
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
		this.endDate = MyDate.now( );
	}
}


