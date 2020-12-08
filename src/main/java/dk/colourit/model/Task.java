package dk.colourit.model;

import java.util.ArrayList;

public class Task {

    private String name;
    private String responsible;
    private MyDate creationDate;
    private int timeEstimateHour;
    private String description;
    private boolean finito;
    private ArrayList<Documentation> documentations;


    public Task(String name, String teamMemberName, int timeEstimateHour) {

        documentations = new ArrayList<>();

        this.name = name;
        this.timeEstimateHour = timeEstimateHour;
        responsible = teamMemberName;

        // initialise default values.
        creationDate = MyDate.now();
        description = "";
        finito = false;
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

}
