package main.model;

public class Categoria {

    private String id;
    private String clasificacion;
    private String categoria;
    private String subcategoria;

    Categoria(String id, String clasificacion, String categoria, String subcategoria)
    {
        this.id=id;
        this.clasificacion=clasificacion;
        this.categoria=categoria;
        this.subcategoria=subcategoria;
    }

    Categoria()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}
