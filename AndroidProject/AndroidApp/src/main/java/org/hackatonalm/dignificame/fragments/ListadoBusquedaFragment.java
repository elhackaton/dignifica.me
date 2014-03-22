package org.hackatonalm.dignificame.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.hackatonalm.dignificame.DetalleOferta;
import org.hackatonalm.dignificame.R;
import org.hackatonalm.dignificame.adapters.OfertasListaAdapter;
import org.hackatonalm.dignificame.models.Empresa;
import org.hackatonalm.dignificame.models.Oferta;

import java.util.ArrayList;

/**
 * Created by Arasthel on 22/03/14.
 */
public class ListadoBusquedaFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lista;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado_busqueda, container, false);
        lista = (ListView) v.findViewById(R.id.lista_ofertas);
        context = getActivity();
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Oferta oferta = new Oferta();
        oferta.setTitulo("Oferta de desarrollador Android");
        Empresa empresa = new Empresa();
        empresa.setNombre("Surbus (ALSA)");
        oferta.setEmpresa(empresa);
        ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
        ofertas.add(oferta);
        OfertasListaAdapter adapter = new OfertasListaAdapter(context, -1, ofertas);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(context, DetalleOferta.class);
        intent.putExtra("oferta", ((OfertasListaAdapter) lista.getAdapter()).getItem(i));
        startActivity(intent);
    }
}
