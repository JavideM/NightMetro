package org.remarastudios.nightmetro.views.Stations;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.remarastudios.nightmetro.R;
import org.remarastudios.nightmetro.presenters.StationsPresenter;
import org.remarastudios.nightmetro.views.Timetable.TimetableActivity;
import org.remarastudios.nightmetro.views.Timetable.TimetableActivityFragment;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class StationsActivityFragment extends Fragment implements StationsView, AdapterView.OnItemClickListener {
    public static final String LOG_TAG = StationsActivityFragment.class.getSimpleName();

    StationsPresenter mPresenter;
    ArrayAdapter<String> mStationAdapter;

    private ListView stationsListView;

    public StationsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stations, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new StationsPresenter(this);

        // Initialized the stations adapter
        mStationAdapter = new ArrayAdapter<String>(
                // Current context
                getActivity(),
                // Layout list id
                R.layout.list_item_station,
                // Item id
                R.id.list_item_station_textview,
                // Empty data list
                new ArrayList<String>());
        stationsListView = (ListView)view.findViewById(R.id.listview_stations);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    public void setupList(){
        stationsListView.setAdapter(mStationAdapter);
    }

    public void setupAdapter(){
        stationsListView.setOnItemClickListener(this);
    }

    public void setItems (ArrayList<String> stations){
        mStationAdapter.clear();
        for (String station: stations) {
          mStationAdapter.add(station);
        };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), TimetableActivity.class)
                .putExtra(Intent.EXTRA_TEXT, position);
        startActivity(intent);
    }
}
