package org.hackatonalm.dignificame.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.hackatonalm.dignificame.fragments.CustomMapFragment;
import org.hackatonalm.dignificame.fragments.ListadoBusquedaFragment;

/**
 * Created by Arasthel on 22/03/14.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                f = new ListadoBusquedaFragment();
                break;
            case 1:
                f = new CustomMapFragment();
                break;
        }
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Resultados";
            case 1:
                return "Mapa de resultados";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
