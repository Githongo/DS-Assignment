module edu.strathmore.dsassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens edu.strathmore.dsassignment to javafx.fxml;
    exports edu.strathmore.dsassignment;
}