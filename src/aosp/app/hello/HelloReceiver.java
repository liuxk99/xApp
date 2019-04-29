package aosp.app.hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class HelloReceiver extends BroadcastReceiver {
    static final String TAG = HelloReceiver.class.getSimpleName();
    private Context mContext;

    public HelloReceiver() {
        super();

        SjLog log = new SjLog("HelloReceiver()");
        log.inD(TAG);

        log.outD(TAG);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SjLog log = new SjLog("onReceive(" + context + ", " + intent + ",)");
        log.inD(TAG);

        mContext = context;
        final String a = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(a)) {
            doActionBootCompleted(intent.getExtras());
        }

        log.outD(TAG);
    }

    private void doActionBootCompleted(Bundle extras) {
        SjLog log = new SjLog("doActionBootCompleted(" + extras + ")");
        log.inD(TAG);

        HelloUtils.initService(mContext);
        log.outD(TAG);
    }
}
