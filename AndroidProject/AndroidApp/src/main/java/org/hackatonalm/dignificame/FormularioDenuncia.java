package org.hackatonalm.dignificame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.hackatonalm.dignificame.models.Denuncia;


public class FormularioDenuncia extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_denuncia);

        Button denunciarButton = (Button) findViewById(R.id.denunciar_btn);
        denunciarButton.setOnClickListener(this);
    }

    public void enviarDenuncia() {

        Spinner spinnerMotivos = (Spinner) findViewById(R.id.spinner_motivo_denuncia);
        EditText comentarioEdit = (EditText) findViewById(R.id.comentarios_denuncia);
        final Denuncia denuncia = new Denuncia(DataStorage.currentOferta, DataStorage.currentOferta.getEmpresa(), spinnerMotivos.getSelectedItem().toString(), comentarioEdit.getText().toString());
        Ion.with(this)
                .load("http://192.168.1.68:9000/api/denuncias/")
                .setBodyParameter("id_oferta", String.valueOf(DataStorage.currentOferta.getId()))
                .setBodyParameter("motivo", spinnerMotivos.getSelectedItem().toString())
                .setBodyParameter("comentario", comentarioEdit.getText().toString())
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        DataStorage.currentOferta.getDenuncias().add(denuncia);
                        finish();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.denunciar_btn:
                enviarDenuncia();
                break;
        }
    }
}
