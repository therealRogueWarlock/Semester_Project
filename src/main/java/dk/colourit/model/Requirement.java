package dk.colourit.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class Requirement implements Serializable {

	private final MyDate requirementCreationDate;
	private TaskList taskList;
	private String requirementName;
	private int requirementTimeEstimate;
	private int priority;
	private boolean checked;
	private String status;
	private String requirementDescription;

	public Requirement(String name, int requirementTimeEstimate, int priority) {
		setRequirementName(name);
		setRequirementTimeEstimate(requirementTimeEstimate);
		setPriority(priority);

		checked = false;
		requirementCreationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();
		requirementDescription = "No Description";

	}

	public Requirement(String name, int requirementTimeEstimate, int priority, String requirementDescription) {
		setRequirementName(name);
		setRequirementTimeEstimate(requirementTimeEstimate);
		setPriority(priority);
		setRequirementDescription(requirementDescription);

		requirementCreationDate = MyDate.now();
		status = "Not Done";
		taskList = new TaskList();

	}

	public String getRequirementName( ) {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		if (requirementName.isEmpty() || requirementName.isBlank())
			throw new InvalidParameterException("No name found");
		else
			this.requirementName = requirementName;
	}

	public MyDate getRequirementCreationDate( ) {
		return requirementCreationDate;
	}

	public String getRequirementDescription( ) {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public int getRequirementTimeEstimate( ) {
		return requirementTimeEstimate;
	}

	public void setRequirementTimeEstimate(int requirementTimeEstimate) {
		if (requirementTimeEstimate < 0)
			requirementTimeEstimate = 0;
		this.requirementTimeEstimate = requirementTimeEstimate;
	}

	public int getTotalTimeSpent( ) {
		int totalTime = 0;
		for (Task task : taskList.getTasks()) {
			totalTime += task.getTotalTimeSpent();
		}

		return totalTime;
	}

	public int getPriority( ) {
		return priority;
	}

	public void setPriority(int priority) {
		if (priority < 0)
			priority = 0;
		this.priority = priority;
	}

	public TaskList getTaskList( ) {
		return taskList;
	}

	public String getStatus( ) {
		if (! (status.equalsIgnoreCase("Ready for Review") || (status.equalsIgnoreCase("Rejected") && checked))) {
			if (taskList.getListSize() == 0) return "No Tasks";
			if (! (status.equalsIgnoreCase("Approved"))) {
				if (taskList.getListSize() > taskList.getFinishedTasks().size()) setStatus("Not Done");
				else setStatus("Ready for Review");
			}
			setChecked(true);
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString( ) {
		return requirementName;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

