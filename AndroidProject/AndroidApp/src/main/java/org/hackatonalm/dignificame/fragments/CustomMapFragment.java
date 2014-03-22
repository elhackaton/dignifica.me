package org.hackatonalm.dignificame.fragments;


import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Arasthel on 22/03/14.
 */
public class CustomMapFragment extends SupportMapFragment implements GoogleMap.OnMapLoadedCallback {

    public static CustomMapFragment newInstance(double latitud, double longitud) {
        CustomMapFragment mapFragment = new CustomMapFragment();
        mapFragment.setLatitud(latitud);
        mapFragment.setLongitud(longitud);
        return mapFragment;
    }

    private double latitud = 0;
    private double longitud = 0;

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
    }

    @Override
    public void onMapLoaded() {
        getMap().setMyLocationEnabled(true);
        if(latitud != 0 && longitud != 0) {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitud, longitud), 2.0f));
        }

    }
}
