package tk.itsrocket.gost.Model;

import android.content.ContentValues;

import tk.itsrocket.gost.Controler.ZoneDBContract.ZoneDBEntry;

/**
 * Represents a musical zone
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public class Zone {
    protected Double latitude, longitude;
    protected String music, name;
    protected Long ID;

    public Zone(Double latitude, Double longitude, String music, String name, Long ID) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.music = music;
        this.name = name;
        this.ID = ID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Zone setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Zone setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getMusic() {
        return music;
    }

    public Zone setMusic(String music) {
        this.music = music;
        return this;
    }

    public String getName() {
        return name;
    }

    public Zone setName(String name) {
        this.name = name;
        return this;
    }

    public Long getID() {
        return ID;
    }

    public Zone setID(Long ID) {
        this.ID = ID;
        return this;
    }

    public ContentValues generateContentValues() {
        ContentValues values = new ContentValues();
        values.put(ZoneDBEntry.name, getName());
        values.put(ZoneDBEntry.music, getMusic());
        values.put(ZoneDBEntry.latitude, getLatitude());
        values.put(ZoneDBEntry.longitude, getLongitude());
        return values;
    }
}
