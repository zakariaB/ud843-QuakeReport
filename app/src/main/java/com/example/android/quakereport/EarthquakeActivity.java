/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.data;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";

    private EarthquakeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

//        ArrayList<Earthquake> earthquakes = new ArrayList<>(asList(
//                new Earthquake(1.1, "Alger", "2010"),
//                new Earthquake(2.1, "Alger", "2011"),
//                new Earthquake(3.1, "Alger", "2012"),
//                new Earthquake(4.1, "Alger", "2013")
//        ));

        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Earthquake earthquake = adapter.getItem(position);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(earthquake.getmUrl()));
                startActivity(i);
            }
        });


        QuakeReportAsyncTask quakeReportAsyncTask = new QuakeReportAsyncTask();
        quakeReportAsyncTask.execute(USGS_REQUEST_URL);

    }

    private class QuakeReportAsyncTask extends AsyncTask<String, Void, ArrayList<Earthquake>> {

        @Override
        protected ArrayList<Earthquake> doInBackground(String... params) {
            if (params.length < 1 || params[0] == null) {
                return null;
            }
            ArrayList<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(params[0]);

            return earthquakes;
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthquakes) {
            // Clear the adapter of previous earthquake data
            adapter.clear();


            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (earthquakes != null && !earthquakes.isEmpty()) {
                Log.e(LOG_TAG, earthquakes.get(0).getmPlace());
                adapter.addAll(earthquakes);
            }

        }
    }

    protected void updateUi(ArrayList<Earthquake> earthquakes) {
        // Clear the adapter of previous earthquake data
        adapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            adapter.addAll(earthquakes);
        }


    }
}
