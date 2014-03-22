package org.hackatonalm.dignificame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent i = new Intent(this, ListadoBusqueda.class);
                startActivity(i);
                break;
        }
    }
}
