module dk.colourit {
    requires javafx.controls;
    requires javafx.fxml;

    opens dk.colourit.gui to javafx.fxml;
    opens dk.colourit.model to javafx.base;

    exports dk.colourit.gui;
    exports dk.colourit.mediator;
    exports dk.colourit.model;

}