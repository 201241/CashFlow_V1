package main.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Indicadores {
    private SimpleStringProperty razonSocial = new SimpleStringProperty();
    private ArrayList<Semana> arraysemana;

    public  Indicadores( String razonSocial)
    {
        this.razonSocial.set(razonSocial);

    }


    public String getRazonSocial() {
        return razonSocial.get();
    }

    public SimpleStringProperty razonSocialProperty() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial.set(razonSocial);
    }

    public ArrayList<Semana> getArraysemana() {
        return arraysemana;
    }

    public void setArraysemana(ArrayList<Semana> arraysemana) {
        this.arraysemana = arraysemana;
    }

    public ArrayList<Semana> getSemana(){
        return this.arraysemana;
    }
    public void setSemana(ArrayList<Semana> sem){
        this.arraysemana = sem;
    }

}
