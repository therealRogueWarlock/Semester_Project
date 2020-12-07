package dk.colourit.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginScreenController extends Controller {


    @Override
    public void init() {

    }


    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        ColourItGui.setRoot("primary");
    }

    @FXML
    private void selectedScrumMasterRole() throws IOException {
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedTeamMemberRole() throws IOException {
        ColourItGui.setRoot("projectListView");
    }

    @FXML
    private void selectedProductOwnerRole() throws IOException {
        ColourItGui.setRoot("projectListView");
    }

}
