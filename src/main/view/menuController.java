package main.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import main.model.Categoria;
import main.model.Conexion;
import main.model.flujoEfectivo;
import main.model.indicadorDinero;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class menuController implements Initializable
{

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
    private ComboBox<String> cbxClasificacion;
    @FXML
    private TableView<Categoria> listaCategoria;

    @FXML
    private TableColumn<Categoria, String> colClasificacion;

    @FXML
    private TableColumn<Categoria, String> colCategoria;

    @FXML
    private TableColumn<Categoria, String> colSubCat;

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
    private TableView<flujoEfectivo> tablaEfectivo;

    @FXML
    private TableColumn<flujoEfectivo, String> colFecha;

    @FXML
    private TableColumn<flujoEfectivo, String> colDesEfectivo;

    @FXML
        private TableColumn<flujoEfectivo, String> colCatEfectivo;

    @FXML
    private TableColumn<flujoEfectivo, String> colSubEfectivo;

    @FXML
    private TextField txtsemanaCuentas;
    @FXML
    private TextField txtsemanaBancos;



    @FXML
    private TextField SubCFlujoD;

    @FXML
    private TextField desFlujoD;

    @FXML
    private ComboBox<Categoria> comboCategoria;

    @FXML
    private TextField cantidadFlujoDinero;

    @FXML
    private TextField NumSemana;



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

    //variables
    String selecioncomboClasificacion;
    String selecioncomboCategoria;


    @FXML
    private Button guardarBancos;

    ObservableList<Categoria> categoriaObservableList = FXCollections.observableArrayList();
    ObservableList<flujoEfectivo> efectivoObservableList = FXCollections.observableArrayList();
    ObservableList<indicadorDinero> dineroObservableList = FXCollections.observableArrayList();


//Control Vistas//
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
        peticiongetCategorias();
        uploadComboClasificacion();
        menuCategoria.setVisible(true);
    }

    public void peticiongetCategorias(){
        Conexion conexion = new Conexion();
        categoriaObservableList = conexion.getCAtegoria();
        listaCategoria.setItems(categoriaObservableList);
        colClasificacion.setCellValueFactory(cellData -> cellData.getValue().clasificacionProperty());
        colCategoria.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        colSubCat.setCellValueFactory(cellData -> cellData.getValue().subcategoriaProperty());
    }



    public void uploadComboClasificacion(){
        ObservableList<String> items = FXCollections.observableArrayList("GAO","Ingreso","Costo-Venta");
        cbxClasificacion.setItems(items);
        cbxClasificacion.valueProperty().addListener((observableValue, s, t1) -> {
           selecioncomboClasificacion = t1;
        });
    }

    //flujo de efectivo
    @FXML
    void iniciarFlujo(ActionEvent event) {
      uploadComboCategoria();
      peticionGetFlujoEfectivo();
        menuEfectivo.setVisible(true);
    }

    public void peticionGetFlujoEfectivo(){
        Conexion conexion = new Conexion();
        efectivoObservableList = conexion.getFlujoEfectivo();
        tablaEfectivo.setItems(efectivoObservableList);
        colFecha.setCellValueFactory(celldata -> celldata.getValue().fechaProperty());
        colDesEfectivo.setCellValueFactory(celldata -> celldata.getValue().descripcionProperty());
        colCatEfectivo.setCellValueFactory(celldata -> celldata.getValue().getCategoria().categoriaProperty());
        colSubEfectivo.setCellValueFactory(celldata -> celldata.getValue().getCategoria().subcategoriaProperty());
    }


    //combo
    public void uploadComboCategoria(){
        ObservableList<Categoria> items;
        Conexion conexion = new Conexion();
        items = conexion.getCAtegoria();
        comboCategoria.setItems(items);
        comboCategoria.setConverter(new StringConverter<Categoria>() {
            @Override
            public String toString(Categoria categoria) {
                return categoria.getCategoria();
            }

            @Override
            public Categoria fromString(String s) {
                return null;
            }
        });

        comboCategoria.valueProperty().addListener((observableValue, categoria1, t1) -> {
            selecioncomboCategoria = t1.getId();
        });
    };


    public void guardarFlujoEfectivo(){
        System.out.println("entro aqui");
        if(desFlujoD.getText().length() > 0 && selecioncomboCategoria.length() > 0 && cantidadFlujoDinero.getText().length()>0 && NumSemana.getText().length()>0){
            System.out.println("ala aqui");
            Date fecha = new Date();
            String strDateFormat = "dd/MM/yyyy";
            SimpleDateFormat objfecha = new SimpleDateFormat(strDateFormat);
            String fechanow = objfecha.format(fecha);
            if(btnEntradaDinero.isSelected() == true){
                System.out.println("botones");
                peticionCrearFlujoEfectivo("entrada",fechanow);
            }else if (btnSalidaDinero.isSelected() == true){
                peticionCrearFlujoEfectivo("salida",fechanow);
            }
        }else{
            System.out.println("no se completo los campos");
        }

    }
   public void peticionCrearFlujoEfectivo(String tipo, String fecha){
       Conexion conexion = new Conexion();
       conexion.createFlujoEfectivo(tipo,fecha,selecioncomboCategoria,desFlujoD.getText(),Double.parseDouble(cantidadFlujoDinero.getText()),NumSemana.getText());
       peticionGetFlujoEfectivo();
    }



    @FXML
    void iniciarIndicador(ActionEvent event) {
        vistaUnoIndicadores.setVisible(true);
    }
    public void peticionPostIndicadorCuentas(String check, String nSemana, String razonsocial, Double monto){
        if(check.length()> 0&& nSemana.length()>0 && razonsocial.length()>0 && monto.toString().length()>0){
            Conexion conexion = new Conexion();
            Date fechaw = new Date();
            String strDateFormat = "dd/MM/yyyy";
            SimpleDateFormat objfecha = new SimpleDateFormat(strDateFormat);
            String fechanoww = objfecha.format(fechaw);
            conexion.crearInidcador(check,nSemana,razonsocial,monto,fechanoww);
        }

    }

    public void guardarCuenta(){
        if(cuentasPagar.isSelected() == true ){
            peticionPostIndicadorCuentas("pagar", txtsemanaCuentas.getText(),razonSocialCuenta.getText(),Double.valueOf(montoCuenta.getText()));
        }else if(cuentaCobrar.isSelected() == true){
            peticionPostIndicadorCuentas("cobrar", txtsemanaCuentas.getText(),razonSocialCuenta.getText(),Double.valueOf(montoCuenta.getText()));
        }
    }

    public void guardarBanco(){
        if (txtsemanaBancos.getText().length()>0 && descripcionBanco.getText().length()>0 && montoBanco.getText().length()>0){
            Conexion conexion = new Conexion();
            Date fecha = new Date();
            String strDateFormat = "dd/MM/yyyy";
            SimpleDateFormat objfecha = new SimpleDateFormat(strDateFormat);
            String fechanow = objfecha.format(fecha);
            conexion.crearInidcador("banco", txtsemanaBancos.getText(),descripcionBanco.getText(),Double.valueOf(montoBanco.getText()),fechanow);
        }
    }

    @FXML
    void llamarRegistroDeInformacion(ActionEvent event) {
        informacionIndicadoresDinero.setVisible(true);
    }

    @FXML
    void llamarReportes(ActionEvent event) {

    }

    @FXML
    public void cerrarApp()
    {
        Platform.exit();
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void guardarCategoria(){
       if(selecioncomboClasificacion.length() > 0 && catSeleccionada.getText().length() > 0 && subCatSeleccionada.getText().length()>0){
           System.out.println("creo la categoria");
           Conexion conexion = new Conexion();
           conexion.crearCategoria(selecioncomboClasificacion, catSeleccionada.getText(),subCatSeleccionada.getText());
       }
    }






}
