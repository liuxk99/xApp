package aosp.app.hello;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class HelloService extends Service {
    final String TAG = HelloService.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);

    static final String ACTION_INIT = "aosp.app.hello.intent.action.INIT";

    @Override
    public void onCreate() {
        SjLog sjLog = mLogGen.build("onCreate()");
        sjLog.in();
        {
            super.onCreate();
        }
        sjLog.out();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SjLog sjLog = mLogGen.build("onStartCommand(" + intent + ", " + flags + ", " + startId + ")");
        sjLog.in();
        int res = 0;
        {
            final String a = intent.getAction();
            if (ACTION_INIT.equals(a)) {
                actionInit(intent.getExtras());
            }
            res = super.onStartCommand(intent, flags, startId);
        }
        sjLog.out();

        return res;
    }

    private void actionInit(Bundle extras) {
        SjLog sjLog = mLogGen.build("actionInit(" + extras + ")");
        sjLog.in();
        {
            HelloUtils.initService(this);
        }
        sjLog.out();
    }

    @Override
    public void onDestroy() {
        SjLog sjLog = mLogGen.build("onDestroy()");
        sjLog.in();
        {
            super.onDestroy();
        }
        sjLog.out();
    }

    @Override
    public IBinder onBind(Intent intent) {
        SjLog sjLog = mLogGen.build("onBind(" + intent + ")");
        sjLog.in();
        sjLog.out();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        SjLog sjLog = mLogGen.build("onUnbind(" + intent + ")");
        sjLog.in();
        boolean res;
        {
            res = super.onUnbind(intent);
        }
        sjLog.out();
        return res;
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
    }
}
