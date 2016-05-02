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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tk.itsrocket.gost.Controler.ZoneDBContract.ZoneDBEntry;
import tk.itsrocket.gost.Model.Zone;

/**
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public class ZoneDBHelper extends SQLiteOpenHelper{

    public static final int dbVersion = 1;
    public static final String dbName = "zones.db";

    public ZoneDBHelper(Context context){
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(ZoneDBContract.createString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //do nothing for now
    }

    /**
     * Inserts zone into db and sets zones id to the new id returned
     * @param db the db to insert
     * @param zone the new Zone to insert, it will assign the new id to it
     * @return true if the insert was successful
     */
    public Boolean insert(SQLiteDatabase db, Zone zone){
        Boolean result = false;
        Long insert = db.insert(ZoneDBEntry.tableName, "null", zone.generateContentValues());
        if(insert > 0){
            result = true;
            zone.setID(insert);
        }
        return result;
    }

    /**
     * performs insert with zone but with the inner writeable database
     * @param zone the new Zone to insert, it will assign the new id to it
     * @return true if the insert was successful
     */
    public Boolean insert(Zone zone){
        return insert(getWritableDatabase(), zone);
    }

    /**
     * updates zone in the database db
     * @param db the db to update
     * @param zone the Zone to update
     * @return returns true if the result modified exactly 1 record (should only be 1)
     */
    public Boolean update(SQLiteDatabase db, Zone zone){
        String whereString = ZoneDBEntry.ID + " = ?";
        String[] whereValues = {zone.getID().toString()};
        int modified = db.update(ZoneDBEntry.tableName, zone.generateContentValues(), whereString, whereValues);
        return (modified == 1);
    }

    /**
     * calls update on the inner writeable database
     * @param zone the Zone to update
     * @return returns true if the result modified exactly 1 record (should only be 1)
     */
    public Boolean update(Zone zone){
        return update(getWritableDatabase(), zone);
    }

    /**
     * recreates the zone table in db
     * @param db the SQLiteDatabase to recrate the tables in
     */
    public void recreate(SQLiteDatabase db){
        db.execSQL(ZoneDBContract.deleteString);
        db.execSQL(ZoneDBContract.createString);
    }

    /**
     * recreates the zone database on the inner writeable database
     */
    public void recreate(){
        recreate(getWritableDatabase());
    }
}