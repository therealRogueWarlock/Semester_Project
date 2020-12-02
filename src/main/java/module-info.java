module dk.colourit {
    requires javafx.controls;
    requires javafx.fxml;

    opens dk.colourit.gui to javafx.fxml;
    exports dk.colourit.gui;
}