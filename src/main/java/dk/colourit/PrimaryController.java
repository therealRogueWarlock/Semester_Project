package dk.colourit;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginScreen");
    }
}
