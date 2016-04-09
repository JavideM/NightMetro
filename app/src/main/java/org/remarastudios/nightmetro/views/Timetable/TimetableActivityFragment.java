package org.remarastudios.nightmetro.views.Timetable;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.remarastudios.nightmetro.R;
import org.remarastudios.nightmetro.adapters.TimesAdapter;
import org.remarastudios.nightmetro.entities.TimeEntity;
import org.remarastudios.nightmetro.presenters.TimetablePresenter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class TimetableActivityFragment extends Fragment implements TimetableView {

    TimetablePresenter mPresenter;
    TimesAdapter mTimeAdapter;

    private ListView timesListView;

    public TimetableActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timetable, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent = getActivity().getIntent();
        int id = 0;
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT))
            id = intent.getIntExtra(Intent.EXTRA_TEXT, 0);
        mPresenter = new TimetablePresenter(this, id);
        //Toast.makeText(this.getActivity(),id + "", Toast.LENGTH_LONG).show();
        // Initialized the stations adapter
        mTimeAdapter = new TimesAdapter(
                // Current context
                getActivity(),
                // Layout list id
                R.layout.list_item_station,
                // Empty data list
                new ArrayList<TimeEntity>());
        timesListView = (ListView)view.findViewById(R.id.listview_timetable);
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

    @Override
    public void setupList() {
        timesListView.setAdapter(mTimeAdapter);
    }

    @Override
    public void setupAdapter() {

    }

    @Override
    public void setItems(ArrayList<TimeEntity> times) {
        mTimeAdapter.clear();
        for (TimeEntity time: times) {
            mTimeAdapter.add(time);
        };
    }
}
