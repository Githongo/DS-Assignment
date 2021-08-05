module edu.strathmore.dsassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.strathmore.dsassignment to javafx.fxml;
    exports edu.strathmore.dsassignment;
}