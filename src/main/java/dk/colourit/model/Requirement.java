package dk.colourit.model;

public class Requirement {

	private String name;
	private final MyDate creationDate;
	private int timeEstimate;
	private int priority;
	private TaskList taskList;
	private int status;


	public Requirement(String name, int timeEstimate, int priority) {
		creationDate = MyDate.now();
		status = 0;

		this.name = name;
		this.timeEstimate = timeEstimate;
		this.priority = priority;
		taskList = new TaskList();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getTimeEstimate() {
		return timeEstimate;
	}

	public void setTimeEstimate(int timeEstimate) {
		this.timeEstimate = timeEstimate;
	}

	public int isHighPriority(){
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public TaskList getTaskList() {
		return taskList;
	}

}

