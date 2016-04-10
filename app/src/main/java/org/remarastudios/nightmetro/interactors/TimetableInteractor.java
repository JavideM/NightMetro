package org.remarastudios.nightmetro.interactors;
import org.remarastudios.nightmetro.entities.TimeEntity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class TimetableInteractor {
    

    public TimetableInteractor(){
        
    }

    public ArrayList<TimeEntity> getTimes(int idstation) {
        ArrayList<TimeEntity> times;
        //Dummy data
        TimeEntity[] timesArray = {
                new TimeEntity(1, 1, "22:10"),
                new TimeEntity(2, 1, "21:10")
        };
        times = new ArrayList<>();
        for (TimeEntity time: timesArray) {
            if(time.IdStation == idstation){
                times.add(time);
            }
        }
        return times;
    }
}
