package com.sj4a.utils;

import android.util.Log;

public class SjLog {
    private static final String PREFIX_IN = "=> ";
    private static final String PREFIX_OUT = "<- ";
    private String mMsg;
    private String mTag;

    SjLog(String tag) {
        mTag = tag;
    }

    void setMsg(final String msg) {
        mMsg = msg;
    }

    private String inStr() {
        if (mMsg != null)
            return PREFIX_IN + mMsg;
        return PREFIX_IN;
    }

    private String outStr() {
        if (mMsg != null)
            return PREFIX_OUT + mMsg;
        return PREFIX_OUT;
    }

    void inD(final String TAG) {
        Log.d(TAG, inStr());
    }

    void outD(final String TAG) {
        Log.d(TAG, outStr());
    }

    public void in() {
        if (mTag != null) {
            Log.d(mTag, inStr());
        }
    }

    public void out() {
        if (mTag != null) {
            Log.d(mTag, outStr());
        }
    }
}
