package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.layout_centerInParent;
import static android.R.attr.resource;

/**
 * Created by PcPc on 01/05/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if (convertView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false
            );
        }

        Earthquake earthquake = getItem(position);


        TextView magnitude = (TextView) listView.findViewById(R.id.magnitude);
        magnitude.setText(String.valueOf(earthquake.getmMagnitude()));

        TextView place = (TextView) listView.findViewById(R.id.place);
        place.setText(earthquake.getmPlace());

        TextView time = (TextView) listView.findViewById(R.id.time);
        time.setText(earthquake.getmTime());


        return listView;
    }
}
