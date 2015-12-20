package dal;

import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import entities.Reddit;
import utils.HTTPUtils;
import utils.IOUtils;

/**
 * Created by master on 20/12/15.
 */
public class WebDLAsyncTask extends AsyncTask<String, Integer, ArrayList<Reddit>> {
    private TextView tvJsonWeb;

    public WebDLAsyncTask(TextView tvJsonWeb) {
        this.tvJsonWeb = tvJsonWeb;
    }

    //Run a Job On The Background Thread
    @Override
    protected ArrayList<Reddit> doInBackground(String... params) {
        try {
            InputStream in = HTTPUtils.getInputStrem(params[0]);
            String response = IOUtils.readStream(in);

            return redditsFromJson(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private ArrayList<Reddit> redditsFromJson(String json){
        ArrayList<Reddit> reddits = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(json).getJSONObject("data");
            JSONArray children = data.getJSONArray("children");
            for (int i = 0; i < children.length(); i++) {
                JSONObject childData = children.getJSONObject(i).getJSONObject("data");

                Gson gson = new Gson();
                Reddit reddit = gson.fromJson(childData.toString(), Reddit.class);

//                String title = childData.getString("title");
//                String thumb = childData.getString("thumbnail");
//                Long created_utc = childData.getLong("created_utc");
//
//
//                Reddit r = new Reddit(title, thumb, new DateTime(created_utc*1000));
                reddits.add(reddit);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reddits;
    }
    //Runs on UI Thread. Report progress here.
    @Override
    protected void onProgressUpdate(Integer... values) {

    }

    //Report the result to the caller
    //Runs On UI thread.
    @Override
    protected void onPostExecute(ArrayList<Reddit> response) {
        String total = "";
        for (int i = 0; i < response.size(); i++) {
            total += response.get(i).toString() + "\n\n\n";
        }

        tvJsonWeb.setText(total);
    }
}
