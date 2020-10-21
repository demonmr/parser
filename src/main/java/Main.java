



import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeFilter;

import java.io.IOException;

import java.io.StringReader;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

      //  WebClient webClient = new WebClient(BrowserVersion.CHROME);
      //  webClient.getOptions().setCssEnabled(false);
       // webClient.getOptions().setJavaScriptEnabled(false);
        //webClient.getCookieManager().setCookiesEnabled(true);
      //  webClient.waitForBackgroundJavaScript(60*1000);


        //HtmlPage htmlPage = webClient.getPage("https://aliexpress.ru/item/33044479054.html");
   //     System.out.println(htmlPage.asXml());
        Document doc = Jsoup.connect("https://aliexpress.ru/item/33044479054.html")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
    //    System.out.println(doc.select("product-description").html());
        System.out.println(doc.html());
            String html = doc.select("script").html();
          //  String json = html.substring(html.indexOf("data:"));
            String[] split = html.split("data: ");
      //  System.out.println(split[1]);

            StringReader reader = new StringReader(split[1]);
            ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            DetailProduct detailProduct = mapper.readValue(reader,DetailProduct.class);
        System.out.println(detailProduct.toString());









    Parser parser = new Parser();
    CSVCreate csv;
        try {
            List<Product> list = parser.getItem();
            csv = new CSVCreate(list);
            csv.setHeaders();
            csv.createCSV();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
