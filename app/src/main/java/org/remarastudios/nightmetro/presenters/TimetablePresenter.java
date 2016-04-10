package org.remarastudios.nightmetro.presenters;

import org.remarastudios.nightmetro.entities.TimeEntity;
import org.remarastudios.nightmetro.interactors.TimetableInteractor;
import org.remarastudios.nightmetro.views.Timetable.TimetableView;

import java.util.ArrayList;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class TimetablePresenter {
    TimetableView mView;
    TimetableInteractor mInteractor;

    ArrayList<TimeEntity> mTimes;

    public TimetablePresenter (TimetableView view, int itemId){
        this.mView = view;
        this.mInteractor = new TimetableInteractor();
        this.mTimes = mInteractor.getTimes(itemId);
    }

    public void onStart() {
        mView.setupList();
        mView.setupAdapter();
        mView.setItems(mTimes);
    }

    public void onStop(){

    }
}
