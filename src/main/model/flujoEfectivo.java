package main.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class flujoEfectivo {

    private final StringProperty fecha = new SimpleStringProperty();
    private final StringProperty tipoFlujo = new SimpleStringProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private  Categoria categoria;
    private final DoubleProperty cantidad = new SimpleDoubleProperty();
    private final StringProperty idFlujoEfectivo = new SimpleStringProperty();
    private final StringProperty numeroSemana = new SimpleStringProperty();

    //numeroSemana


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    flujoEfectivo(String fecha, String tipoFlujo, String descripcion, Double cantidad, Categoria categoria, String idFlujoEfectivo, String numeroSemana){
        this.fecha.set(fecha);
        this.tipoFlujo.set(tipoFlujo);
        this.descripcion.set(descripcion);
        this.cantidad.set(cantidad);
        this.categoria = categoria;
        this.idFlujoEfectivo.set(idFlujoEfectivo);
        this.numeroSemana.set(numeroSemana);
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


    public double getCantidad() {
        return cantidad.get();
    }

    public DoubleProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad.set(cantidad);
    }

    public String getNumeroSemana() {
        return numeroSemana.get();
    }

    public StringProperty numeroSemanaProperty() {
        return numeroSemana;
    }

    public void setNumeroSemana(String numeroSemana) {
        this.numeroSemana.set(numeroSemana);
    }
}
