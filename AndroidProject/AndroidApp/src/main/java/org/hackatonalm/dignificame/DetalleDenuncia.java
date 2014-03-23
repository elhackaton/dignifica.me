package org.hackatonalm.dignificame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalleDenuncia extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_denuncia);

        if(DataStorage.currentDenuncia != null) {
            TextView tituloDenuncia = (TextView) findViewById(R.id.motivo_denuncia);
            tituloDenuncia.setText(DataStorage.currentDenuncia.getMotivo());

            TextView comentariosDenuncia = (TextView) findViewById(R.id.comentarios_denuncia);
            if(TextUtils.isEmpty(DataStorage.currentDenuncia.getComentario())) {
                comentariosDenuncia.setText("Sin comentarios.");
            } else {
                comentariosDenuncia.setText(DataStorage.currentDenuncia.getComentario());
            }
        }
    }
}
