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
package tk.itsrocket.gost.Controler;

/**
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public abstract class ZoneDBContract{

    public static final String createString = "CREATE TABLE " + ZoneDBEntry.tableName + " (" +
            ZoneDBEntry.ID + " INTEGER PRIMARY KEY , " +
            ZoneDBEntry.name + " TEXT, " +
            ZoneDBEntry.latitude + " REAL, " +
            ZoneDBEntry.longitude + " REAL, " +
            ZoneDBEntry.radius + " REAL, " +
            ZoneDBEntry.music + " TEXT )";
    public static final String deleteString = "DROP TABLE IF EXISTS " + ZoneDBEntry.tableName;

    public static abstract class ZoneDBEntry{
        public static final String tableName = "zones";
        public static final String ID = "zoneID";
        public static final String name = "zoneName";
        public static final String latitude = "zoneLatitude";
        public static final String longitude = "zoneLongitude";
        public static final String radius = "zoneRadius";
        public static final String music = "zoneMusic";
    }
}
