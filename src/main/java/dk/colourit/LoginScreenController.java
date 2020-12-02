package dk.colourit;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginScreenController {
    @FXML
    private void selectedProjectCreatorRole() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void selectedScrumMasterRole() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void selectedTeamMemberRole() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void selectedProductOwnerRole() throws IOException {
        App.setRoot("primary");
    }
}
