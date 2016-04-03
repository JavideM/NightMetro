package org.remarastudios.nightmetro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.remarastudios.nightmetro.R;
import org.remarastudios.nightmetro.entities.StationEntity;

import java.util.ArrayList;

/**
 * Created by Javier on 03/04/2016. Remara Studios.
 */
public class StationsAdapter extends ArrayAdapter<StationEntity> {

    public StationsAdapter(Context context, int resource, ArrayList<StationEntity> objects) {
        super(context, resource, objects);
    }

    @Override
    public long getItemId(int position) {
        return super.getItem(position).Id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder vHolder = null;
        if(v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_station, null);
            vHolder = new ViewHolder();
            vHolder.txt = (TextView) v.findViewById(R.id.list_item_station_text);
            v.setTag(vHolder);
        }else {
            vHolder = (ViewHolder) convertView.getTag();
        }

        StationEntity p = getItem(position);

        vHolder.txt.setText(p.Name);

        return v;
    }

    public class ViewHolder {
        public TextView txt;
    }
}
