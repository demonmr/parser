import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jcifs.smb.NtlmAuthenticator;
import jcifs.smb.NtlmPasswordAuthentication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Product> listElements;
    private WebDriver driver;
    private int maxSize = 50;
    public Parser() {
        this.listElements = new ArrayList<>();
    }
    public List<Product> getItem() throws IOException {
        Results product;
        //Аутентификация на прокси сервере
        NtlmAuthenticator.setDefault(new NtlmAuthenticator() {
            @Override
            protected NtlmPasswordAuthentication getNtlmPasswordAuthentication() {
                return new NtlmPasswordAuthentication("corp.local", "miroshnitchenko", "titaniuM-1996");
            }
        });

        ChromeOptions options = new ChromeOptions();
        if (!netIsAvailable()) {
            Proxy proxy = new Proxy();
            proxy.setHttpProxy("10.1.6.16:8080");
            options.setCapability("proxy", proxy);
        }
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);

        while (maxSize <= 200) {
            driver.get("https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery183022083401740659658_1603098902021&widget_id=5547572&platform=pc&limit=50&offset=" + maxSize + "&phase=1&productIds2Top=&postback=0cd58a2a-5c63-4d4f-b969-b70c6f0af63d&_=1603098964896");


            Document doc = Jsoup.parse(driver.getPageSource());
            Elements elements = doc.select("body");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String jsonString = elements.get(0).text();
            StringReader reader = new StringReader(jsonString.substring(jsonString.indexOf("(") + 1));
            product = mapper.readValue(reader, Results.class);
            if (product != null) {
               listElements.addAll(product.products);
            }
            maxSize+=maxSize;
        }
        driver.close();

        return listElements;
    }

    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("https://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }


}
