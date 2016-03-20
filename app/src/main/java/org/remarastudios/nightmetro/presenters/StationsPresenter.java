package org.remarastudios.nightmetro.presenters;

import org.remarastudios.nightmetro.interactors.StationsInteractor;
import org.remarastudios.nightmetro.views.Stations.StationsView;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class StationsPresenter {
    StationsView mView;
    StationsInteractor mInteractor;

    public StationsPresenter (StationsView view){
        this.mView = view;
        this.mInteractor = new StationsInteractor();
    }

    public void onStart() {
        mView.setupList();
        mView.setupAdapter();
        mView.setItems(mInteractor.getStations());
    }

    public void onStop(){

    }
}
