package main.model;

public class flujoEfectivo {

    private String fecha;
    private String tipoFlujo;
    private  String descripcion;
    private Double cantidad;
    private String categoria;
    private String idCategoria;

    flujoEfectivo(String fecha, String tipoFlujo, String descripcion, Double cantidad, String categoria, String idCategoria)
    {
        this.fecha=fecha;
        this.tipoFlujo=tipoFlujo;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.categoria=categoria;
        this.idCategoria=idCategoria;
    }
    flujoEfectivo()
    {

    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoFlujo() {
        return tipoFlujo;
    }

    public void setTipoFlujo(String tipoFlujo) {
        this.tipoFlujo = tipoFlujo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
