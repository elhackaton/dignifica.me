package org.hackatonalm.dignificame.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Arasthel on 22/03/14.
 */
public class Denuncia implements Parcelable {

    private Oferta oferta;
    private Empresa empresa;
    private String motivo;
    private String comentario;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
