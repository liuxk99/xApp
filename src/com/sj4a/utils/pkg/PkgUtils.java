package com.sj4a.utils.pkg;

import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.sj4a.utils.SjLog;
import com.sj4a.utils.SjLogGen;

import java.io.File;

class PkgUtils {
    private static final String TAG = PkgUtils.class.getSimpleName();
    private static final SjLogGen mLogGen = new SjLogGen(TAG);

    public static void installPackage(
            PackageManager pm, File packageFile, IPackageInstallObserver observer, int flags,
            String installerPackageName) {
        SjLog sjLog = mLogGen.build("installPackage(" + pm
                + ", " + packageFile
                + ", " + observer
                + ", " + flags
                + ", " + installerPackageName
                + ")");
        sjLog.in();
        {
            if (pm != null) {
                pm.installPackage(Uri.fromFile(packageFile), observer, flags, installerPackageName);
            }
        }
        sjLog.out();
    }
}
