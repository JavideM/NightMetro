package org.remarastudios.nightmetro.views.Timetable;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.remarastudios.nightmetro.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TimetableActivityFragment extends Fragment implements TimetableView {
    public TimetableActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timetable, container, false);
    }
}
