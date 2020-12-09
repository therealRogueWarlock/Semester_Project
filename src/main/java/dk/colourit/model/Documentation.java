package dk.colourit.model;

public class Documentation {

	private TeamMemberList teamMemberList;
	private int timeSpent;
	private MyDate date;


	public Documentation() {
		teamMemberList = new TeamMemberList();
		this.timeSpent = 0;
		this.date = null;

	}

	public void logTimeSpent(int timeSpent, MyDate date, TeamMember teamMemberName){
		teamMemberList.addTeamMember(teamMemberName);
		this.timeSpent = timeSpent;
		this.date = date;
	}

	public TeamMemberList getTeamMemberList() {
		return teamMemberList;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public MyDate getDate() {
		return date;
	}

	public String toString() {
		return "Documentation:" + teamMemberList + " " + date + " " + timeSpent;
	}

}
