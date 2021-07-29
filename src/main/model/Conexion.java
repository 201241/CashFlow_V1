package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.ScatterChart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Conexion {

    private String url= "http://localhost:3005/categoria/getCategorias";
    private StringBuilder response = new StringBuilder();

    public Conexion (){

    }

    public ObservableList<Categoria> getCAtegoria()
    {
        System.out.println("entro aqwui");
        ObservableList<Categoria> listaCategoria = FXCollections.observableArrayList();
        try{
            URL nameUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea;
            while ((linea = rd.readLine())!=null)
            {
                response.append(linea);
            }
            rd.close();
            JSONArray jsonResponse = new JSONArray(response.toString());
            for (int i = 0; i < jsonResponse.length() ; i++) {
                JSONObject objectCategoria = jsonResponse.getJSONObject(i);
                Categoria categoria = new Categoria(objectCategoria.getString("idCategoria"), objectCategoria.getString("clasificacion"), objectCategoria.getString("categoria"), objectCategoria.getString("subCategoria") );
               listaCategoria.add(categoria);
                System.out.println(objectCategoria.getString("idCategoria"));
            }
            return listaCategoria;
        }

        catch(Exception exception){
            System.out.println(exception);
        }
        return listaCategoria;
    }

    public ObservableList<flujoEfectivo> getFlujoEfectivo(){

        System.out.println("datos flujo de efectivo");
        ObservableList<flujoEfectivo> listaFlujoEfectivo = FXCollections.observableArrayList();

        try{
            URL nameUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader ra = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String datos;
            while ((datos = ra.readLine())!=null)
            {
                response.append(datos);
            }
            ra.close();
            JSONArray jsonResponse = new JSONArray(response.toString());
            for (int i = 0; i < jsonResponse.length() ; i++) {
              //  JSONObject objectEfectivo = jsonResponse.getJSONObject(i);
              //  flujoEfectivo efectivo = new flujoEfectivo(objectEfectivo.getString("fecha"),objectEfectivo.getString("tipoFlujo"),objectEfectivo.getString("descripcion"),objectEfectivo.getDouble("cantidad"),objectEfectivo.getString("idCategoria"), objectEfectivo.getString("idFlujoEfectivo"), objectEfectivo.getString("numeroSemana"));
             //   listaFlujoEfectivo.add(efectivo);
            }
            return listaFlujoEfectivo;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return listaFlujoEfectivo;
    }

    public ObservableList<indicadorDinero> getIndicador()
    {
        System.out.println("datos indicadores de dinero");
        ObservableList<indicadorDinero> listaIndicadorDinero = FXCollections.observableArrayList();

        try{
            URL nameUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader ri = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String datosIndicador;
            while ((datosIndicador = ri.readLine())!=null)
            {
                response.append(datosIndicador);
            }
            ri.close();
            JSONArray jsonResponse = new JSONArray(response.toString());
            for (int i = 0; i < jsonResponse.length() ; i++) {
                JSONObject objectIndicador = jsonResponse.getJSONObject(i);
                indicadorDinero dinero = new indicadorDinero(objectIndicador.getString("tipoIndicador"),objectIndicador.getString("numeroSemana"), objectIndicador.getString("razonSocial"), objectIndicador.getDouble("monto"), objectIndicador.getString("idIndicadoresDinero"));
                listaIndicadorDinero.add(dinero);
            }
            return listaIndicadorDinero;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return listaIndicadorDinero;
    }

    public void createFlujoEfectivo(String tipoFlujo,String fecha, String idCategoria, String descripcion, Double cantidad, String numeroSemana){
        JSONObject jsonflujo = new JSONObject();
       try {
           URL nameUrl= new URL(url);
           HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
           connection.setRequestMethod("POST");

       }catch (Exception e){

       }
    }


    public void crearCategoria(String clasificacion, String categoria, String subCategoria){
        JSONObject jsonflujo = new JSONObject();
        jsonflujo.put("clasificacion",clasificacion);
        jsonflujo.put("categoria",categoria);
        jsonflujo.put("subCategoria",subCategoria);

        byte[] body = jsonflujo.toString().getBytes(StandardCharsets.UTF_8);
        try{
            URL nameUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.getOutputStream().write(body);

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            StringBuilder aux = new StringBuilder();
            String linea;
            while ((linea = response.readLine()) != null){
                aux.append(linea);
                System.out.println(linea);
            }
        }catch (Exception e){

        }

    }
}
