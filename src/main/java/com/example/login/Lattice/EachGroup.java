package com.example.login.Lattice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EachGroup implements Initializable {
    @FXML
    private AnchorPane compilerbtn;

    @FXML
    private AnchorPane groupbtn;

    @FXML
    private WebView webview;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    @FXML
    private Button crtassignbtn;

    @FXML
    private Button membersbtn;

    @FXML
    private HBox teacherbtns;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tilePane.setMaxWidth(Region.USE_PREF_SIZE);
        scrollPane.setFitToWidth(true);
        WebEngine webengine = webview.getEngine();

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Fireworks</title>\n" +
                "    <style>\n" +
                "    \tbody{\n" +
                "    \tbackground:#000;\n" +
                "    \tmargin:0;\n" +
                "    \twidth:100%;\n" +
                "    \toverflow:hidden;\n" +
                "    \t}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "    <canvas></canvas>\n" +
                "\n" +
                "    <script>\n" +
                "        var t = 0;\n" +
                "        var c = document.querySelector(\"canvas\");     \n" +
                "        var $ = c.getContext('2d');\n" +
                "        c.width = window.innerWidth;\n" +
                "        c.height = window.innerHeight;\n" +
                "        $.fillStyle = 'hsla(0,0%,0%,1)';\n" +
                "\n" +
                "        window.addEventListener('resize', function() {\n" +
                "          c.width = window.innerWidth;\n" +
                "          c.height = window.innerHeight;\n" +
                "        }, false);\n" +
                "\n" +
                "        function draw() {\n" +
                "          $.globalCompositeOperation = 'source-over';\n" +
                "          $.fillStyle = 'hsla(0,0%,0%,.1)';\n" +
                "          $.fillRect(0, 0, c.width, c.height);\n" +
                "          var foo, i, j, r;\n" +
                "          foo = Math.sin(t) * 0.1 * Math.PI;\n" +
                "          for (i=0; i<400; ++i) {\n" +
                "            r = 800 * Math.sin(i * foo);\n" +
                "            $.globalCompositeOperation = '';\n" +
                "            $.fillStyle = 'hsla(' + i + 12 + ',100%, 60%,1)';\n" +
                "            $.beginPath();\n" +
                "            $.arc(Math.sin(i) * r + (c.width / 2), \n" +
                "                  Math.cos(i) * r + (c.height / 2), \n" +
                "                  1.5, 0, Math.PI * 2);\n" +
                "            $.fill();\n" +
                "\n" +
                "          }\n" +
                "          t += 0.000005;\n" +
                "          return t %= 2 * Math.PI;\n" +
                "\n" +
                "        };\n" +
                "\n" +
                "        function run() {\n" +
                "          window.requestAnimationFrame(run);\n" +
                "          draw();\n" +
                "        }\n" +
                "        run();\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";

        webengine.loadContent(htmlContent);


        File file = new File("userinfo.txt");
        Scanner usinf = null;
        try {
            usinf = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String usname = usinf.next();
        String username = new String();
        String connect = new String();
        String gpname = "dsa1";
        String groupName = new String();
        String text = new String();
        String code = new String();
        String inputs = new String();
        String assignId = new String();
        String users = new String();
        ArrayList<assignMent> assignments = new ArrayList<>();
        try {
            Connection connection = DBconnect.getConnect();
            String query = "SELECT * FROM `assignment`";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet =  preparedStatement.executeQuery();

            while(resultSet.next()){
                groupName = resultSet.getString("group_name");
                text = resultSet.getString("text");
                code = resultSet.getString("code");
                inputs = resultSet.getString("input");
                assignId = resultSet.getString("assignId");
                users = resultSet.getString("users");
                if(Objects.equals(groupName, gpname)){
                    assignments.add(new assignMent(groupName, text, code, inputs, assignId, users));
                }
            }
            for (assignMent assign : assignments) {
                BorderPane borderPane = new BorderPane();
                Text txt = new Text();
                txt.setText(assign.getAssignId());
                txt.setStyle("-fx-font-size: 30");
//                txt.setWrappingWidth(250);
                borderPane.setId(assign.getAssignId());
                StackPane stackPane = new StackPane();
                stackPane.setOnMouseClicked(e -> {
                    try {
                        FileWriter fileWriter = new FileWriter("assign.txt");
                        fileWriter.write(assign.getAssignId());
                        fileWriter.write("\n");
                        fileWriter.write(assign.getText());
                        fileWriter.write("\n");
                        fileWriter.write(assign.getCode());
                        fileWriter.write("\n");
                        fileWriter.write(assign.getInput());
                        fileWriter.write("\n");
                        fileWriter.write(assign.getUsers());
                        fileWriter.close();
                        Stage stage = (Stage) borderPane.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("assign-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(),1520,780);
                        stage.setTitle("LatticeLine");
                        stage.setScene(scene);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                stackPane.getChildren().add(txt);
                stackPane.setMaxSize(300, 300);
                stackPane.setMinSize(300, 300);
                txt.setTextAlignment(TextAlignment.CENTER);
                txt.wrappingWidthProperty().bind(stackPane.widthProperty());
                txt.setFill(Color.WHITE);
                stackPane.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 2; -fx-border-color: WHITE;");
                BorderPane.setMargin(stackPane, new Insets(20));
                borderPane.setCenter(stackPane);
                borderPane.setMaxSize(320, 320);
                borderPane.setMinSize(320, 320);
                tilePane.getChildren().add(borderPane);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        File fl = new File("isteacher.txt");
        Scanner scT = null;
        try {
            scT = new Scanner(fl);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String fndTch = scT.next();
        if(Objects.equals(fndTch, "teacher")){
            teacherbtns.setVisible(true);
        }
        else{
            teacherbtns.setVisible(false);
        }
    }

    @FXML
    void compiler(MouseEvent event) throws IOException {
        Stage stage = (Stage) compilerbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("compiler-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }
    @FXML
    private AnchorPane problemsbtn;
    @FXML
    void problems(MouseEvent event) throws IOException {
        Stage stage = (Stage) problemsbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }

    @FXML
    void group(MouseEvent event) throws IOException {
        Stage stage = (Stage) groupbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("groups-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }


    @FXML
    void crtassign(MouseEvent event) throws IOException {
        Stage stage = (Stage) crtassignbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crtassign-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }

    @FXML
    void members(MouseEvent event) throws IOException {
        Stage stage = (Stage) membersbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("members-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }

    @FXML
    private Button backbtn;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) backbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("groups-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1520,780);
        stage.setTitle("LatticeLine");
        stage.setScene(scene);
    }

}