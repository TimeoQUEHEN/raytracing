module com.example.lanceurderayons {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.lanceurderayons to javafx.fxml;
    exports com.example.lanceurderayons;
}