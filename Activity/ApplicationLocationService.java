package com.example.vishaldeepsingh.vsafe.Activity;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
//import android.content.pm.PackageManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;


/**
 * Created by Vishaldeep Singh on 09-Oct-16.
 */

public class ApplicationLocationService extends Service implements LocationListener {
    protected LocationManager locationManager;
    Location location;
    private static final long MIN_DISTANCE_FOR_UPDATE = 10;
    private static final long MIN_TIME_FOR_UPDATE = 1000 * 60 * 1;

    public ApplicationLocationService(Context context) {
        // TODO Auto-generated constructor stub

        locationManager = (LocationManager) context
                .getSystemService(LOCATION_SERVICE);
    }

    public Location getLocation(String provider) throws SecurityException {
        if (locationManager.isProviderEnabled(provider))
        {


            locationManager.requestLocationUpdates(provider, MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
            if (locationManager != null)
            {
                location = locationManager.getLastKnownLocation(provider);
                return location;
            }
        }
        return null;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

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
}
