package aosp.app.hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class HelloReceiver extends BroadcastReceiver {
    static final String TAG = HelloReceiver.class.getSimpleName();

    public HelloReceiver() {
        super();

        SjLog log = new SjLog("HelloReceiver()");
        Log.d(TAG, log.in());

        Log.d(TAG, log.out());
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SjLog log = new SjLog("onReceive(" + context + ", " + intent + ",)");
        Log.d(TAG, log.in());
        final String a = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(a)) {
            doActionBootCompleted(intent.getExtras());
        }

        Log.d(TAG, log.out());
    }

    private void doActionBootCompleted(Bundle extras) {
        SjLog log = new SjLog("doActionBootCompleted(" + extras + ")");
        Log.d(TAG, log.in());

        Log.d(TAG, log.out());
    }
}
