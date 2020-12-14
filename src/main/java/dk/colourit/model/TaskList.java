package dk.colourit.model;

import dk.colourit.gui.ColourItGui;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {

    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Task> getFinishedTasks() {
        ArrayList<Task> finishedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isFinito()) {
                finishedTasks.add(task);
            }
        }
        return finishedTasks;
    }

    public int getListSize() {
        return tasks.size();
    }

    public ArrayList<Task> getHighPriority() {
        ArrayList<Task> returnArray = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isHighPriority()) {
                returnArray.add(task);
            }
        }

        return returnArray;
    }

    public ArrayList<Task> getLowPriority() {
        ArrayList<Task> returnArray = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isHighPriority()) {
                returnArray.add(task);
            }
        }

        return returnArray;
    }

    public Task getTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(name)) {
                return task;
            }
        }
        return null;
    }

    public int getEstimatedTime() {
        int time = 0;
        for (Task task : tasks) {
            time += task.getTaskTimeEstimate();
        }
        return time;
    }

    public void addTask(Task task) {
            tasks.add(task);
        if (ColourItGui.getModel().getSelectedRequirement().getRequirementTimeEstimate() < ColourItGui.getModel().getSelectedRequirement().getTaskList().getEstimatedTime())
            ColourItGui.getModel().getSelectedRequirement().setRequirementTimeEstimate(    ColourItGui.getModel().getSelectedRequirement().getTaskList().getEstimatedTime());
    }

    public void removeTask(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                tasks.remove(task);
                break;
            }
        }
    }
}
