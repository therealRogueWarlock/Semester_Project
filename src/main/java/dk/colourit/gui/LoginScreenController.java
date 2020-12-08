package dk.colourit.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginScreenController extends Controller {


    @Override
    public void init() {

    }

    @Override public void back()
    {

    }

    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        model.selectUserRole(3);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedScrumMasterRole() throws IOException {
        model.selectUserRole(2);
        ColourItGui.setRoot("ProjectListView");
    }

    @FXML
    private void selectedProductOwnerRole() throws IOException {
        model.selectUserRole(1);
        ColourItGui.setRoot("ProjectListViewC");
    }

    @FXML
    private void selectedTeamMemberRole() throws IOException {
        model.selectUserRole(0);
        ColourItGui.setRoot("ProjectListView");
    }

}
