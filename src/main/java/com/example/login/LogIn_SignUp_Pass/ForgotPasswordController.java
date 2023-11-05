package com.example.login.LogIn_SignUp_Pass;

import com.example.login.MAIN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


public class ForgotPasswordController {

    @FXML
    private Button LogIn;

    @FXML
    private TextField getmail;

    @FXML
    private Button SendOTP;

    @FXML
    void ButtonLogIn(MouseEvent event) throws IOException {
        Stage stage = (Stage) LogIn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    Random rand = new Random();
    public int randomCode;

    void callRand() throws IOException {
        randomCode = rand.nextInt(999999);
        FileWriter fileWriter = new FileWriter("randomNum.txt");
        fileWriter.write(Integer.toString(randomCode));
        fileWriter.close();
    }

    @FXML
    void ButtonOTP(MouseEvent event) throws IOException {
        String mail = getmail.getText();
        if(!Objects.equals(mail, "")) {
            callRand();
            String body = "Your reset code is " + randomCode;
            String subject = "Reset your password!";
//            System.out.println(mail);
//            System.out.println(randomCode);
            SendMail.sendEmail(body, subject, mail, "Not_created_yet");

            Stage stage = (Stage) SendOTP.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MAIN.class.getResource("/com/example/login/LogIn_SignUp_Pass/OTPmatching.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("OTP");
            stage.setScene(scene);
            stage.centerOnScreen();
        }
        else{
            getmail.setText("Please enter your gmail.");
        }
    }



}
