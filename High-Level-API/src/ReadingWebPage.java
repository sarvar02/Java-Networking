import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ReadingWebPage {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            // First way
//            BufferedReader inputStreamReader = new BufferedReader(
//                    new InputStreamReader(url.openStream())
//            );

            // Second way
            BufferedReader inputStreamReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream())
            );

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()){
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.println("----- key = " + key);
                for (String val : values){
                    System.out.println("Value = " + values);
                }
            }

            // Reading web page
//            String line = "";
//            while (line != null) {
//                line = inputStreamReader.readLine();
//                System.out.println(line);
//            }
//            inputStreamReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
