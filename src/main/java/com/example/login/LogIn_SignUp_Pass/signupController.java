package com.example.login.LogIn_SignUp_Pass;

import com.example.login.MAIN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class signupController implements Initializable {

    @FXML
    private ChoiceBox<String> UserDeparment;

    @FXML
    private TextField Email;

    @FXML
    private TextField fullName;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField retypePassword;

    @FXML
    private TextField stdID;

    @FXML
    private TextField username;

    @FXML
    private Label passnotmatch;

    public String[] Dept = { "Civil Engineering", "Computer Science and Engineering",
                "Electrical, Electronics and Communication Engineering", "Mechanical Engineering",
            "Aeronautical Engineering","Biomedical Engineering", "Nuclear Science and Engineering",
            "Architecture", "Environmental, Water Resources and Coastal Engineering",
            "Petroleum and Mining Engineering", "Naval Architecture and Marine Engineering",
            "Industrial and Production Engineering"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserDeparment.setValue("Choice Department");
        UserDeparment.getItems().addAll(Dept);
        passnotmatch.setVisible(false);
    }

    @FXML
    void loginBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log In");
        stage.setScene(scene);
    }

    @FXML
    void cngfeild(MouseEvent event) {
        passnotmatch.setVisible(false);
        retypePassword.setVisible(true);
    }
    @FXML
    private Button signUp;
    boolean isNumber(String s){
        System.out.println(s);
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <='9')
                cnt++;
        }
        return cnt == 9;
    }
    @FXML
    void signUpBtn(MouseEvent event) throws IOException {
        String userPass, USERNAME, FULL_NAME, StudentId, EMAIL, Department;
        if(!isNumber(stdID.getText())){
            stdID.setText("Invalid student ID!");
        }else if(username.getText().isEmpty()){
            username.setText("Username can't be empty!");
        }else if(fullName.getText().isEmpty()){
            fullName.setText("Full Name can't be empty!");
        }else if(Email.getText().isEmpty()){
            Email.setText("Email can't be empty!");
        }else if(UserDeparment.getValue().isEmpty()){
            UserDeparment.setValue("Department can't be empty!");
        }
        else if(Objects.equals(password.getText(), retypePassword.getText()) && !password.getText().isEmpty()){
            userPass = password.getText();
            USERNAME = username.getText();
            FULL_NAME = fullName.getText();
            StudentId = stdID.getText();
            EMAIL = Email.getText();
            Department = UserDeparment.getValue();

            Stage stage = (Stage) login.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Log In");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            String mailSub = "Thanks for creating an account in CLUB COGNITA";

            String mailBody = "Dear " + FULL_NAME + ",\n\n\n"+
                    "We are thrilled to welcome you to CLUB COGNITA!" +
                    "Your recent decision to create an account with us has made our day," +
                    "and we wanted to express our heartfelt thanks for choosing to be a part of our community." +
                    "\n\n"+
                    "At CLUB COGNITA, we are committed to providing an exceptional online judge [LatticeLine] and community experience," +
                    "and we believe you've made a fantastic choice in joining us. Your new account opens the door to a world of" +
                    "exciting opportunities, and we can't wait to share them with you."+
                    "\n"+
                    "\n\n"+
                    "Warm regards,\n" +
                    "CLUB COGNITA TEAM\n" +
                    "Yusuf Reza Hasnat\n" +
                    "Syed Mafijul Islam\n" +
                    "Tanvin Sarkar Pallab\n" +
                    "[clubcognita@gmail.com]\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n";

            String mail = EMAIL;
            String user = USERNAME;
            SendMail.sendEmail(mailBody,mailSub,mail,user);
        }
        else{
            retypePassword.setVisible(false);
            passnotmatch.setVisible(true);
            passnotmatch.setText(" Password not matched!");

        }

    }
    //


}
