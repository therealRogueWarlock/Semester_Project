package dk.colourit.gui;

import javafx.fxml.FXML;


import java.io.IOException;

public class LoginScreenController extends Controller {


    @Override
    public void init() {

    }

    @Override public void goBack()
    {

    }

    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        ColourItGui.getModel().selectUserRole(3);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedScrumMasterRole() throws IOException {
        ColourItGui.getModel().selectUserRole(2);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedProductOwnerRole() throws IOException {
        ColourItGui.getModel().selectUserRole(1);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedTeamMemberRole() throws IOException {
        ColourItGui.getModel().selectUserRole(0);
        ColourItGui.setRoot("projectListView");
    }

}
