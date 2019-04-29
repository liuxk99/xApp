package aosp.app.hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class BootCompletedReceiver extends BroadcastReceiver {
    static final String TAG = BootCompletedReceiver.class.getSimpleName();
    private Context mContext;

    public BootCompletedReceiver() {
        super();

        SjLog log = new SjLog("BootCompletedReceiver()");
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

        if (!HelloUtils.mInitialized) {
            HelloUtils.initService(mContext);
        }
        log.outD(TAG);
    }
}
