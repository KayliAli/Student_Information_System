package com.student.is.PageControllers;

import com.student.is.Authentication.Authentication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    Authentication authentication = new Authentication();

    @FXML
    public void backButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/student/is/fxml/MainLogin.fxml"));
        Parent root = loader.load();
        Scene oncekiSahne = new Scene(root);

        Node source = (Node) event.getSource();
        Stage mevcutStage = (Stage) source.getScene().getWindow();

        mevcutStage.setScene(oncekiSahne);
        mevcutStage.show();

    }

    @FXML
    public void studentLoginButton(ActionEvent event)throws IOException {
        System.out.println("Öğrenci giriş butonuna tıklandı!");
        Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/StudentLogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void personLoginButton(ActionEvent event)throws IOException {
        System.out.println("akademisyen giris butonuna basıldı");
        Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/PersonelLogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public TextField studentLogin;
    public TextField studentPassword;

    public void studentPage(ActionEvent event)throws IOException {
        String numarasi = studentLogin.getText();
        String sifre = studentPassword.getText();
        Boolean kontrol= authentication.checkStudentAuth(numarasi,sifre);
        if(kontrol==true) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/StudentMainPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            System.out.println("Hatalı kullanıcı adı veya şifre!!");
        }
        studentPassword.clear();
        studentLogin.clear();

    }
    @FXML
    public TextField personelLogin;
    public TextField personelPassword;

    public void personPage(ActionEvent event)throws IOException {
        String login = personelLogin.getText();
        String sifre = personelPassword.getText();
        Boolean kontrol= authentication.checkPersonnelAuth(login,sifre);
        if(kontrol==true) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/PersonelMainPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else{
            System.out.println("Hatalı kullanıcı adı veya şifre!!");
        }
        personelLogin.clear();
        personelPassword.clear();


    }
    public void forgotPasswordButton(ActionEvent event)throws IOException {

    }


}
