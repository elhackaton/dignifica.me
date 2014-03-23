package org.hackatonalm.dignificame.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arasthel on 22/03/14.
 */
public class Oferta {

    private int id;
    private String titulo;
    private String categoria;
    private String descripcion;
    private String requisitosMinimos;
    private String url;
    private Empresa empresa;
    private ArrayList<Denuncia> denuncias;

    public Empresa getEmpresa() {
        return empresa;
    }

    public Oferta(int id, String titulo, String categoria, String descripcion, String requisitosMinimos, String url, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.requisitosMinimos = requisitosMinimos;
        this.url = url;
        this.empresa = empresa;
    }

    public static Oferta ofertaFromJSON(JSONObject json) {
        Oferta oferta = null;
        try {
            Empresa empresa = Empresa.empresaFromJSON(json.getJSONObject("empresa"));
            JSONArray denunciasJSONArray = json.getJSONArray("denuncias");
            ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();
            for(int i = 0; i < denunciasJSONArray.length(); i++) {
                Denuncia denuncia = Denuncia.denunciaFromJSON(denunciasJSONArray.getJSONObject(i), null, empresa);
                denuncias.add(denuncia);
                empresa.addDenuncia(denuncia);
            }
            int id = json.getInt("id");
            String titulo = json.getString("titulo");
            String categoria = json.getString("categoria");
            String descripcion = json.getString("descripcion");
            String requisitos = json.getString("requisitos");
            String url = json.getString("url");

            oferta = new Oferta(id, titulo, categoria, descripcion, requisitos, url, empresa);
            oferta.setDenuncias(denuncias);
            return oferta;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return oferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(ArrayList<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitosMinimos() {
        return requisitosMinimos;
    }

    public void setRequisitosMinimos(String requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
