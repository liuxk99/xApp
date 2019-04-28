package aosp.app.hello;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class HelloApp extends Application implements ServiceConnection {
    private String TAG = HelloApp.class.getSimpleName();
    private IBinder mSerivce;

    @Override
    public void onCreate() {
        SjLog log = new SjLog("onCreate()");
        Log.d(TAG, log.inStr());

        super.onCreate();
        if (!HelloService.mInitialized) {
            Intent i = new Intent(this, HelloService.class);
            i.setAction(HelloService.ACTION_INIT);
//            startService(i);
            bindService(i, this, 0x0);
        }

        Log.d(TAG, log.outStr());
    }

    @Override
    public void onTerminate() {
        SjLog log = new SjLog("onTerminate()");
        Log.d(TAG, log.inStr());

        unbindService(this);
        super.onTerminate();

        Log.d(TAG, log.outStr());
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        SjLog log = new SjLog("onServiceConnected(" + name + ", " + service + ")");
        log.inD(TAG);

        mSerivce = service;

        log.outD(TAG);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        SjLog log = new SjLog("onServiceConnected(" + name + ")");
        log.inD(TAG);

        mSerivce = null;

        log.outD(TAG);
    }
}
