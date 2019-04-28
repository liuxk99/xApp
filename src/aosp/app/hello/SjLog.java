package aosp.app.hello;

import android.util.Log;

class SjLog {
    private String mMsg;
    private static final String PREFIX_IN = "=> ";
    private static final String PREFIX_OUT = "<- ";

    SjLog(String msg) {
        mMsg = msg;
    }

    String inStr() {
        if (mMsg != null)
            return PREFIX_IN + mMsg;
        return PREFIX_IN;
    }

    String outStr() {
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
}
