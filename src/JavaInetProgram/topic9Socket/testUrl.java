package JavaInetProgram.topic9Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mr_liang on 2017/3/1 using IDEA.
 */
public class testUrl {
    public static void main(String args[]) throws IOException {
        URL url = new URL("http://www.baidu.com");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
    }
}
