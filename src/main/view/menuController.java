package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class menuController {

    @FXML
    private ImageView categoria;
    @FXML
    private ImageView flujo;
    @FXML
    private ImageView indicador;
    @FXML
    private Button btncategoria;
    @FXML
    private Button btnflujo;
    @FXML
    private Button btnindicador;
    @FXML
    private Label lblfinanzas;


    //METODOS PARA CADA BOTÓN
    @FXML
    public void iniciarCategoria()
    {
        ocultar();
    }

    @FXML
    public void iniciarFlujo()
    {
        ocultar();
    }

    @FXML
    public void iniciarIndicador()
    {
        ocultar();
    }

    @FXML
    public void ocultar()
    {
        categoria.setVisible(false);
        flujo.setVisible(false);
        indicador.setVisible(false);
        btncategoria.setVisible(false);
        btnflujo.setVisible(false);
        btnindicador.setVisible(false);
        lblfinanzas.setVisible(false);
    }

}
