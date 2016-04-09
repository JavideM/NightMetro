package org.remarastudios.nightmetro.presenters;

import org.remarastudios.nightmetro.interactors.TimetableInteractor;
import org.remarastudios.nightmetro.views.Timetable.TimetableView;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class TimetablePresenter {
    TimetableView mView;
    TimetableInteractor mInteractor;

    public TimetablePresenter (TimetableView view, int itemId){
        this.mView = view;
        this.mInteractor = new TimetableInteractor();
    }

    public void onStart() {
        mView.setupList();
        mView.setupAdapter();
        mView.setItems(mInteractor.getTimes());
    }

    public void onStop(){

    }
}
