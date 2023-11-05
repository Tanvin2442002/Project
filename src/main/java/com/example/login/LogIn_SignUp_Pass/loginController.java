package com.example.login.LogIn_SignUp_Pass;

import com.example.login.MAIN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private Button SignUp;

    @FXML
    private AnchorPane screenSize;

    @FXML
    private Label showMsg;

    String username, password, mail;
    ArrayList<Users> users = new ArrayList<Users>();

    @FXML
    void signupBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) SignUp.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/signUp.fxml"));
        Screen screen = Screen.getPrimary();
        // Get the screen height
        double screenHeight = screen.getBounds().getHeight();
        screenSize.setMaxHeight(screenHeight);
        double screenWidth = screen.getBounds().getWidth();
        screenSize.setMaxWidth(screenWidth);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sign Up");
        stage.setScene(scene);
    }
    @FXML
    private Button forgotPass;

    @FXML
    private TextField usname;

    @FXML
    private PasswordField uspasswd;

    @FXML
    void ForgotPassButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) forgotPass.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/forgotPassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Recover password!");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    int flag = 0;
    @FXML
    void login(MouseEvent event) throws IOException {
//        System.out.println("hello\n");
        for (Users user : users) {
            if (Objects.equals(user.username, usname.getText()) || Objects.equals(user.mail, usname.getText())) {
                if (Objects.equals(user.password, uspasswd.getText())) {
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 1){
            Stage stage = (Stage) forgotPass.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Recover password!");
            stage.setScene(scene);
            stage.centerOnScreen();

        }
        else{
            showMsg.setText("Incorrect Username or Password");
        }
    }
    //signUp
    //signUpBtn
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DBconnect.getConnect();
            String query = "SELECT * FROM `users`";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet =  preparedStatement.executeQuery();

            while(resultSet.next()){
                username =resultSet.getString("username");
                password =resultSet.getString("password");
                mail = resultSet.getString("email");
                Users temp = new Users(username, password, mail);
                users.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
