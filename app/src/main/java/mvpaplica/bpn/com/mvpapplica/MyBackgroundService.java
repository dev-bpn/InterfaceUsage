package mvpaplica.bpn.com.mvpapplica;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by dipesh on 7/13/16.
 */
public class MyBackgroundService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */

    public MyBackgroundService() {
        super("name");

    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this , "Service started." , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            /** Service is long running task with no UI. I think data is not needed to pass from one to another object or class*/

            Toast.makeText(this , "successfully completed." , Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this , "Service destroyed." , Toast.LENGTH_LONG).show();
    }
}
