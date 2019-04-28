package aosp.app.hello;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class HelloApp extends Application {
    private String TAG = HelloApp.class.getSimpleName();

    @Override
    public void onCreate() {
        SjLog log = new SjLog("onCreate()");
        Log.d(TAG, log.in());

        super.onCreate();
        if (!HelloService.mInitialized) {
            Intent i = new Intent(this, HelloService.class);
            i.setAction(HelloService.ACTION_INIT);
            startService(i);
        }

        Log.d(TAG, log.out());
    }

    @Override
    public void onTerminate() {
        SjLog log = new SjLog("onTerminate()");
        Log.d(TAG, log.in());

        super.onTerminate();

        Log.d(TAG, log.out());
    }
}
