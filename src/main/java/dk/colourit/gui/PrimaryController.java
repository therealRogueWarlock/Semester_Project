package dk.colourit.gui;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {


    @FXML
    private void switchToSecondary() throws IOException {
        ColourItGui.setRoot("secondary");
    }
    @FXML
    private void switchToLogin() throws IOException {
        ColourItGui.setRoot("loginScreen");
    }


}
