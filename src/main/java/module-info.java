module mutiny.triangletable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens mutiny.triangletable to javafx.fxml;
    exports mutiny.triangletable;
}