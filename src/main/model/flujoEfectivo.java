package main.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class flujoEfectivo {

    private final StringProperty fecha = new SimpleStringProperty();
    private final StringProperty tipoFlujo = new SimpleStringProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private final StringProperty idCategoria = new SimpleStringProperty();
    private final DoubleProperty cantidad = new SimpleDoubleProperty();
    private final StringProperty idFlujoEfectivo = new SimpleStringProperty();


    flujoEfectivo(String fecha, String tipoFlujo, String descripcion, Double cantidad,String idCategoria, String idFlujoEfectivo){
        this.fecha.set(fecha);
        this.tipoFlujo.set(tipoFlujo);
        this.descripcion.set(descripcion);
        this.cantidad.set(cantidad);
        this.idCategoria.set(idCategoria);
        this.idFlujoEfectivo.set(idFlujoEfectivo);
    }

    public String getIdFlujoEfectivo() {
        return idFlujoEfectivo.get();
    }

    public StringProperty idFlujoEfectivoProperty() {
        return idFlujoEfectivo;
    }

    public void setIdFlujoEfectivo(String idFlujoEfectivo) {
        this.idFlujoEfectivo.set(idFlujoEfectivo);
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getTipoFlujo() {
        return tipoFlujo.get();
    }

    public StringProperty tipoFlujoProperty() {
        return tipoFlujo;
    }

    public void setTipoFlujo(String tipoFlujo) {
        this.tipoFlujo.set(tipoFlujo);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String getIdCategoria() {
        return idCategoria.get();
    }

    public StringProperty idCategoriaProperty() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria.set(idCategoria);
    }

    public double getCantidad() {
        return cantidad.get();
    }

    public DoubleProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad.set(cantidad);
    }
}
