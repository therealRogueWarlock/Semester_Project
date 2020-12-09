package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;

import java.io.IOException;

public abstract class Controller
{

    protected static ColourITProjectManagement model;

    protected Controller(){

    }

    public void setModel(ColourITProjectManagement model)
    {
        this.model = model;
    }

    public ColourITProjectManagement getModel()
    {
        return model;
    }

    public void loginScreen() throws IOException
    {
        ColourItGui.setRoot("loginScreen");
    }

    public abstract void init();

    public abstract void goBack() throws IOException;




}
