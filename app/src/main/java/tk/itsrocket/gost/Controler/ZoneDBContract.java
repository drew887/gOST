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

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import tk.itsrocket.gost.Model.Zone;

/**
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public final class ZoneDBContract {

    public static final String createString = "CREATE TABLE " + ZoneDBEntry.tableName + " (" +
            ZoneDBEntry.ID + " INTEGER PRIMARY KEY , " +
            ZoneDBEntry.name + " TEXT, " +
            ZoneDBEntry.latitude + " REAL, " +
            ZoneDBEntry.longitude + " REAL, " +
            ZoneDBEntry.music + " TEXT )";
    public static final String deleteString = "DROP TABLE IF EXISTS " + ZoneDBEntry.tableName;

    private ZoneDBContract() {
    }

    public static abstract class ZoneDBEntry {
        public static final String tableName = "zones";
        public static final String ID = "zoneID";
        public static final String name = "zoneName";
        public static final String latitude = "zoneLatitude";
        public static final String longitude = "zoneLongitude";
        public static final String music = "zoneMusic";
    }
/*
    public class ZoneDBHelper extends SQLiteOpenHelper {

        public static final int dbVersion = 1;
        public static final String dbName = "zones.db";

        public ZoneDBHelper(Context context) {
            super(context, dbName, null, dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //do nothing for now
        }

        /**
         * Inserts zone into db and sets zones id to the new id returned
         *
         * @param db   the db to insert
         * @param zone the new zone to insert, it will assign the new id to it
         * @return true if the insert was successful

        public Boolean insert(SQLiteDatabase db, Zone zone) {
            Boolean result = false;
            Long insert = db.insert(ZoneDBEntry.tableName, "null", zone.generateContentValues());
            if (insert > 0) {
                result = true;
                zone.setID(insert);
            }
            return result;
        }

        /**
         * updates zone in the database
         *
         * @param db
         * @param zone
         * @return returns true if the result modified exactly 1 record (should only be 1)

        public Boolean update(SQLiteDatabase db, Zone zone) {
            Boolean result = false;
            String whereString = ZoneDBEntry.ID + " = ?";
            String[] whereValues = {zone.getID().toString()};
            int modified = db.update(ZoneDBEntry.tableName, zone.generateContentValues(), whereString, whereValues);
            result = modified == 1;
            return result;
        }
    }*/
}
