package aosp.app.hello;

import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.SystemProperties;

import com.sj4a.utils.SjLog;
import com.sj4a.utils.SjLogGen;

public class HelloApp extends Application implements ServiceConnection {
    private String TAG = HelloApp.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);
    private IBinder mSerivce;

    @Override
    public void onLowMemory() {
        SjLog sjLog = mLogGen.build("onLowMemory()");
        sjLog.in();
        {
            super.onLowMemory();
        }
        sjLog.out();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        SjLog sjLog = mLogGen.build("onConfigurationChanged(" + newConfig + ")");
        sjLog.in();
        {
            super.onConfigurationChanged(newConfig);
        }
        sjLog.out();
    }

    @Override
    public void onTrimMemory(int level) {
        SjLog sjLog = mLogGen.build("onTrimMemory(" + level + ")");
        sjLog.in();
        {
            super.onTrimMemory(level);
        }
        sjLog.out();
    }

    @Override
    public void onCreate() {
        SjLog sjLog = mLogGen.build("onCreate()");
        sjLog.in();
        {
            super.onCreate();
            SystemProperties.get("ro.build.version");
            HelloUtils.initService(this);
//            bindService(i, this, 0x0);
        }
        sjLog.out();
    }

    @Override
    public void onTerminate() {
        SjLog sjLog = mLogGen.build("onTerminate()");
        sjLog.in();
        {
            unbindService(this);
            super.onTerminate();
        }
        sjLog.out();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        SjLog sjLog = mLogGen.build("onServiceConnected(" + name + ", " + service + ")");
        sjLog.in();
        {
            mSerivce = service;
        }
        sjLog.out();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        SjLog sjLog = mLogGen.build("onServiceConnected(" + name + ")");
        sjLog.in();
        {
            mSerivce = null;
        }
        sjLog.out();
    }
}
