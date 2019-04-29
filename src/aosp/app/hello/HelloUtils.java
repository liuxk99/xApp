package aosp.app.hello;

import android.content.Context;
import android.content.Intent;

class HelloUtils {
    static void initService(Context context) {
        Intent i = new Intent(context, HelloService.class);
        i.setAction(HelloService.ACTION_INIT);
        context.startService(i);
    }
}
