package aosp.app.hello;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class HelloService extends Service {
    final String TAG = HelloService.class.getSimpleName();

    static final String ACTION_INIT = "aosp.app.hello.intent.action.INIT";

    @Override
    public void onCreate() {
        SjLog log = new SjLog("onCreate()");
        Log.d(TAG, log.inStr());

        super.onCreate();
        Log.d(TAG, log.outStr());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SjLog log = new SjLog("onStartCommand(" + intent + ", " + flags + ", " + startId + ")");
        Log.d(TAG, log.inStr());

        final String a = intent.getAction();
        if (ACTION_INIT.equals(a)) {
            actionInit(intent.getExtras());
        }

        Log.d(TAG, log.outStr());
        return super.onStartCommand(intent, flags, startId);
    }

    private void actionInit(Bundle extras) {
        SjLog log = new SjLog("actionInit(" + extras + ")");
        Log.d(TAG, log.inStr());

        HelloUtils.initService(this);

        Log.d(TAG, log.outStr());
    }

    @Override
    public void onDestroy() {
        SjLog log = new SjLog("onDestroy()");
        Log.d(TAG, log.inStr());

        super.onDestroy();

        Log.d(TAG, log.outStr());
    }

    @Override
    public IBinder onBind(Intent intent) {
        SjLog log = new SjLog("onBind(" + intent + ")");
        Log.d(TAG, log.inStr());

        Log.d(TAG, log.outStr());
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        SjLog log = new SjLog("onUnbind(" + intent + ")");
        Log.d(TAG, log.inStr());

        Log.d(TAG, log.outStr());
        return super.onUnbind(intent);
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
    }
}
