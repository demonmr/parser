package logic;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import detalinfo.DetailProduct;
import detalinfo.Product;
import detalinfo.Results;
import jcifs.smb.NtlmAuthenticator;
import jcifs.smb.NtlmPasswordAuthentication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.*;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    Proxy proxy;
    private List<Product> listElements;
    private List<DetailProduct> listDetails;
    private int maxSize = 20;
    private int limit = 20;
    URLConnection urlConnection;
    private boolean connected;
    private NtlmAuthenticator ntlmPasswordAuthentication = null;
    public Parser() {
        listDetails = new ArrayList<>(100);
        this.listElements = new ArrayList<>();

        this.connected = netIsAvailable();
        if (!connected)
        {
            ntlmPasswordAuthentication = new NtlmAuthenticator() {
                @Override
                protected NtlmPasswordAuthentication getNtlmPasswordAuthentication() {
                    return new NtlmPasswordAuthentication("corp.local", "miroshnitchenko", "titaniuM-1996");
                }
            };
            proxy = new Proxy(Type.HTTP, new InetSocketAddress("10.1.6.16", 8080));
        }
    }


    public List<Product> getItem() {
        Results product;

        try {
            //Аутентификация на прокси сервере
            // Create the TelegramBotsApi object to register your bots
            NtlmAuthenticator.setDefault(ntlmPasswordAuthentication);



            while (maxSize <= 105) {
                URL url = new URL("https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery1830136674710649618_1603270332269&widget_id=5547572&platform=pc&limit=" + limit + "&offset=" + maxSize + "&phase=1&productIds2Top=&postback=d46b8192-a8b9-4761-8cb2-aed5f6202f9d&_=1603270642360");
                if (!connected) {
                    urlConnection = url.openConnection(proxy);
                }else{
                    urlConnection = url.openConnection();
                }
                urlConnection.connect();

                //Reader io = urlConnection.getInputStream();

                Scanner scanner = new Scanner(urlConnection.getInputStream());
                StringBuilder text = new StringBuilder();
                while (scanner.hasNext())
                {
                    text.append(scanner.next());
                }



                Document doc = Jsoup.parse(text.toString());
                Elements elements = doc.select("body");
                ObjectMapper mapper = new ObjectMapper();
              //  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                String jsonString = elements.get(0).text();
                StringReader reader = new StringReader(jsonString.substring(jsonString.indexOf("(") + 1));
                product = mapper.readValue(reader, Results.class);

                if (product != null) {
                    //listDetails.addAll(getDetailsProduct(product.products));
                    listElements.addAll(product.products);
                }
                maxSize += (limit+1);

            }


            return listElements;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DetailProduct> getDetailsProduct(List<Product> products)  {
      List<DetailProduct> detailProductList =new ArrayList<>();
      if (!connected){
          NtlmAuthenticator.setDefault(new NtlmAuthenticator() {
              @Override
              protected NtlmPasswordAuthentication getNtlmPasswordAuthentication() {
                  return new NtlmPasswordAuthentication("corp.local", "miroshnitchenko", "titaniuM-1996");
              }
          });

      }
                proxy  = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.1.6.16", 8080));
                products.stream().forEach(e-> {
                    try {
                        Document doc=null;
                        if (!connected) {
                            doc = Jsoup.connect("https:"+e.getDetailUrl()).proxy(proxy)
                                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                                .referrer("http://www.google.com")
                                .get();
                    }else
                    {
                                 doc = Jsoup.connect("https:"+e.getDetailUrl())
                                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                                .referrer("http://www.google.com")
                                .get();
                    }

                    String html = doc.select("script").html();
                    String[] split = html.split("data: ");
                    StringReader reader = new StringReader(split[1]);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                    DetailProduct detailProduct = mapper.readValue(reader, DetailProduct.class);
                    if  (detailProduct!=null){
                        detailProductList.add(detailProduct);
                    }
                }catch (IOException ex) {
                        ex.printStackTrace();
                }
                });
                return detailProductList;

    }



    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("https://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.setReadTimeout(1000);
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
