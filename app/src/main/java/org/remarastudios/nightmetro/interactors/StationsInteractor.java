package org.remarastudios.nightmetro.interactors;

import org.remarastudios.nightmetro.entities.StationEntity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class StationsInteractor {
    public ArrayList<StationEntity> getStations() {
        //Dummy data
        StationEntity[] stationsArray = {
            new StationEntity(1, "Principe Pio", "P.Pio"),
            new StationEntity(2, "Tribunal", "Tribu"),
            new StationEntity(3, "Quevedo", "Quevedo"),
            new StationEntity(4, "Noviciado", "Noviciado"),
            new StationEntity(5, "Plaza de España", "Plz. España")
        };
        ArrayList<StationEntity> stations = new ArrayList<StationEntity>(
                Arrays.asList(stationsArray)
        );
        return stations;
    }
}
