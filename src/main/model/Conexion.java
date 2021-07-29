package main.model;

import javafx.scene.chart.ScatterChart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Conexion {

    private String url= "http://167.172.146.90:3005";
    private String path= "/categoria/getCategorias";
    private StringBuilder response = new StringBuilder();



    public ArrayList<Categoria> getCAtegoria()
    {
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        String union=url+path;
        try{
            URL nameUrl= new URL(union);
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
            }
            return listaCategoria;
        }

        catch(Exception exception){

        }
        return listaCategoria;
    }

    public void getFlujoEfectivo(){
        try{

        }
        catch(Exception exception){

        }
    }

    public void getIndicador()
    {
        try{

        }
        catch(Exception exception){

        }
    }
}
