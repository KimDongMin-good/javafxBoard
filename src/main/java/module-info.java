module kroryi.javafxboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    requires javafx.base;
    requires javafx.swing;


    opens kroryi.javafxboard to javafx.fxml, javafx.base, javafx.graphics;
    opens kroryi.javafxboard.controller to javafx.fxml, javafx.base, javafx.controls;
    opens kroryi.javafxboard.dto to javafx.base;
    opens kroryi.javafxboard.util to javafx.base, javafx.controls, javafx.fxml;
    exports kroryi.javafxboard;
}