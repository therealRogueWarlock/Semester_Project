package dk.colourit.model;

import java.security.InvalidParameterException;

public class Requirement {

	private TaskList taskList;
	private String name;
	private final MyDate creationDate;
	private int timeEstimate;
	private int priority;
	private int status;
		/*
	0 = notDone
	1 = readyForApproval
	2 = rejected
	3 = finished
	 */

	public Requirement(String name, int timeEstimate, int priority) {
		setName(name);
		setTimeEstimate(timeEstimate);
		setPriority(priority);

		creationDate = MyDate.now();
		status = 0;
		taskList = new TaskList();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()||name.isBlank())
			throw new InvalidParameterException("No name found");
		else
			this.name = name;
	}

	public MyDate getCreationDate() {
		return creationDate;
	}

	public int getTimeEstimate() {
		return timeEstimate;
	}

	public void setTimeEstimate(int timeEstimate) {
		if (timeEstimate<0)
			timeEstimate = 0;
		this.timeEstimate = timeEstimate;
	}

	public int getPriority(){
		return priority;
	}

	public void setPriority(int priority) {
		if (priority<0)
			priority = 0;
		this.priority = priority;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	//TODO: Hvad bruges denne til? - SBT (Mangler i UML)
	public TaskList getTaskList() {
		return taskList;
	}

	public void setStatus(int status)
	{
		this.status = status;
		//Only status between 0 and 3, can be chosen via GUI
	}

	public String getStatus() {
		switch (status){
			case 0:{
				return "Not done";
			}
			case 1:{
				return "Ready for review";
			}
			case 2:{
				return  "Rejected";
			}
			case 3:{
				return  "Finished";
			}
		}

		return null;
	}

	public String toString()
	{
		return name;
	}
}

