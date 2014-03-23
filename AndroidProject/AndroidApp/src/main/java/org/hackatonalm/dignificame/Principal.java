package org.hackatonalm.dignificame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends Activity implements View.OnClickListener {

    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnBuscar = (Button) findViewById(R.id.btn_buscar);
        btnBuscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_buscar:
                String[] categorias = getResources().getStringArray(R.array.categorias_short);
                Intent i = new Intent(this, ListadoBusqueda.class);
                Spinner categoriasSpinner = (Spinner) findViewById(R.id.categorias_spinner);
                if(categoriasSpinner.getSelectedItemPosition() > 0) {
                    i.putExtra("terminos", categorias[categoriasSpinner.getSelectedItemPosition()]);
                }
                Spinner provinciaSpinner = (Spinner) findViewById(R.id.lugar_spinner);
                if(provinciaSpinner.getSelectedItemPosition() > 0) {
                    i.putExtra("lugar", provinciaSpinner.getSelectedItem().toString());
                }
                startActivity(i);
                break;
        }
    }
}
