/*
    gOST a location based bgm player
    Copyright (C) 2016 Andrew Mcdonald Притула, drew887121@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package tk.itsrocket.gost.Model;

import android.content.ContentValues;

import tk.itsrocket.gost.Controler.ZoneDBContract.ZoneDBEntry;

/**
 * Represents a musical zone
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public class Zone{
    protected Double latitude, longitude, radius;
    protected String music, name;
    protected Long ID;

    public Zone(){
        latitude = longitude = 0.0;
        music = name = "";
        ID = 0l;
    }

    public Zone(Double latitude, Double longitude, Double radius, String music, String name, Long ID){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.music = music;
        this.name = name;
        this.ID = ID;
    }

    public Double getRadius(){
        return radius;
    }

    public Zone setRadius(Double radius){
        this.radius = radius;
        return this;
    }

    public Double getLatitude(){
        return latitude;
    }

    public Zone setLatitude(Double latitude){
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude(){
        return longitude;
    }

    public Zone setLongitude(Double longitude){
        this.longitude = longitude;
        return this;
    }

    public String getMusic(){
        return music;
    }

    public Zone setMusic(String music){
        this.music = music;
        return this;
    }

    public String getName(){
        return name;
    }

    public Zone setName(String name){
        this.name = name;
        return this;
    }

    public Long getID(){
        return ID;
    }

    public Zone setID(Long ID){
        this.ID = ID;
        return this;
    }

    public ContentValues generateContentValues(){
        ContentValues values = new ContentValues();
        values.put(ZoneDBEntry.name, getName());
        values.put(ZoneDBEntry.music, getMusic());
        values.put(ZoneDBEntry.latitude, getLatitude());
        values.put(ZoneDBEntry.longitude, getLongitude());
        values.put(ZoneDBEntry.radius, getRadius());
        return values;
    }
}
