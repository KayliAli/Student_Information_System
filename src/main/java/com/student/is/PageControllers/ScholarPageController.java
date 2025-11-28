package com.student.is.PageControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScholarPageController {

    public  void exitButtonAction(ActionEvent event) throws IOException,IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/student/is/fxml/Welcome.fxml"));
        Parent root = loader.load();
        Scene oncekiSahne = new Scene(root);

        Node source = (Node) event.getSource();
        Stage mevcutStage = (Stage) source.getScene().getWindow();

        mevcutStage.setScene(oncekiSahne);
        mevcutStage.show();

    }
    public void ScholarMainBackButtonAction(ActionEvent event) throws IOException,IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/student/is/fxml/ScholarMainPage.fxml"));
        Parent root = loader.load();
        Scene oncekiSahne = new Scene(root);

        Node source = (Node) event.getSource();
        Stage mevcutStage = (Stage) source.getScene().getWindow();

        mevcutStage.setScene(oncekiSahne);
        mevcutStage.show();
    }
    public void AbsenceProceduresButtonAction(ActionEvent event) throws IOException,IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/ScholarAbsenteeism.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void GradeOperationsButtonAction(ActionEvent event) throws IOException,IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/student/is/fxml/ScholarGradeOperations.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
