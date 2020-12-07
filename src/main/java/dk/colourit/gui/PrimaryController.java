package dk.colourit.gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

	public Button primaryButton;
	public Button loginButton1;

	@FXML
    private void switchToSecondary() throws IOException {
        ColourItGui.setRoot("secondary");
    }

    @FXML
    private void switchToLogin() throws IOException {
        ColourItGui.setRoot("loginScreen");
    }


}
