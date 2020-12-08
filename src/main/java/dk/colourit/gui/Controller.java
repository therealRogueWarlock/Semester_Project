package dk.colourit.gui;

import dk.colourit.mediator.ColourITProjectManagement;

import java.io.IOException;

public abstract class Controller
{

    private Object objectHolderForInit;

    protected ColourITProjectManagement model;

    protected Controller(){

    }

    public void setObjectHolderForInit(Object objectHolderForInit)
    {
        this.objectHolderForInit = objectHolderForInit;
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


    public Object getObjectHolderForInit()
    {
        return objectHolderForInit;
    }


}
