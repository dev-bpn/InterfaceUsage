package mvpaplica.bpn.com.mvpapplica;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by dipesh on 7/13/16.
 */
public class BackgroundTask extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ProgressDialog progressDialog;
    private BackgroundTaskResult backgroundTaskResult;

    public BackgroundTask(MainActivity mainActivity, ProgressDialog progressDialog) {
        this.context = mainActivity;
        this.progressDialog = progressDialog;
        backgroundTaskResult = (BackgroundTaskResult) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        backgroundTaskResult.onTaskDone("The task is finished successfully.");
        progressDialog.dismiss();
    }
}
