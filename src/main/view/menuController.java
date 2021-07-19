package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class menuController {

    @FXML
    private Button btncategoria;

    @FXML
    private Button btnflujo;

    @FXML
    private Button btnindicador;

    @FXML
    private Label lblfinanzas;

    @FXML
    private ImageView flujo;

    @FXML
    private ImageView categoria;

    @FXML
    private AnchorPane menuCategoria;

    @FXML
    private Label lblfinanzas1;

    @FXML
    private Label lblfinanzas11;

    @FXML
    void iniciarCategoria() {
        menuCategoria.setVisible(true);
    }

    @FXML
    void iniciarFlujo() {

    }

    @FXML
    void iniciarIndicador() {

    }

}
