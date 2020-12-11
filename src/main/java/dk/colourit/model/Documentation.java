package dk.colourit.model;

import java.io.Serializable;

public class Documentation implements Serializable {
	// Depending on time, add a description text. Keep out of Constructor (or add overload constructor)

	private String teamMemberName;
	private int timeSpentDocumentation;
	private MyDate documentationDate;


	public Documentation() {
		teamMemberName = null;
		this.timeSpentDocumentation = 0;
		this.documentationDate = null;

	}

	public String getTeamMemberName() {
		return teamMemberName;
	}

	public Documentation(TeamMember member, int timeSpentDocumentation, MyDate date) {
		teamMemberName = member.getMemberName();
		this.timeSpentDocumentation = timeSpentDocumentation;
		this.documentationDate = date;
	}

	public int getTimeSpentDocumentation() {
		return timeSpentDocumentation;
	}

	public MyDate getDocumentationDate() {
		return documentationDate;
	}

	public String toString() {
		return "Documentation:" + teamMemberName + " " + documentationDate + " " + timeSpentDocumentation;
	}

}
