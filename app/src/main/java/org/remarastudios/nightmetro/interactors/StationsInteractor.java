package org.remarastudios.nightmetro.interactors;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class StationsInteractor {
    public ArrayList<String> getStations() {
        //Dummy data
        String[] stationsArray = {
            "Principe Pio",
            "Tribunal",
            "Quevedo",
            "Noviciado"
        };
        ArrayList<String> stations = new ArrayList<String>(
                Arrays.asList(stationsArray)
        );
        return stations;
    }
}
