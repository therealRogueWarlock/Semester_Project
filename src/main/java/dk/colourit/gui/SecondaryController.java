package dk.colourit.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondaryController {


    @FXML
    private void switchToPrimary() throws IOException {
        ColourItGui.setRoot("primary");
    }

    @FXML
    private void switchToTaskList() throws IOException {
        ColourItGui.setRoot("taskListScene");
    }

    @FXML
    private void switchToAddTeamMember() throws IOException {
        Scene addTeamMemberScene = new Scene(loadFXML("addTeamMemberScene"));
        Stage stage = new Stage();

        stage.setScene(addTeamMemberScene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ColourItGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}