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
    private long mTime;
    private String mUrl;

    public String getmUrl() {
        return mUrl;
    }

    /**
     * @param mMagnitude
     * @param mPlace
     * @param mTime
     * @param url
     */
    public Earthquake(double mMagnitude, String mPlace, long mTime, String url) {
        this.mMagnitude = mMagnitude;
        this.mPlace = mPlace;
        this.mTime = mTime;
        mUrl = url;

    }

    /**
     * @return
     */
    public double getmMagnitude() {
        return mMagnitude;
    }

    /**
     * @return
     */
    public String getmPlace() {
        return mPlace;
    }

    /**
     * @return
     */
    public long getmTime() {
        return mTime;
    }
}
