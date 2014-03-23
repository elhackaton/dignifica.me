package org.hackatonalm.dignificame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.hackatonalm.dignificame.adapters.DenunciasListaAdapter;
import org.hackatonalm.dignificame.fragments.CustomMapFragment;
import org.hackatonalm.dignificame.models.Oferta;

import java.util.ArrayList;


public class DetalleOferta extends ActionBarActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private SlidingUpPanelLayout slidingPanel;
    private CustomMapFragment mapFragment;
    private ListView listaDenuncias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta);
        slidingPanel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        slidingPanel.setShadowDrawable(getResources().getDrawable(R.drawable.sliding_shadow));
        slidingPanel.setEnableDragViewTouchEvents(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarOferta();
    }

    public void cargarOferta() {
        if(DataStorage.currentOferta != null) {
            Oferta oferta = DataStorage.currentOferta;
            TextView titulo = (TextView) findViewById(R.id.titulo_oferta);
            titulo.setText(oferta.getTitulo());
            TextView empresa = (TextView) findViewById(R.id.nombre_empresa);
            empresa.setText(oferta.getEmpresa().getNombre());

            double lat = oferta.getEmpresa().getLatitud();
            double lng = oferta.getEmpresa().getLongitud();
            ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
            ofertas.add(oferta);
            CustomMapFragment mapFragment = CustomMapFragment.createInstance(lat, lng, ofertas);
            getSupportFragmentManager().beginTransaction().replace(R.id.map_container, mapFragment, "map_fragment").commit();

            TextView descripcion  = (TextView) findViewById(R.id.descripcion_oferta);
            descripcion.setText(oferta.getDescripcion());

            TextView requisitos = (TextView) findViewById(R.id.requisitos_oferta);
            if(TextUtils.isEmpty(oferta.getRequisitosMinimos())) {
                requisitos.setText("No hay requisitos mínimos.");
            } else {
                requisitos.setText(oferta.getRequisitosMinimos());
            }
            TextView sueldo = (TextView) findViewById(R.id.sueldo_oferta);
            sueldo.setText("Desconocido.");

            listaDenuncias = (ListView) findViewById(R.id.lista_denuncias);
            DenunciasListaAdapter adapter = new DenunciasListaAdapter(this, -1, oferta.getDenuncias());
            listaDenuncias.setAdapter(adapter);

            listaDenuncias.setOnItemClickListener(this);

            Button denunciarBtn = (Button) findViewById(R.id.denunciar_btn);
            denunciarBtn.setOnClickListener(this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DataStorage.currentDenuncia = ((DenunciasListaAdapter) listaDenuncias.getAdapter()).getItem(i);
        Intent intent = new Intent(this, DetalleDenuncia.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.denunciar_btn:
                Intent i = new Intent(this, FormularioDenuncia.class);
                startActivity(i);
        }
    }
}
