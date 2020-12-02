module dk.colourit {
    requires javafx.controls;
    requires javafx.fxml;

    opens dk.colourit to javafx.fxml;
    exports dk.colourit;
}