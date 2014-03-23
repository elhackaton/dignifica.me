package org.hackatonalm.dignificame.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arasthel on 22/03/14.
 */
public class Denuncia {

    private Oferta oferta;
    private Empresa empresa;
    private String motivo;
    private String comentario;

    public Denuncia(Oferta oferta, Empresa empresa, String motivo, String comentario) {
        this.oferta = oferta;
        this.empresa = empresa;
        this.motivo = motivo;
        this.comentario = comentario;
    }

    public static Denuncia denunciaFromJSON(JSONObject json, Oferta oferta, Empresa empresa) {
        Denuncia denuncia = null;
        try {
            denuncia = new Denuncia(oferta, empresa, json.getString("motivo"), json.getString("comentario"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return denuncia;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
