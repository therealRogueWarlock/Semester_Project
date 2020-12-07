package dk.colourit.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginScreenController extends Controller {


    @Override
    public void init() {

    }


    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        model.selectUserRole(3);
        ColourItGui.setRoot("primary");
    }

    @FXML
    private void selectedScrumMasterRole() throws IOException {
        model.selectUserRole(2);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedProductOwnerRole() throws IOException {
        model.selectUserRole(1);
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedTeamMemberRole() throws IOException {
        model.selectUserRole(0);
        ColourItGui.setRoot("projectListView");
    }

}
