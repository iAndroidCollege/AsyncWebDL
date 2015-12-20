package dal;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import utils.HTTPUtils;
import utils.IOUtils;

/**
 * Created by master on 20/12/15.
 */
public class WebDLAsyncTask extends AsyncTask<String, Integer, String> {
    private TextView tvJsonWeb;

    public WebDLAsyncTask(TextView tvJsonWeb) {
        this.tvJsonWeb = tvJsonWeb;
    }

    //Run a Job On The Background Thread
    @Override
    protected String doInBackground(String... params) {
        try {
            InputStream in = HTTPUtils.getInputStrem(params[0]);
            String response = IOUtils.readStream(in);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Runs on UI Thread. Report progress here.
    @Override
    protected void onProgressUpdate(Integer... values) {

    }

    //Report the result to the caller
    //Runs On UI thread.
    @Override
    protected void onPostExecute(String response) {
        tvJsonWeb.setText(response);
    }
}
