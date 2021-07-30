package main.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Semana {

    private SimpleIntegerProperty semana = new SimpleIntegerProperty();
    private SimpleDoubleProperty monto = new SimpleDoubleProperty();

    public Semana(Integer semana, Double monto){
        this.semana.set(semana);
        this.monto.set(monto);
    }

    public int getSemana() {
        return semana.get();
    }

    public SimpleIntegerProperty semanaProperty() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana.set(semana);
    }

    public double getMonto() {
        return monto.get();
    }

    public SimpleDoubleProperty montoProperty() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto.set(monto);
    }
}
