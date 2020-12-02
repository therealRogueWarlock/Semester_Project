package dk.colourit.model;

public class Documentation {

	private String teamMemberName;
	private int timeSpent;
	private MyDate date;

	public Documentation(String teamMemberName,int timeSpent, MyDate date) {
		this.teamMemberName = teamMemberName;
		this.timeSpent = timeSpent;
		this.date = date;

	}

	public void setTimeSpent(int hours) {
		this.timeSpent = hours;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	public void setTeamMemberName(String name) {
		teamMemberName = name;
	}

	public String getTeamMemberName() {
		return teamMemberName;
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
