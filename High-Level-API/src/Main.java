import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
//             Absoluter URI
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//             Relative URI
//            URI uri = new URI("/catalogue/phones?os=android#samsung");

            URI baseURI = new URI("http://username:password@myserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedURI1 = baseURI.resolve(uri1);
            URI resolvedURI2 = baseURI.resolve(uri2);
            URI resolvedURI3 = baseURI.resolve(uri3);

            URL url1 = resolvedURI1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedURI2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedURI3.toURL();
            System.out.println("URL 3 = " + url3);

            URI relativizedURI = baseURI.relativize(resolvedURI2);
            System.out.println("Relative URI = " + relativizedURI);


        }catch (MalformedURLException e){
            System.out.println("Malforemd URL: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}