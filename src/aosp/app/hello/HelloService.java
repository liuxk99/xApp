package aosp.app.hello;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import com.sj4a.utils.SjLog;
import com.sj4a.utils.SjLogGen;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class HelloService extends Service {
    final String TAG = HelloService.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);

    static final String ACTION_INIT = "aosp.app.hello.intent.action.INIT";
    private static final String ACTION_UPTIME = "aosp.app.hello.intent.action.UPTIME";

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
            } else if (ACTION_UPTIME.equals(a)) {
                actionUptime(intent.getExtras());
            }
            
            res = super.onStartCommand(intent, flags, startId);
        }
        sjLog.out();

        return res;
    }

    private void actionUptime(Bundle extras) {
        SjLog sjLog = mLogGen.build("actionUptime(" + extras + ")");
        sjLog.in();
        {
            Log.i(TAG, "uptime①:" + SystemClock.uptimeMillis());
            Log.i(TAG, "currentTime①:" + System.currentTimeMillis());
            {
                //{{ 回拨2S
                //{{ set current time 2 seconds backward.
                long currentTime = System.currentTimeMillis() - 2000;
                boolean res = SystemClock.setCurrentTimeMillis(currentTime);
                Log.i(TAG, res + " = setCurrentTimeMillis(" + currentTime + ")");
                if (res) {
                    Log.i(TAG, "currentTime:" + System.currentTimeMillis());
                }
                //}}

                try {
                    // sleep 0.5s
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // the uptime② is 0.5s more than uptime①
            Log.i(TAG, "uptime②:" + SystemClock.uptimeMillis());
            // the current time② is 1.5s less than current time①
            Log.i(TAG, "currentTime②:" + System.currentTimeMillis());
        }
        sjLog.out();
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
