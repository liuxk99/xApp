package aosp.app.hello;

import android.content.Context;
import android.content.Intent;

class HelloUtils {
    private static final String TAG = HelloUtils.class.getSimpleName();

    static boolean mInitialized = false;

    static void initService(Context context) {
        SjLog sjLog = new SjLog("initService(" + context + ")");
        sjLog.inD(TAG);

        if (!mInitialized) {
            doInit(context);
            mInitialized = true;
        }

        sjLog.outD(TAG);
    }

    private static void doInit(Context context) {
        SjLog sjLog = new SjLog("doInit(" + context + ")");
        sjLog.inD(TAG);

        Intent i = new Intent(context, HelloService.class);
        i.setAction(HelloService.ACTION_INIT);
        context.startService(i);

        sjLog.outD(TAG);
    }
}
