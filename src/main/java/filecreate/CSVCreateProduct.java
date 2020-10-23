package filecreate;

import detalinfo.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;


public class CSVCreateProduct  implements CSVCreate{
    String[] headers;
    List<Product> lsitems;

    public CSVCreateProduct(List<Product> lsitems) {
        this.lsitems = lsitems;

    }


    public void createHeaders(){
        Field[] fields = Product.class.getDeclaredFields();
        headers = new String[fields.length];
        int i=0;
        for (Field field : fields) {
            headers[i] =field.getName();
            i++;
        }

    }

    public String getHeaders() {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i <headers.length ; i++) {
            if (i!=headers.length-1)
            res.append(headers[i]+";");
        }
        return res.toString();
    }

    public void createCSV() throws IOException {

       FileWriter fileWriter = new FileWriter("textProduct.csv");
       fileWriter.write(getHeaders());
       fileWriter.append("\n");
       lsitems.stream().forEach(e->{
           try {
               fileWriter.append(e.toCSVWrite()+"\n");
           } catch (IOException ioException) {
               ioException.printStackTrace();
           }
       });
       fileWriter.close();
    }





}
