package dk.colourit.model;

public class Project {

	private String name;

	private MyDate creationDate;

	private MyDate startDate;

	private MyDate deadLine;

	private MyDate endDate;

	private RequirementList requirementList;

	private TeamMemberList teamMemberList;


	public Project(String name, MyDate startDate, MyDate deadLine) {
		this.creationDate = MyDate.now();
		this.endDate = null;

		this.name = name;
		this.startDate = startDate;
		this.deadLine = deadLine;

		requirementList = new RequirementList();
		teamMemberList = new TeamMemberList();

	}

	public TeamMemberList getTeamMemberList() {
		return teamMemberList;
	}

	public String getName() {
		return name;
	}

	public MyDate getStartDate() {
		return startDate;
	}

	public MyDate getDeadLine() {
		return deadLine;
	}


	public void setRequirementList(RequirementList requirementList) {
		this.requirementList = requirementList;
	}

	public RequirementList getRequirementList() {
		return requirementList;
	}

	public void setTeamMemberList(TeamMemberList teamMemberList) {
		this.teamMemberList = teamMemberList;
	}


}


