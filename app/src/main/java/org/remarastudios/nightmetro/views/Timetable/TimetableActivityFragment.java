package org.remarastudios.nightmetro.views.Timetable;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.remarastudios.nightmetro.R;
import org.remarastudios.nightmetro.presenters.TimetablePresenter;

/**
 * A placeholder fragment containing a simple view.
 */
public class TimetableActivityFragment extends Fragment implements TimetableView {

    TimetablePresenter mPresenter;

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
}
