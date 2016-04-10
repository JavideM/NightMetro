package org.remarastudios.nightmetro.interactors;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.remarastudios.nightmetro.R;
import org.remarastudios.nightmetro.entities.StationEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class StationsInteractor {

    private static final String TAG_ID = "Id";
    private static final String TAG_NAME = "Name";

    Context mAplicationContext;

    public StationsInteractor(Context context){
        mAplicationContext = context;
    }

    public ArrayList<StationEntity> getStations() {
        String stationsString = GetDataFromResources();
        //Dummy data
        /*StationEntity[] stationsArray = {
            new StationEntity(1, "Principe Pio"),
            new StationEntity(2, "Tribunal"),
            new StationEntity(3, "Quevedo"),
            new StationEntity(4, "Noviciado"),
            new StationEntity(5, "Plaza de España")
        };
        ArrayList<StationEntity> stations = new ArrayList<StationEntity>(
                Arrays.asList(stationsArray)
        );*/
        return ParseStationsJson(stationsString);
    }

    public String GetDataFromResources() {
        InputStream is = mAplicationContext.getResources().openRawResource(R.raw.stations);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return writer.toString();
    }

    public ArrayList<StationEntity> ParseStationsJson(String stationsStr){
        ArrayList<StationEntity> stations = new ArrayList<>();
        if (stationsStr != null) {
            try {
                JSONArray stationsArray = new JSONArray(stationsStr);
                for (int i = 0; i < stationsArray.length(); i++){
                    JSONObject s = stationsArray.getJSONObject(i);
                    int id = parseInt(s.getString(TAG_ID));
                    String name = s.getString(TAG_NAME);

                    stations.add(new StationEntity(id, name));
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return stations;
    }
}
