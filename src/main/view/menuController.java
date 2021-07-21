package main.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> listaCategoria;

    @FXML
    private TableColumn<?, ?> colClasificacion;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colSubCat;

    @FXML
    private Label lblfinanzas11;

    @FXML
    private TextField catSeleccionada;

    @FXML
    private TextField subCatSeleccionada;

    @FXML
    private MenuButton menuClas;

    @FXML
    private MenuItem setGAO;

    @FXML
    private MenuItem setIngreso;

    @FXML
    private MenuItem setCostoVeta;

    @FXML
    private Button guardarCategoria;

    @FXML
    private Button cerrarCategorias;

    @FXML
    private AnchorPane menuEfectivo;

    @FXML
    private Label lblfinanzas12;

    @FXML
    private TableView<?> tablaEfectivo;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colDesEfectivo;

    @FXML
    private TableColumn<?, ?> colCatEfectivo;

    @FXML
    private TableColumn<?, ?> colSubEfectivo;

    @FXML
    private TextField SubCFlujoD;

    @FXML
    private TextField desFlujoD;

    @FXML
    private TextField catFlujoD;

    @FXML
    private TextField cantidadFlujoDinero;

    @FXML
    private DatePicker fecha;

    @FXML
    private Button guardarFlujoEfectivo;

    @FXML
    private Button cerrarEfectivo;

    @FXML
    private RadioButton btnEntradaDinero;

    @FXML
    private RadioButton btnSalidaDinero;

    @FXML
    private AnchorPane vistaUnoIndicadores;

    @FXML
    private Label lblfinanzas121;

    @FXML
    private Button btnRegistroInf;

    @FXML
    private Button btnReportes;

    @FXML
    private Button cerrarIndicadores;

    @FXML
    private AnchorPane informacionIndicadoresDinero;

    @FXML
    private Label lblfinanzas111;

    @FXML
    private TextField montoCuenta;

    @FXML
    private TextField razonSocialCuenta;

    @FXML
    private DatePicker fechaCuenta;

    @FXML
    private RadioButton cuentasPagar;

    @FXML
    private RadioButton cuentaCobrar;

    @FXML
    private Button guardarCuentas;

    @FXML
    private Button cerrarInformacion;

    @FXML
    private TextField montoBanco;

    @FXML
    private TextField descripcionBanco;

    @FXML
    private DatePicker fechaBanco;

    @FXML
    private Button guardarBancos;

    @FXML
    void cerrarCategoria(ActionEvent event) {
        menuCategoria.setVisible(false);
    }

    @FXML
    void cerrarIndicadores(ActionEvent event) {
        vistaUnoIndicadores.setVisible(false);
    }

    @FXML
    void cerrarInformacion(ActionEvent event) {
        informacionIndicadoresDinero.setVisible(false);
    }

    @FXML
    void cerrarMenoEfectivo(ActionEvent event) {
        menuEfectivo.setVisible(false);
    }

    @FXML
    void iniciarCategoria(ActionEvent event) {
        menuCategoria.setVisible(true);
    }

    @FXML
    void iniciarFlujo(ActionEvent event) {
        menuEfectivo.setVisible(true);
    }

    @FXML
    void iniciarIndicador(ActionEvent event) {
        vistaUnoIndicadores.setVisible(true);
    }

    @FXML
    void llamarRegistroDeInformacion(ActionEvent event) {
        informacionIndicadoresDinero.setVisible(true);
    }

    @FXML
    void llamarReportes(ActionEvent event) {

    }

}


