module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires activation;
    requires java.mail;

    requires com.dlsc.formsfx;
    requires javafx.web;
    requires okhttp3;
    requires okio;
    requires com.google.gson;
    requires javafx.media;
    requires java.scripting;

    opens com.example.login to javafx.fxml;
    exports com.example.login;
    exports com.example.login.LogIn_SignUp_Pass;
    opens com.example.login.LogIn_SignUp_Pass to javafx.fxml;
    exports com.example.login.Ranking;
    opens com.example.login.Ranking to javafx.fxml;
    exports com.example.login.Lattice;
    opens com.example.login.Lattice to javafx.fxml;
    exports com.example.login.Study;
    opens com.example.login.Study to javafx.fxml;
}