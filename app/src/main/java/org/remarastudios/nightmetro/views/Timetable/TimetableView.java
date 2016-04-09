package org.remarastudios.nightmetro.views.Timetable;

import org.remarastudios.nightmetro.entities.TimeEntity;

import java.util.ArrayList;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public interface TimetableView {
    void setupList();

    void setupAdapter();

    void setItems (ArrayList<TimeEntity> stations);
}
