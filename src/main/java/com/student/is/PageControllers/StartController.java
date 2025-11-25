package com.student.is.PageControllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartController.class.getResource("/com/student/is/fxml/MainLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1280,768);
        stage.setTitle("OBS Giriş Ekranı");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
