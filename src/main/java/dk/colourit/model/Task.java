package dk.colourit.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {

	private String taskName;
	private String taskResponsible;
	private MyDate taskCreationDate;
	private int taskTimeEstimate;
	private boolean highPriority;
	private int totalTimeSpent;
	private String taskDescription;
	private boolean finito;
	private ArrayList<Documentation> documentations;

	public Task(String taskName, int timeEstimateHour, String teamMemberName, boolean highPriority, String taskDescription) {
		documentations = new ArrayList<>();

		this.highPriority = highPriority;

		setTaskName(taskName);
		setTaskTimeEstimate(timeEstimateHour);
		taskResponsible = teamMemberName;

		// initialise default values.
		taskCreationDate = MyDate.now();
		setTaskDescription(taskDescription);
		finito = false;

		totalTimeSpent = 0;
	}

	public ArrayList<Documentation> getDocumentations() {
		return documentations;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskResponsible() {
		return taskResponsible;
	}

	public void setTaskResponsible(String teamMemberName) {
		taskResponsible = teamMemberName;
	}

	public boolean getPriority() {
		return highPriority;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String text) {
		taskDescription = text;
	}

	public void editTask(String name, int time, String memberName, boolean checked, String taskDescription) {
		setTaskName(name);
		setTaskTimeEstimate(time);
		setTaskResponsible(memberName);
		highPriority = checked;
		setTaskDescription(taskDescription);
	}

	public boolean isFinito() {
		return finito;
	}

	public String getStatus() {
		if (finito)
			return "Finished";
		else
			return "Not Finished";
	}

	public void setFinito(boolean arg) {
		finito = arg;
	}

	public boolean isHighPriority() {
		return highPriority;
	}

	public void setTotalTimeSpent(int totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

	public int getTaskTimeEstimate() {
		return taskTimeEstimate;
	}

	private void setTaskTimeEstimate(int taskTimeEstimate) {
		this.taskTimeEstimate = taskTimeEstimate;
	}

	public int getTotalTimeSpent() {
		totalTimeSpent = 0;
		for (Documentation documentation : documentations) {
			totalTimeSpent += documentation.getTimeSpent();
		}
		return totalTimeSpent;
	}

	public void setDocumentation(Documentation documentation) {
		documentations.add(documentation);
	}


	@Override
	public String toString() {
		return "Task{" + "name='" + taskName + '\'' + ", responsible='" + taskResponsible + '\'' + ", timeEstimateHour="
				+ taskTimeEstimate + ", highPriority=" + highPriority + ", totalTimeSpent=" + totalTimeSpent + '}';
	}
}
