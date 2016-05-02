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

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Andrew Mcdonald Притула on 3/27/16.
 */
public class LocationUpdater implements LocationListener {

    private int gpsUpdateFreq;
    private int networkUpdateFreq;
    private Location lastLocation;

    LocationUpdater(int pGpsUpdateFreq, int pNetworkUpdateFreq) {
        setGpsUpdateFreq(pGpsUpdateFreq);
        setNetworkUpdateFreq(pNetworkUpdateFreq);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("LocationUpdater", "logUpdate: " + location.toString());
        setLastLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location pLastLocation) {
        lastLocation = pLastLocation;
    }

    public int getGpsUpdateFreq() {
        return gpsUpdateFreq;
    }

    public void setGpsUpdateFreq(int gpsUpdateFreq) {
        this.gpsUpdateFreq = gpsUpdateFreq;
    }

    public int getNetworkUpdateFreq() {
        return networkUpdateFreq;
    }

    public void setNetworkUpdateFreq(int networkUpdateFreq) {
        this.networkUpdateFreq = networkUpdateFreq;
    }
}
