package org.hackatonalm.dignificame.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.hackatonalm.dignificame.DataStorage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arasthel on 22/03/14.
 */
public class Empresa {

    private String nombre;
    private double latitud;
    private double longitud;
    private String descripcion;
    private String ciudad;
    private List<Denuncia> denuncias = new ArrayList<Denuncia>();

    public Empresa(String nombre, double latitud, double longitud, String descripcion, String ciudad) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
    }

    public static Empresa empresaFromJSON(JSONObject json) {
        Empresa empresa = null;

        try {
            String nombre = json.getString("nombre");
            if(DataStorage.ofertasMap.containsKey(nombre)) {
                empresa = DataStorage.ofertasMap.get(nombre);
            } else {
                empresa = new Empresa(nombre,
                        json.optDouble("lat"),
                        json.optDouble("lng"),
                        json.getString("descripcion"),
                        json.getString("ciudad"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    public void addDenuncia(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
