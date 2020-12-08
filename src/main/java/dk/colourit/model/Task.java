package dk.colourit.model;

import java.util.ArrayList;

public class Task {

    private String name;
    private String responsible;
    private MyDate creationDate;
    private int timeEstimateHour;
    private boolean highPriority;
    private int totalTimeSpent;
    private String description;
    private boolean finito;
    private ArrayList<Documentation> documentations;


    public Task(String name, String teamMemberName, int timeEstimateHour, boolean highPriority) {
        documentations = new ArrayList<>();

        this.highPriority = highPriority;

        this.name = name;
        this.timeEstimateHour = timeEstimateHour;
        responsible = teamMemberName;


        // initialise default values.
        creationDate = MyDate.now();
        description = "";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String text) {
        description = text;
    }

    public boolean isFinito() {
        return finito;
    }

    public void setFinito(boolean arg) {
        finito = arg;
    }

    public boolean isHighPriority(){
        return highPriority;
    }



    public void setTotalTimeSpent(int totalTimeSpent)
    {
        this.totalTimeSpent = totalTimeSpent;
    }

    public int getTimeEstimateHour()
    {
        return timeEstimateHour;
    }


    public int getTotalTimeSpent(){
        totalTimeSpent = 0;
        for (Documentation documentation: documentations){
            totalTimeSpent += documentation.getTimeSpent();
        }
        return totalTimeSpent;
    }

    @Override public String toString()
    {
        return "Task{" + "name='" + name + '\'' + ", responsible='"
            + responsible + '\'' + ", timeEstimateHour=" + timeEstimateHour
            + ", highPriority=" + highPriority + ", totalTimeSpent="
            + totalTimeSpent + '}';
    }
}
