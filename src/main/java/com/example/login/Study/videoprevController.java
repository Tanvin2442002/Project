package com.example.login.Study;

import com.example.login.Lattice.HelloApplication;
import com.example.login.MAIN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class videoprevController implements Initializable {

    @FXML
    private Button OJbtn;

    @FXML
    private Button activities;

    @FXML
    private Button buttonRanking;

    @FXML
    private MediaView media;

    @FXML
    private Button pause;

    @FXML
    private Button play;

    @FXML
    private Button dash;

    @FXML
    void activitiesBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) activities.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Activities/panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
        mediaPlayer.pause();
    }

    @FXML
    void latticeline(MouseEvent event) throws IOException {
        Stage stage = (Stage) OJbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/login/Lattice/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        mediaPlayer.pause();
    }


    @FXML
    void ranking(MouseEvent event) throws IOException {

        Stage stage = (Stage) buttonRanking.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Ranking/individualRanking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
        mediaPlayer.pause();
    }


    @FXML
    void dashboardBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) dash.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
        mediaPlayer.pause();
    }


    @FXML
    Button logout;
    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
        mediaPlayer.pause();
    }



    private File file;
    private Media mda;
    private MediaPlayer mediaPlayer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file = new File("src/main/resources/com/example/login/Video/demo.mp4");
        mda = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(mda);
        media.setMediaPlayer(mediaPlayer);
        pause.setVisible(false);
        play.setVisible(true);

    }
    @FXML
    void pauseBtn(MouseEvent event) {
        mediaPlayer.pause();
        pause.setVisible(false);
        play.setVisible(true);
    }
    @FXML
    void playBtn(MouseEvent event) {
        mediaPlayer.play();
        play.setVisible(false);
        pause.setVisible(true);
    }


}
