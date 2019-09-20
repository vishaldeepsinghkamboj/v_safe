package com.example.vishaldeepsingh.vsafe.Activity;

/**
 * Created by Vishaldeep Singh on 09-Oct-16.
 */
public interface AccelerometerListener {
    public void onShake(float force);

    void onAccelerationChanged(float x, float y, float z);
}
