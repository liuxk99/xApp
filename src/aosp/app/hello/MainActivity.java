package aosp.app.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sj4a.utils.SjLog;
import com.sj4a.utils.SjLogGen;

public class MainActivity extends Activity {
    final String TAG = HelloService.class.getSimpleName();
    SjLogGen mLogGen = new SjLogGen(TAG);

    @Override
    protected void onDestroy() {
        SjLog sjLog = mLogGen.build("onDestroy()");
        sjLog.in();
        {
            super.onDestroy();
        }
        sjLog.out();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SjLog sjLog = mLogGen.build("onCreate(" + savedInstanceState + ")");
        sjLog.in();
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        sjLog.out();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity inStr AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
