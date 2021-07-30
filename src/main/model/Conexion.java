package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Conexion {


    private StringBuilder response = new StringBuilder();

    public Conexion (){

    }

    public ObservableList<Categoria> getCAtegoria() {

         String url= "http://167.172.146.90:3005/categoria/getCategorias";
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
         String urlgetflujo= "http://167.172.146.90:3005/flujoEfectivo/getAllFlujoEfectivo";
        ObservableList<flujoEfectivo> listaFlujoEfectivo = FXCollections.observableArrayList();

        try{
            URL nameUrl= new URL(urlgetflujo);
            HttpURLConnection connection = (HttpURLConnection) nameUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String datos;
            while ((datos = rd.readLine()) !=null ){
                response.append(datos);
            }
            rd.close();
            JSONArray jsonResponse = new JSONArray(response.toString());
            for (int i = 0; i < jsonResponse.length() ; i++) {
                JSONObject objectEfectivo = jsonResponse.getJSONObject(i);
                System.out.println(objectEfectivo.getJSONObject("categorium").getString("clasificacion"));
                String idcategoria = objectEfectivo.getJSONObject("categorium").getString("idCategoria");
                String clasificacion = objectEfectivo.getJSONObject("categorium").getString("clasificacion");
                String categoria = objectEfectivo.getJSONObject("categorium").getString("categoria");
                String subCategoria = objectEfectivo.getJSONObject("categorium").getString("subCategoria");
               Categoria categoriaaux = new Categoria(idcategoria,clasificacion,categoria,subCategoria);
               String idFlujoEfectivo = objectEfectivo.getString("idFlujoEfectivo");
               String tipoFlujo = objectEfectivo.getString("tipoFlujo");
               String fecha = objectEfectivo.getString("fecha");
               String descripcion =objectEfectivo.getString("descripcion");
               Double cantidad = objectEfectivo.getDouble("cantidad");
               String numeroSemana = objectEfectivo.getString("numeroSemana");
                flujoEfectivo efectivo = new flujoEfectivo(fecha,tipoFlujo,descripcion,Double.valueOf(cantidad),categoriaaux,idFlujoEfectivo,numeroSemana);
                listaFlujoEfectivo.add(efectivo);
            }
            return listaFlujoEfectivo;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return listaFlujoEfectivo;
    }

    public ObservableList<indicadorDinero> getIndicador() {
        String urlindicador = "http://167.172.146.90:3005/indicadoresDinero/getIndicadores";
        System.out.println("datos indicadores de dinero");
        ObservableList<indicadorDinero> listaIndicadorDinero = FXCollections.observableArrayList();
        try{
            URL nameUrl= new URL(urlindicador);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String datosIndicador;
            while ((datosIndicador = rd.readLine())!=null)
            {
                response.append(datosIndicador);
            }
            rd.close();
            JSONArray jsonResponse = new JSONArray(response.toString());
            for (int i = 0; i < jsonResponse.length() ; i++) {
                JSONObject objectIndicador = jsonResponse.getJSONObject(i);
                indicadorDinero dinero = new indicadorDinero(objectIndicador.getString("tipoIndicador"),objectIndicador.getString("numeroSemana"), objectIndicador.getString("razonSocial"), objectIndicador.getDouble("monto"), objectIndicador.getString("idIndicadoresDinero"), objectIndicador.getString("fecha"));
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
        String url= "http://167.172.146.90:3005/flujoEfectivo/addFlujoEfectivo";
        JSONObject jsonflujo = new JSONObject();
        String[] arreglofecha = fecha.split("/");
         String mes = "enero";
        switch (arreglofecha[1]){
            case "01" : {mes = "enero";}
            break;
            case "02" : {mes = "febrero";}break;
            case "03" : {mes = "marzo";}break;
            case "04" : {mes = "abril";}break;
            case "05" : {mes = "mayo";}break;
            case "06" : {mes = "junio";}break;
            case "07" : {mes = "julio";}break;
            case "08" : {mes = "agosto";}break;
            case "09" : {mes = "septiembre";}break;
            case "10" : {mes = "octubre";}break;
            case "11" : {mes = "noviembre";}break;
            case "12" : {mes = "diciembre";}break;
        }
        jsonflujo.put("tipoFlujo",tipoFlujo);
       jsonflujo.put("fecha",fecha);
       jsonflujo.put("idCategoria", idCategoria);
        jsonflujo.put("descripcion",descripcion);
        jsonflujo.put("cantidad", Double.valueOf(cantidad));
        jsonflujo.put("numeroSemana", numeroSemana);
        jsonflujo.put("mes", mes);
       try {
           URL nameUrl= new URL(url);
           byte[] body = jsonflujo.toString().getBytes("UTF-8");
           HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
           connection.setRequestMethod("POST");
           connection.setRequestProperty("Accept", "application/json");
           connection.setRequestProperty("Content-Type", "application/json");
           connection.setDoOutput(true);
           connection.getOutputStream().write(body);
           BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
           StringBuilder aux = new StringBuilder();
           String linea;
           while ((linea = response.readLine()) != null){
               aux.append(linea);
               System.out.println(linea);
           }
           response.close();
       }catch (Exception e){

       }
    }

    public void crearInidcador(String tipoIndicador, String numeroSemana, String razonSocial, Double monto,String fecha){
        String urlindicador = "http://167.172.146.90:3005/indicadoresDinero/addIndicadores";
        String[] arreglofecha = fecha.split("/");
        String mes = "enero";
        switch (arreglofecha[1]){
            case "01" : {mes = "enero";}
            break;
            case "02" : {mes = "febrero";}break;
            case "03" : {mes = "marzo";}break;
            case "04" : {mes = "abril";}break;
            case "05" : {mes = "mayo";}break;
            case "06" : {mes = "junio";}break;
            case "07" : {mes = "julio";}break;
            case "08" : {mes = "agosto";}break;
            case "09" : {mes = "septiembre";}break;
            case "10" : {mes = "octubre";}break;
            case "11" : {mes = "noviembre";}break;
            case "12" : {mes = "diciembre";}break;
        }
        JSONObject jsonbody = new JSONObject();
        jsonbody.put("tipoIndicador", tipoIndicador);
        jsonbody.put("numeroSemana",numeroSemana);
        jsonbody.put("razonSocial",razonSocial);
        jsonbody.put("monto", Double.valueOf(monto));
        jsonbody.put("fecha", fecha);
        jsonbody.put("mes",mes);
        try {
            URL nameUrl= new URL(urlindicador);
            byte[] body = jsonbody.toString().getBytes("UTF-8");
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.getOutputStream().write(body);
            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            StringBuilder aux = new StringBuilder();
            String linea;
            while ((linea = response.readLine()) != null){
                aux.append(linea);
                System.out.println(linea);
            }
            response.close();
        }catch (Exception e){

        }
    }
    public void crearCategoria(String clasificacion, String categoria, String subCategoria){
         String url= "http://167.172.146.90:3005/categoria/categoriaAdd";
        JSONObject jsonflujo = new JSONObject();
        jsonflujo.put("clasificacion",clasificacion);
        jsonflujo.put("categoria",categoria);
        jsonflujo.put("subCategoria",subCategoria);
        byte[] body = new byte[0];
        try {
            body = jsonflujo.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try{
            URL nameUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection)nameUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

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
            System.out.println(e);
        }

    }
}
