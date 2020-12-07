package dk.colourit.model;

public class Requirement {

	private String name;
	private final MyDate creationDate;
	private int timeEstimate;
	private boolean priority;
	private TaskList taskList;


	public Requirement(String name, int timeEstimate, boolean priority) {
		creationDate = MyDate.now();

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

	public boolean isHighPriority(){
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

}

