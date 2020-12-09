package dk.colourit.model;

public class Project
{

	private String name;
	private MyDate creationDate;
	private MyDate startDate;
	private MyDate deadLine;
	private MyDate endDate;

	private RequirementList requirementList;
	private TeamMemberList teamMemberList;

	public Project(String name, MyDate startDate, MyDate deadLine)
	{
		this.creationDate = MyDate.now();
		this.endDate = null;

		this.name = name;
		this.startDate = startDate;
		this.deadLine = deadLine;

		requirementList = new RequirementList();
		teamMemberList = new TeamMemberList();
	}

	public String getName()
	{
		return name;
	}

	public MyDate getStartDate()
	{
		return startDate;
	}

	public MyDate getDeadLine()
	{
		return deadLine;
	}

	public void setRequirementList(RequirementList requirementList)
	{
		this.requirementList = requirementList;
		//TODO: Hvad bruges denne funktion til? - SBT - (Tror jeg har forstået det, men stadig lige forklares tak)
	}

	public RequirementList getRequirementList()
	{
		return requirementList;
	}

	public void setTeamMemberList(TeamMemberList teamMemberList)
	{
		this.teamMemberList = teamMemberList;
		//TODO: Hvad bruges denne funktion til? - SBT - (Tror jeg har forstået det, men stadig lige forklares tak)
	}

	public TeamMemberList getTeamMemberList()
	{
		return teamMemberList;
	}

	public void setEndDate(MyDate endDate)
	{
		this.endDate = endDate;
		//TODO: endDate = MyDate.now(); - Hvad med dette, når vi færdiggøre projektet via en knap i GUI?
	}

}


