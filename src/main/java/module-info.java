module dk.colourit {
    requires javafx.controls;
    requires javafx.fxml;
    requires XmlJsonParser;
    requires java.sql;

    opens dk.colourit.model to javafx.base, XmlJsonParser;
    opens dk.colourit.gui to javafx.fxml;

    exports dk.colourit.gui;
    exports dk.colourit.mediator;
    exports dk.colourit.model;
}