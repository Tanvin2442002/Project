package com.example.login.Study;

import com.example.login.MAIN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class sampleStudyController {

    @FXML
    private Label mainTopic;

    @FXML
    private Label subTopic;

    @FXML
    private Button video;
    @FXML
    private ImageView image;
    public String mntopic;

    public void setData(String mn, String sb){
        mainTopic.setText(mn);
        mntopic = mn;
        subTopic.setText(sb);
    }

    @FXML
    void videoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) video.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/videopreveiw.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(mntopic);
        stage.setScene(scene);
    }

}
