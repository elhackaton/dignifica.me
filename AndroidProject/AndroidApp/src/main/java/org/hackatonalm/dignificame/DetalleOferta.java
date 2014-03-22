package org.hackatonalm.dignificame;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.hackatonalm.dignificame.fragments.CustomMapFragment;


public class DetalleOferta extends ActionBarActivity {

    private SlidingUpPanelLayout slidingPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta);
        slidingPanel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        slidingPanel.setShadowDrawable(getResources().getDrawable(R.drawable.sliding_shadow));
        slidingPanel.setEnableDragViewTouchEvents(false);

        CustomMapFragment mapFragment = new CustomMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_container, mapFragment, "map_fragment").commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detalle_oferta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
