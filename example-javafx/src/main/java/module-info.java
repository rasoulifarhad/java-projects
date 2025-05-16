module com.farhad.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.farhad.example.javafx to javafx.fxml;
    exports com.farhad.example.javafx;
}
