package com.sj4a.utils.pkg;

import android.app.Service;
import android.content.Intent;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.sj4a.utils.SjLog;
import com.sj4a.utils.SjLogGen;

import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import static android.content.pm.PackageManager.INSTALL_REPLACE_EXISTING;

public class PkgService extends Service {
    final String TAG = PkgService.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);

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
            if (PkgConstants.ACTION_INSTALL.equals(a)) {
                actionInstall(intent.getExtras());
            }
            res = super.onStartCommand(intent, flags, startId);
        }
        sjLog.out();

        return res;
    }

    private void actionInstall(Bundle extras) {
        SjLog sjLog = mLogGen.build("actionInstall(" + extras + ")");
        sjLog.in();
        {
            final String pkgFile = extras.getString("pkg_file");
            PackageManager pm = this.getPackageManager();
            PkgUtils.installPackage(pm,
                    new File(pkgFile),
                    new PackageInstallObserver(),
                    INSTALL_REPLACE_EXISTING,
                    getPackageName());
        }
        sjLog.out();
    }

    class PackageInstallObserver extends IPackageInstallObserver.Stub {
        public void packageInstalled(String packageName, int returnCode) {
            Log.i(TAG, "packageName: " + packageName + "; returnCode: " + returnCode);
        }
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
