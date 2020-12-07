package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;

public abstract class Controller {

    private ColourITProjectManagement model = new ColourITProjectManagement();


    public void setModel(ColourITProjectManagement model){
        this.model = model;
    }

    public ColourITProjectManagement getModel() {
        return model;
    }

    public abstract void init();
}
