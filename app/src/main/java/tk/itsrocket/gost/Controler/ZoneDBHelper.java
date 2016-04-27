package tk.itsrocket.gost.Controler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tk.itsrocket.gost.Model.Zone;
import tk.itsrocket.gost.Controler.ZoneDBContract.ZoneDBEntry;

/**
 * Created by Andrew Mcdonald Притула on 4/26/16.
 */
public class ZoneDBHelper extends SQLiteOpenHelper {

    public static final int dbVersion = 1;
    public static final String dbName = "zones.db";

    public ZoneDBHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ZoneDBContract.createString);
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
     */
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
     */
    public Boolean update(SQLiteDatabase db, Zone zone) {
        Boolean result = false;
        String whereString = ZoneDBEntry.ID + " = ?";
        String[] whereValues = {zone.getID().toString()};
        int modified = db.update(ZoneDBEntry.tableName, zone.generateContentValues(), whereString, whereValues);
        result = modified == 1;
        return result;
    }
}