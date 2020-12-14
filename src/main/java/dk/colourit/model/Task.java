package dk.colourit.model;

import dk.colourit.gui.ColourItGui;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {

    private final MyDate taskCreationDate;
    private final ArrayList<Documentation> documentations;
    private String taskName;
    private String taskResponsible;
    private int taskTimeEstimate;
    private boolean highPriority;
    private int totalTimeSpent;
    private String taskDescription;
    private boolean finito;
    private final int id;

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
        id = generateId();
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

    public void setFinito(boolean arg) {
        finito = arg;
    }

    public String getTaskStatus() {
        if (finito)
            return "Finished";
        else
            return "Not Finished";
    }

    public boolean isHighPriority() {
        return highPriority;
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
            totalTimeSpent += documentation.getTimeSpentDocumentation();
        }
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(int totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public ArrayList<Documentation> getDocumentations() {
        return documentations;
    }

    public void setDocumentation(Documentation documentation) {
        documentations.add(documentation);
    }

    public MyDate getTaskCreationDate() {
        return taskCreationDate;
    }

    private int generateId() {
        return (int) Math.floor(Math.random() * 1000000);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" + "name='" + taskName + '\'' + ", responsible='" + taskResponsible + '\'' + ", timeEstimateHour="
                + taskTimeEstimate + ", highPriority=" + highPriority + ", totalTimeSpent=" + totalTimeSpent + '}';
    }
}
