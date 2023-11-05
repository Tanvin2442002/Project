package com.example.login;

import com.example.login.Lattice.DBconnect;
import com.example.login.Lattice.HelloApplication;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DashboardController implements Initializable {

    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;


    @FXML
    private AnchorPane menubar;

    @FXML
    private PieChart pie;

    @FXML
    private ProgressBar prog;

    @FXML
    private Button buttonRanking;

    @FXML
    private Button activities;

    @FXML
    private Label intro;

    @FXML
    private Button OJbtn;
    @FXML
    private AnchorPane certificate;

    @FXML
    private AnchorPane completed;
    @FXML
    private AnchorPane pendingCourse;
    @FXML
    private AnchorPane standing;
    @FXML
    private AnchorPane watchtime;


    @FXML
    void latticeline(MouseEvent event) throws IOException {
        Stage stage = (Stage) OJbtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/login/Lattice/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1520, 780);
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
    private Button study;

    @FXML
    void studyBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) study.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/study.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
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
    }

    @FXML
    void certificateBtn(MouseEvent event) throws IOException {
//        Stage stage = (Stage) certificate.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource(""));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Ranking");
//        stage.setScene(scene);
//        stage.centerOnScreen();
    }

    @FXML
    void completedBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) completed.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/study.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void pendingCourseBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) pendingCourse.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/study.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void standingBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) standing.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Ranking/individualRanking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void watchtimeBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/Study/study.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ranking");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    private StackedAreaChart area;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String>datalagbe=new ArrayList<>();
        try {
         Connection connection= DBconnect.getConnect();
         String user = null;
            String sqlquery="SELECT * FROM `users` WHERE `username`='tamal'";
           PreparedStatement preparedStatement=connection.prepareStatement(sqlquery);
          ResultSet resultSet=preparedStatement.executeQuery();
          if(resultSet.next()) {
              String columnVal = resultSet.getString("time");
              user=resultSet.getString("username");
              String[] parts = columnVal.split("\\s+");
              datalagbe.addAll(Arrays.asList(parts));
          }
//          final NumberAxis xAxis=new NumberAxis(1,15,1);
//          final NumberAxis yAxis=new NumberAxis(1,24,1);
            XYChart.Series<Number,Number>fifteendays=new XYChart.Series<Number,Number>();
            LocalDateTime KAHINI=LocalDateTime.now();
            DateTimeFormatter pat = DateTimeFormatter.ofPattern("dd HH mm ss");
            int day1, hour, min, sec;
            String ans = KAHINI.format(pat);
            Scanner sc = new Scanner(ans);
            System.out.println(ans);
            day1 = sc.nextInt();
            hour = sc.nextInt();
            min = sc.nextInt();
            sec = sc.nextInt();
            for(int i=0;i<datalagbe.size();i++)
            {
                System.out.println(datalagbe.get(i));
            }
            System.out.println(datalagbe.get(day1));
            fifteendays.setName("Activity of User for Last 15 days");
            for(int i=1;i<16;i++)
            {
                int x=Integer.parseInt(datalagbe.get(day1));
                System.out.print(x+" ");
                fifteendays.getData().add(new XYChart.Data<>(16-i, x));
                System.out.print(day1);
                System.out.println("\n");
                day1--;
                if(day1==0)day1=31;
            }
            System.out.println(user);
//            fifteendays.setName("Activity Of Last 15 Days");
//            fifteendays.getData().add(new XYChart.Data<>(0,0));
//            fifteendays.getData().add(new XYChart.Data<>(1,3));
//            fifteendays.getData().add(new XYChart.Data<>(2,7));
//            fifteendays.getData().add(new XYChart.Data<>(3,4.7));
//            fifteendays.getData().add(new XYChart.Data<>(4,3));
//            fifteendays.getData().add(new XYChart.Data<>(5,7));
//            fifteendays.getData().add(new XYChart.Data<>(6,4.7));
//            fifteendays.getData().add(new XYChart.Data<>(7,3));
//            fifteendays.getData().add(new XYChart.Data<>(8,7));
//            fifteendays.getData().add(new XYChart.Data<>(9,4.7));
//            fifteendays.getData().add(new XYChart.Data<>(10,3));
//            fifteendays.getData().add(new XYChart.Data<>(11,7));
//            fifteendays.getData().add(new XYChart.Data<>(12,4.7));
//            fifteendays.getData().add(new XYChart.Data<>(13,7));
//            fifteendays.getData().add(new XYChart.Data<>(14,4.7));
//            fifteendays.getData().add(new XYChart.Data<>(15,3));
//            fifteendays.getData().add(new XYChart.Data<>(16,0));
//            area.getXAxis();
//            area.getYAxis();
              area.getData().add(fifteendays);
//            System.out.println(area);
              pie.setData(dataofpie());
            Font labelFont = Font.font("Georgia", FontWeight.BOLD, 21);
            if(hour>4 && hour<12)
            {
                String greet="Good Morning,";
                greet+=user;
                greet+="!";
                intro.setText(greet);
                intro.setFont(labelFont);
            } else if (hour>12 && hour<4) {
                String greet="Good Afternoon,";
                greet+=user;
                greet+="!";
                intro.setText(greet);
                intro.setFont(labelFont);
            } else if (hour>4 && hour<7) {
                String greet="Good Evening,";
                greet+=user;
                greet+="!";
                intro.setText(greet);
                intro.setFont(labelFont);
            }
            else
            {
                String greet="Welcome Back,";
                greet+=user;
                greet+="!";
                intro.setText(greet);
                intro.setFont(labelFont);
            }
        } catch (SQLException e) {
      throw new RuntimeException(e);
        }
    }
    private ObservableList<PieChart.Data>dataofpie()
    {
        ObservableList<PieChart.Data>notun= FXCollections.observableArrayList();
        notun.add(new PieChart.Data("I",40));
        notun.add(new PieChart.Data("C",30));
        notun.add(new PieChart.Data("P",30));
        return notun;
    }

}
