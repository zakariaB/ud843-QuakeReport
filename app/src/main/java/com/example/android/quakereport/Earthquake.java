package com.example.android.quakereport;

import android.text.format.DateFormat;

import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 * Created by PcPc on 01/05/2017.
 */

public class Earthquake {
    /**
     *
     */
    private double mMagnitude;
    private String mPlace;
    private String mTime;

    /**
     *
     * @param mMagnitude
     * @param mPlace
     * @param mTime
     */
    public Earthquake(double mMagnitude, String mPlace, String mTime) {
        this.mMagnitude = mMagnitude;
        this.mPlace = mPlace;
        this.mTime = mTime;
    }

    /**
     *
     * @return
     */
    public double getmMagnitude() {
        return mMagnitude;
    }

    /**
     *
     * @return
     */
    public String getmPlace() {
        return mPlace;
    }

    /**
     *
     * @return
     */
    public String getmTime() {
        return mTime;
    }
}
