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

    LocationUpdater(int pGpsUpdateFreq, int pNetworkUpdateFreq){
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
