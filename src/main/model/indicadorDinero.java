package main.model;

public class indicadorDinero {

    private String tipoCuenta;
    private String noSemana;
    private String razonSocial;
    private Double monto;
    private String idIndicador;

    indicadorDinero(String tipoCuenta, String noSemana, String razonSocial, Double monto, String idIndicador)
    {
        this.setTipoCuenta(tipoCuenta);
        this.setNoSemana(noSemana);
        this.setRazonSocial(razonSocial);
        this.setMonto(monto);
        this.idIndicador=idIndicador;
    }

    indicadorDinero()
    {

    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNoSemana() {
        return noSemana;
    }

    public void setNoSemana(String noSemana) {
        this.noSemana = noSemana;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
