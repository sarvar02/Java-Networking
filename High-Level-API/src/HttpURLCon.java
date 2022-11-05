import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLCon {

    private final static String ADDRESS = "https://www.flickr.com/services/feeds/photos_public.gne?tags=dogs";

    public static void main(String[] args) {
        try {
            URL url = new URL(ADDRESS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            // if an operation depends on being connected to work,
            // it'll actually perform the connection where necessary

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);

            if(responseCode != 200){
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String line;

            while ((line = inputReader.readLine()) != null) {
                line = inputReader.readLine();
                System.out.println(line);
            }
            inputReader.close();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
