package com.example.login;

import com.example.login.Lattice.DBconnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.*;

public class MAIN extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("userinfo.txt");
        Scanner sc = new Scanner(file);
        FXMLLoader fxmlLoader;
        //appstart=LocalDateTime.now();
        if(!sc.hasNext()) {
            fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Log In");
            stage.setScene(scene);
            //startapptimer();
        }
        else{
            fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Dashborad");
            stage.setScene(scene);

            //startapptimer();
        }
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/PIC/clubcognita.jpg")));
        stage.getIcons().add(icon);
        stage.centerOnScreen();
//        stage.SetOnCloseRequest((WindowEvent event)->{
//            stopapptimer();
//        });
        stage.show();
    }
    private static LocalDateTime appstart;
    //private static long appusage;
    public static void main(String[] args) {
        appstart=LocalDateTime.now();
        DateTimeFormatter pat = DateTimeFormatter.ofPattern("dd HH mm ss");
        String ans = appstart.format(pat);
        int day1, hour, min, sec;
        Scanner sc = new Scanner(ans);
        day1 = sc.nextInt();
        hour = sc.nextInt();
        min = sc.nextInt();
        sec = sc.nextInt();

        int a =hour * 60*60 + min * 60 + sec;
        System.out.println(a + " " + ans);
        //System.out.println(ans);
//        startapptimer();
        launch();
        LocalDateTime appstart1 = LocalDateTime.now();
        DateTimeFormatter pat1 = DateTimeFormatter.ofPattern("dd HH mm ss");
        String ans2=appstart1.format(pat1);
        int day2;
        sc = new Scanner(ans2);
        day2 = sc.nextInt();
        hour = sc.nextInt();
        min = sc.nextInt();
        sec = sc.nextInt();

        int b =hour * 60*60 + min * 60 + sec;
        System.out.println(b + " " + ans2);
        if(day2==day1)
        {
            int res=b-a;
            //System.out.println(shomoy);
            String shomoy=String.valueOf(res);
            List<String>shobdata=new ArrayList<>();
            try {
                Connection connection = DBconnect.getConnect();
                String sql = "SELECT `time` FROM `users` WHERE username='tamal' ";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()) {
                    String columnVal = resultSet.getString("time");
                    //System.out.println(columnVal);
                    String[] parts= columnVal.split("\\s+");
                    System.out.println(parts.length);
                    Collections.addAll(shobdata, parts);
                }
                System.out.println("size"+shobdata.size());
                for(int i=0;i<shobdata.size();i++)
                {
                    System.out.println(shobdata.get(i));
                }

                if(!Objects.equals(shobdata.get(day1), "0"))
                {
                    int adding= Integer.parseInt(shobdata.get(day1));
                    res+=adding;
                    shomoy= String.valueOf(res);
                    shobdata.set(day1,shomoy);
                }
               /* String dhukbe = String.join(" ",shobdata);
                String query="INSERT INTO users(time,username)  VALUES(?,'tamal')";
                PreparedStatement preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,dhukbe);
                preparedStatement.executeUpdate();*/
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        else
        {
            int res1=24*60*60-a;
            String prev= String.valueOf(res1);
            int res2=b;
            String next=String.valueOf(res2);
            List<String>shobdata=new ArrayList<>();
            try {
                Connection connection=DBconnect.getConnect();
                String sql = "SELECT `time` FROM `users` WHERE username='tamal' ";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()) {
                    String columnVal = resultSet.getString("time");
                    //System.out.println(columnVal);
                    String[] parts= columnVal.split("\\s+");
                    System.out.println(parts.length);
                    for(int i=0;i< parts.length-1;i++)
                    {
                        shobdata.add(parts[i]);
                    }
                    /*for(int i=0;i<shobdata.size();i++)
                    {
                        System.out.println(shobdata.get(i));
                    }*/
                    System.out.println(shobdata.size());
                }
                if(!Objects.equals(shobdata.get(day1), "0"))
                {
                    int adding= Integer.parseInt(shobdata.get(day1));
                    res1+=adding;
                    prev= String.valueOf(res1);
                    shobdata.set(day1,prev);
                }
                if(!Objects.equals(shobdata.get(day2), "0"))
                {
                    int adding= Integer.parseInt(shobdata.get(day1));
                    res2+=adding;
                    next= String.valueOf(res1);
                    shobdata.set(day2,next);
                }
                String dhukbe = String.join(" ",shobdata);
                String query="INSERT INTO users(time,username) VALUES(?,'tamal')";
                PreparedStatement preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,dhukbe);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
//    private static Timer Apptimer=new Timer();
//    private static void startapptimer() {
//        Apptimer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
                //Duration duration = Duration.between(appstart, LocalDateTime.now());
//                appusage = duration.getSeconds();
//            }
//        }, 1000, 1000);
//    }
//    private void stopapptimer()
//    {
//        Apptimer.cancel();
//        Apptimer.purge();
//        storeAppUsage(appusage);
//    }
    private void storeAppUsage(long usedsecs)
    {
//        String Seconds=new String();
//        Seconds=Long.toString(usedsecs);
//        try {
//            Connection connection= DBconnect.getConnect();
//            String query="INSERT OR REPLACE "
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

}
