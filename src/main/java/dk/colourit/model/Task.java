package dk.colourit.model;

import java.util.ArrayList;

public class Task {

    private String name;
    private String responsible;
    private MyDate creationDate;
    private MyDate timeEstimate;
    private String description;
    private boolean finito;
    private ArrayList<Documentation> documentations;


    public Task(String name, String teamMemberName, MyDate timeEstimate) {

        this.name = name;
        this.timeEstimate = timeEstimate;
        responsible = teamMemberName;

        // initialise default values.
        creationDate = MyDate.now();
        description = "";
        finito = false;
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

    public boolean isFinito() {
        return finito;
    }

    public void setDescription(String text) {
        description = text;
    }



}
