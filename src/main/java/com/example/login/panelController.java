package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class panelController implements Initializable {
    @FXML
    private TilePane vbox;
    @FXML
    private AnchorPane acpane;

    @FXML
    private Button backBtn;

    @FXML
    void backButton(MouseEvent event) throws IOException {
        duplicate_back_btn(backBtn);

    }
    public static void duplicate_back_btn(Button backBtn) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Image> member = new ArrayList<>(member());
        acpane.setMaxHeight(member.size() * 355);
        vbox.setMaxHeight(member.size() * 355);
        for(int i = 0; i < member.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/login/Activities/samplePanel.fxml"));
            try {
                AnchorPane box = fxmlLoader.load();
                samplePanelController cic = fxmlLoader.getController();
                cic.setImg(member.get(i));
                vbox.getChildren().add(box);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private List<Image> member(){
        // image path need to be full address.
        List<Image> ls = new ArrayList<>();
        Image img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\rizu.png");
        ls.add(img);
        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\zarif.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\faisal.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\raisa.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\khaled.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sara.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sabbir.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\adib.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\ellora.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sevas.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\abdullah.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\maria.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sadiq.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\arik.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\raisul.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sumaiya.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\rashid.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\abrar (2).png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\abrar.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\rubaid.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\iftee.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\saifur.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\nizami.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\rafi.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\humayra.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\nabil.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\alam.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\rifat.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\aunindya.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\porag.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sakif.png");
        ls.add(img);


        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\mayeesha.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\maisha.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\sifat.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\shoyeb.png");
        ls.add(img);

        img = new Image("E:\\project\\ClubCognita\\src\\main\\resources\\com\\example\\login\\MCC\\reffah.png");
        ls.add(img);
        return ls;
    }


}
