package com.example.login;

import com.example.login.Study.sampleStudyController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class studyController implements Initializable {

    @FXML
    private TilePane tilepane;
    String  topic, subtopic;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("Topic.txt"));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i % 2 == 0) {
                    topic = line;
                } else {
                    subtopic = line;
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/com/example/login/Study/sampleStudy.fxml"));
                    AnchorPane box = fxmlLoader.load();
                    sampleStudyController temp = fxmlLoader.getController();
                    temp.setData(topic, subtopic);
                    tilepane.getChildren().add(box);
                }
                i++;
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private Button OJbtn;

    @FXML
    private Button activities;

    @FXML
    private Button buttonRanking;

    @FXML
    private Button dashboard;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane menubar;

    @FXML
    void activitiesBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) activities.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Activities/panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void dashboardBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) dashboard.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void latticeline(MouseEvent event) throws IOException {
        Stage stage = (Stage) OJbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Lattice/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void ranking(MouseEvent event) throws IOException {
        Stage stage = (Stage) buttonRanking.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Ranking/individualRanking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
