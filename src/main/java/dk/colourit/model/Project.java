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
	public Project( String name, MyDate startDate, MyDate deadLine ) {
		this.creationDate = MyDate.now( );
		this.endDate = null;
		status = 0;
		requirementList = new RequirementList( );
		teamMemberList = new TeamMemberList( );

		if ( name.isEmpty( ) || name.isBlank( ) ) {
			throw new MissingFormatArgumentException( "Empty Name Field" );
		} else {
			this.name = name;
		}
		if ( startDate.isBefore( creationDate ) || deadLine.isBefore( creationDate ) || deadLine.isBefore( startDate ) ) {
			throw new DateTimeException( "Invalid Date" );
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
		double procentFinished;

		for ( Requirement requirement : requirements ) {
			if ( requirement.getStatus( ).equals( "Finished" ) )
				finishedRequirement++;
		}

		procentFinished = ( (double) finishedRequirement / totalRequirements ) * 100;

		return finishedRequirement + "/" + totalRequirements + " requirements finished";
		//TODO:Lege projekt - Skal fungere ordentligt!
	}

	public String getName( ) {
		return name;
	}

	public MyDate getStartDate( ) {
		return startDate;
	}

	public MyDate getDeadLine( ) {
		return deadLine;
	}

	public void setRequirementList( RequirementList requirementList ) {
		this.requirementList = requirementList;
		//TODO: Hvad bruges denne funktion til? - SBT - (Tror jeg har forstået det, men stadig lige forklares tak)
	}

	public RequirementList getRequirementList( ) {
		return requirementList;
	}

	public void setTeamMemberList( TeamMemberList teamMemberList ) {
		this.teamMemberList = teamMemberList;
		//TODO: Hvad bruges denne funktion til? - SBT - (Tror jeg har forstået det, men stadig lige forklares tak)
	}

	public TeamMemberList getTeamMemberList( ) {
		return teamMemberList;
	}

	public void setEndDate( ) {
		this.endDate = MyDate.now( );
		//TODO: Når alle Requirements er done, så skal denne kaldes af ProjectController.init()
	}

}


