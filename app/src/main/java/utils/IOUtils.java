package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by master on 20/12/15.
 */
public class IOUtils {

    public static String readStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();

        String line = null;

        while ((line = reader.readLine())!=null){
            total.append(line);
        }
        reader.close();
        return total.toString();
    }
}
