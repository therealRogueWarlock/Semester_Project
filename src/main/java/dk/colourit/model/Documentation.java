package dk.colourit.model;

import java.io.Serializable;

public class Documentation implements Serializable {
	// Depending on time, add a description text. Keep out of Constructor (or add overload constructor)
	private final String teamMemberName;
	private final int timeSpentDocumentation;
	private final MyDate documentationDate;

	public Documentation( ) {
		teamMemberName = null;
		this.timeSpentDocumentation = 0;
		this.documentationDate = null;
	}

	public Documentation(TeamMember member, int timeSpentDocumentation, MyDate date) {
		teamMemberName = member.getMemberName();
		this.timeSpentDocumentation = timeSpentDocumentation;
		this.documentationDate = date;
	}

	public String getTeamMemberName( ) {
		return teamMemberName;
	}

	public int getTimeSpentDocumentation( ) {
		return timeSpentDocumentation;
	}

	public MyDate getDocumentationDate( ) {
		return documentationDate;
	}

	public String toString( ) {
		return "Documentation:" + teamMemberName + " " + documentationDate + " " + timeSpentDocumentation;
	}
}
