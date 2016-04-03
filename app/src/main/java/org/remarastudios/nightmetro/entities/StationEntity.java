package org.remarastudios.nightmetro.entities;

/**
 * Created by Javier on 20/03/2016. Remara Studios.
 */
public class StationEntity {

    public StationEntity(int id, String name, String shortName){
        this.Id = id;
        this.Name = name;
        this.ShortName = shortName;
    }

    public int Id;

    public String Name;

    public String ShortName;
}
