package main.view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btnIniciar;

    @FXML
    void btnIniciarCash(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCash.fxml"));
            Parent root = null;
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Finanzas");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}