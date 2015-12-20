package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;


public class HTTPUtils {

    public static InputStream getInputStrem(String url) throws IOException{
        URL mUrl = new URL("https://www.reddit.com/.json");
        HttpsURLConnection con = (HttpsURLConnection) mUrl.openConnection();
        InputStream in = con.getInputStream();
        return in;
    }


}
