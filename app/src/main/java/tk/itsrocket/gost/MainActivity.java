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
package tk.itsrocket.gost;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import tk.itsrocket.gost.Controler.ZoneDBContract;
import tk.itsrocket.gost.Controler.ZoneDBHelper;
import tk.itsrocket.gost.Model.Zone;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "gOST";
    private LocationManager locMan;
    private LocationUpdater locUpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        locMan = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locUpt = new LocationUpdater(3000, 0);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locMan.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, locUpt.getNetworkUpdateFreq(), 0, locUpt);
            locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, locUpt.getGpsUpdateFreq(), 0, locUpt);
        } else {
            Log.e(TAG, "onCreate: NO PERMISSION");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        ZoneDBHelper zdbh= new ZoneDBHelper(getApplicationContext());;
        SQLiteDatabase db;
        switch (item.getItemId()) {
            case R.id.action_settings:
                db = zdbh.getWritableDatabase();
                Zone zone = new Zone(45.5, 45.5, "blam", "home", 0l);
                Boolean result = zdbh.insert(db, zone);
                Log.i(TAG, "VALUE INST " + result.toString() + ", " + zone.getID());
                return true;
            case R.id.action_wipe:
                db = zdbh.getWritableDatabase();
                db.execSQL(ZoneDBContract.deleteString);
                db.execSQL(ZoneDBContract.createString);
                Log.i(TAG, "DB RECREATED");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
