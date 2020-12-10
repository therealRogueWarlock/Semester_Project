package dk.colourit.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {

	private String name;
	private String responsible;
	private MyDate creationDate;
	private int timeEstimateHour;
	private boolean highPriority;
	private int totalTimeSpent;
	private String description;
	private boolean finito;
	private ArrayList<Documentation> documentations;

	public Task(String name, int timeEstimateHour, String teamMemberName, boolean highPriority, String description) {
		documentations = new ArrayList<>();

		this.highPriority = highPriority;

		setName(name);
		setTimeEstimateHour(timeEstimateHour);
		responsible = teamMemberName;

		// initialise default values.
		creationDate = MyDate.now();
		setDescription(description);
		finito = false;

		totalTimeSpent = 0;
	}

	public ArrayList<Documentation> getDocumentations() {
		return documentations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String teamMemberName) {
		responsible = teamMemberName;
	}

	public boolean getPriority() {
		return highPriority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String text) {
		description = text;
	}

	public void editTask(String name, int time, String memberName, boolean checked, String taskDescription) {
		setName(name);
		setTimeEstimateHour(time);
		setResponsible(memberName);
		highPriority = checked;
		setDescription(taskDescription);
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

	public int getTimeEstimateHour() {
		return timeEstimateHour;
	}

	private void setTimeEstimateHour(int timeEstimateHour) {
		this.timeEstimateHour = timeEstimateHour;
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
		return "Task{" + "name='" + name + '\'' + ", responsible='" + responsible + '\'' + ", timeEstimateHour="
				+ timeEstimateHour + ", highPriority=" + highPriority + ", totalTimeSpent=" + totalTimeSpent + '}';
	}
}
