package org.hackatonalm.dignificame.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.hackatonalm.dignificame.R;
import org.hackatonalm.dignificame.models.Denuncia;
import org.hackatonalm.dignificame.models.Oferta;

import java.util.List;

/**
 * Created by Arasthel on 22/03/14.
 */
public class DenunciasListaAdapter extends ArrayAdapter<Denuncia> {

    public DenunciasListaAdapter(Context context, int resource, List<Denuncia> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            convertView = View.inflate(getContext(), R.layout.oferta_list_item, null);
            holder = new ViewHolder();
            holder.tituloOfertaTxt = (TextView) convertView.findViewById(R.id.titulo_oferta);
            holder.nombreEmpresaTxt = (TextView) convertView.findViewById(R.id.nombre_empresa);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tituloOfertaTxt.setText(getItem(position).getMotivo());
        holder.nombreEmpresaTxt.setText(getItem(position).getComentario());

        return convertView;
    }

    private class ViewHolder {
        public TextView tituloOfertaTxt;
        public TextView nombreEmpresaTxt;
    }
}
