package dk.colourit.model;

import java.io.Serializable;

public class Documentation implements Serializable {
	// Depending on time, add a description text. Keep out of Constructor (or add overload constructor)

	private String teamMemberName;
	private int timeSpent;
	private MyDate date;


	public Documentation() {
		teamMemberName = null;
		this.timeSpent = 0;
		this.date = null;

	}

	public String getTeamMemberName() {
		return teamMemberName;
	}

	public Documentation(TeamMember member, int timeSpent, MyDate date) {
		teamMemberName = member.getMemberName();
		this.timeSpent = timeSpent;
		this.date = date;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public MyDate getDate() {
		return date;
	}

	public String toString() {
		return "Documentation:" + teamMemberName + " " + date + " " + timeSpent;
	}

}
