package org.hackatonalm.dignificame.fragments;


import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MarkerOptionsCreator;

import org.hackatonalm.dignificame.ListadoBusqueda;
import org.hackatonalm.dignificame.models.Oferta;

import java.util.List;

/**
 * Created by Arasthel on 22/03/14.
 */
public class CustomMapFragment extends SupportMapFragment implements GoogleMap.OnMapLoadedCallback, ListadoBusqueda.OnOfertasLoadedListener {

    public static CustomMapFragment createInstance(double latitud, double longitud, List<Oferta> ofertas) {
        CustomMapFragment mapFragment = new CustomMapFragment();
        mapFragment.setLatitud(latitud);
        mapFragment.setLongitud(longitud);
        mapFragment.setOfertas(ofertas);
        return mapFragment;
    }

    private double latitud = 0;
    private double longitud = 0;
    private List<Oferta> ofertas;

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMap().setOnMapLoadedCallback(this);
        if(savedInstanceState != null) {
            latitud = savedInstanceState.getDouble("latitud", 0);
            longitud = savedInstanceState.getDouble("longitud", 0);
        }
        if(getActivity() instanceof ListadoBusqueda) {
            ((ListadoBusqueda) getActivity()).setMapaListener(this);
        }
    }

    @Override
    public void onMapLoaded() {
        getMap().setMyLocationEnabled(true);
        if(latitud != 0 && longitud != 0) {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitud, longitud), 10.0f));
            if(ofertas != null) {
                for (Oferta oferta : ofertas) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng(oferta.getEmpresa().getLatitud(), oferta.getEmpresa().getLongitud()));
                    getMap().addMarker(markerOptions);
                }
            }
        }

    }

    @Override
    public void onOfertasLoaded(List<Oferta> ofertas) {
        if(ofertas != null) {
            for (Oferta oferta : ofertas) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(oferta.getEmpresa().getLatitud(), oferta.getEmpresa().getLongitud()));
                getMap().addMarker(markerOptions);
            }
        }
    }
}
