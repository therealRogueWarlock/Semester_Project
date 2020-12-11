package dk.colourit.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class Requirement implements Serializable {

	private TaskList taskList;
	private String requirementName;
	private final MyDate creationDate;
	private int timeEstimate;
	private int priority;
	private String status;
	private String requirementDescription;


	public Requirement(String name, int timeEstimate, int priority) {
		setRequirementName(name);
		setTimeEstimate(timeEstimate);
		setPriority(priority);

		creationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();
		requirementDescription = "No Description";

	}

	public Requirement(String name, int timeEstimate, int priority, String requirementDescription) {
		setRequirementName(name);
		setTimeEstimate(timeEstimate);
		setPriority(priority);
		setRequirementDescription(requirementDescription);

		creationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();


	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		if (requirementName.isEmpty() || requirementName.isBlank())
			throw new InvalidParameterException("No name found");
		else
			this.requirementName = requirementName;
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
		return requirementName;
	}
}

