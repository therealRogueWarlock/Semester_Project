package dk.colourit.model;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

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

    public int getListSize(){
        return tasks.size();
    }

    public ArrayList<Task> getHighPriority(){
        ArrayList<Task> returnArray = new ArrayList<>();


        for (Task task: tasks){
            if (task.isHighPriority()){
                returnArray.add(task);
            }
        }

        return returnArray;
    }

    public ArrayList<Task> getLowPriority(){
        ArrayList<Task> returnArray = new ArrayList<>();

        for (Task task: tasks){
            if (!task.isHighPriority()){
                returnArray.add(task);
            }
        }

        return returnArray;
    }




    public Task getTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                return task;
            }
        }
        return null;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                tasks.remove(task);
                break;
            }
        }
    }
}
