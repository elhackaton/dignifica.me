package org.hackatonalm.dignificame;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;

import org.hackatonalm.dignificame.adapters.ViewPagerAdapter;
import org.hackatonalm.dignificame.models.Oferta;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ListadoBusqueda extends ActionBarActivity {

    private ViewPager viewPager;
    private PageIndicator pagerIndicator;
    private OnOfertasLoadedListener listadoListener;
    private OnOfertasLoadedListener mapaListener;

    private List<Oferta> ofertas;

    public void setListadoListener(OnOfertasLoadedListener listadoListener) {
        this.listadoListener = listadoListener;
        if(ofertas != null) {
            listadoListener.onOfertasLoaded(ofertas);
        }
    }

    public void setMapaListener(OnOfertasLoadedListener mapaListener) {
        this.mapaListener = mapaListener;
        if(mapaListener != null) {
            mapaListener.onOfertasLoaded(ofertas);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_busqueda);
        viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        pagerIndicator = (TabPageIndicator) findViewById(R.id.pager_indicator);
        pagerIndicator.setViewPager(viewPager);

        String url = "http://192.168.1.68:9000/api/ofertas/?format=json";
        if(getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("terminos")) {
                url += "&categoria="+getIntent().getExtras().getString("terminos");
            }
            if (getIntent().getExtras().containsKey("lugar")) {
                url += "&ciudad="+getIntent().getExtras().getString("lugar");
            }
        }

        if(BuildConfig.DEBUG) {
            Log.d("org.hackatonalm.dignificame.ListadoBusqueda", "onCreate (line 66): "+url);
        }

        Ion.with(this).
                load(url).
                asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if(result != null) {
                            try {
                                ofertas = new ArrayList<Oferta>();
                                JSONArray objects = new JSONArray(result);
                                for(int i = 0; i < objects.length(); i++) {
                                    JSONObject ofertaJSON = objects.getJSONObject(i);
                                    ofertas.add(Oferta.ofertaFromJSON(ofertaJSON));
                                }
                                if(listadoListener != null) {
                                    listadoListener.onOfertasLoaded(ofertas);
                                }
                                if(mapaListener != null) {
                                    mapaListener.onOfertasLoaded(ofertas);
                                }

                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
    }


    public interface OnOfertasLoadedListener {
        public void onOfertasLoaded(List<Oferta> ofertas);
    }

}
