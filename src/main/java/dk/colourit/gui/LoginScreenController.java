package dk.colourit.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginScreenController {
    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        ColourItGui.setRoot("primary");
    }
    @FXML
    private void selectedScrumMasterRole() throws IOException {
        ColourItGui.setRoot("primary");
    }
    @FXML
    private void selectedTeamMemberRole() throws IOException {
        ColourItGui.setRoot("primary");
    }
    @FXML
    private void selectedProductOwnerRole() throws IOException {
        ColourItGui.setRoot("primary");
    }

}
