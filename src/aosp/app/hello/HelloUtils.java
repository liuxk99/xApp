package aosp.app.hello;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.io.File;

class HelloUtils {
    private static final String TAG = HelloUtils.class.getSimpleName();
    private static SjLogGen mLogGen = new SjLogGen(TAG);

    static boolean mInitialized = false;

    private static void doInit(Context context) {
        SjLog sjLog = mLogGen.build("doInit(" + context + ")");
        sjLog.in();
        {
            Intent i = new Intent(context, HelloService.class);
            i.setAction(HelloService.ACTION_INIT);
            context.startService(i);
        }
        sjLog.out();
    }

    static void initService(Context context) {
        SjLog sjLog = mLogGen.build("initService(" + context + ")");
        sjLog.in();
        {
            if (!mInitialized) {
                doInit(context);
                mInitialized = true;
            }
        }
        sjLog.out();
    }

    public static void installPackage(
            PackageManager pm, File packageFile, IPackageInstallObserver observer, int flags,
            String installerPackageName) {
        if (pm != null) {
            pm.installPackage(Uri.fromFile(packageFile), observer, flags, installerPackageName);
        }
    }
}
