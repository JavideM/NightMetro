package org.remarastudios.nightmetro.views.Stations;

import android.content.Context;

import org.remarastudios.nightmetro.entities.StationEntity;

import java.util.ArrayList;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public interface StationsView {

    void setupList();

    void setupAdapter();

    void setItems (ArrayList<StationEntity> stations);

    Context getViewContext();
}
