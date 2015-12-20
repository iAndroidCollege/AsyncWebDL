package college.edu.tomer.asyncwebdl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import utils.HTTPUtils;
import utils.IOUtils;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tvJson)
    TextView tvJson;
    @Bind(R.id.fab)
    FloatingActionButton fab;


    private final static String FEED_URL = "https://www.reddit.com/.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlWithThread();
            }
        });
    }

    private void dlWithThread() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dlJsonToTextView();
            }
        });

        t1.start();
    }

    private void dlJsonToTextView() {
        try {
            InputStream in = HTTPUtils.getInputStrem(FEED_URL);
            final String response = IOUtils.readStream(in);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvJson.setText(response);
                }
            });
        } catch (IOException e) {
           e.getMessage();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
