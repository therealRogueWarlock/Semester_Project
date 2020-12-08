package dk.colourit.model;

public class Requirement {

	private TaskList taskList; //TODO: Skal dette ikke være en TaskList<Task>? - SBT
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
		this.name = name;
		this.timeEstimate = timeEstimate;
		this.priority = priority;

		creationDate = MyDate.now();
		status = 0;
		taskList = new TaskList();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getCreationDate() {
		return creationDate;
	}

	public int getTimeEstimate() {
		return timeEstimate;
	}

	public void setTimeEstimate(int timeEstimate) {
		this.timeEstimate = timeEstimate;
	}

	public int getPriority(){
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	//TODO: Hvad bruges denne til? - SBT (Mangler i UML)
	public TaskList getTaskList() {
		return taskList;
	}

	public String getStatus() {
		switch (status){
			case 0:{
				return "Not done";
			}
			case 1:{
				return "Ready for revive";
			}
			case 2:{
				return  "Done";
			}
		}

		return null;
	}
}

