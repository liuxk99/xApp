package aosp.app.hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class BootCompletedReceiver extends BroadcastReceiver {
    static final String TAG = BootCompletedReceiver.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);
    private Context mContext;

    public BootCompletedReceiver() {
        super();
        SjLog sjLog = mLogGen.build("BootCompletedReceiver()");
        sjLog.in();
        {
        }
        sjLog.in();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SjLog sjLog = mLogGen.build("onReceive(" + context + ", " + intent + ",)");
        sjLog.in();
        {
            mContext = context;
            final String a = intent.getAction();
            if (Intent.ACTION_BOOT_COMPLETED.equals(a)) {
                doActionBootCompleted(intent.getExtras());
            }
        }
        sjLog.out();
    }

    private void doActionBootCompleted(Bundle extras) {
        SjLog sjLog = mLogGen.build("doActionBootCompleted(" + extras + ")");
        sjLog.in();
        {
            if (!HelloUtils.mInitialized) {
                HelloUtils.initService(mContext);
            }
        }
        sjLog.out();
    }
}
