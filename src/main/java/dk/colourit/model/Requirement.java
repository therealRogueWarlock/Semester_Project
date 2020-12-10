package dk.colourit.model;

import java.security.InvalidParameterException;

public class Requirement {

	private TaskList taskList;
	private String name;
	private final MyDate creationDate;
	private int timeEstimate;
	private int priority;
	private String status;
	private String requirementDescription;


	public Requirement(String name, int timeEstimate, int priority) {
		setName(name);
		setTimeEstimate(timeEstimate);
		setPriority(priority);

		creationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();
		requirementDescription = "No Description";

	}

	public Requirement(String name, int timeEstimate, int priority, String requirementDescription) {
		setName(name);
		setTimeEstimate(timeEstimate);
		setPriority(priority);
		setRequirementDescription(requirementDescription);

		creationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();


	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty() || name.isBlank())
			throw new InvalidParameterException("No name found");
		else
			this.name = name;
	}

	public MyDate getCreationDate() {
		return creationDate;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public int getTimeEstimate() {
		return timeEstimate;
	}

	public void setTimeEstimate(int timeEstimate) {
		if (timeEstimate < 0)
			timeEstimate = 0;
		this.timeEstimate = timeEstimate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if (priority < 0)
			priority = 0;
		this.priority = priority;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		if (taskList.getListSize() == 0) return "No Tasks";

		if (!(status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("rejected"))) {
			if (taskList.getListSize() > taskList.getFinishedTasks().size()) return "Not Done";
			else return "Ready for Review";
		}
		return status;
	}

	public String toString() {
		return name;
	}
}

