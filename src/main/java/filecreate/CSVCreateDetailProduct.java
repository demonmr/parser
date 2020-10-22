package filecreate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import detalinfo.DetailProduct;


import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVCreateDetailProduct implements CSVCreate {
    List<String> headers;
    List<DetailProduct> lsitems;

    public CSVCreateDetailProduct(List<DetailProduct> lsitems) {
        this.lsitems = lsitems;

    }


    public void createHeaders() {
        Field[] fields = DetailProduct.class.getDeclaredFields();
        List<String> headers = new ArrayList<>();
        int i = 0;
        for (Field field : fields) {
            //    System.out.println(field.getType()+"\n"+field.getType().getSimpleName());
            if (!field.getType().getSimpleName().equals("String")) {
                Class cls = field.getType();
                //System.out.println(cls.getName());
                for (Field field2 : cls.getDeclaredFields()
                ) {
                    if (field2.isAnnotationPresent(JsonProperty.class))
                    headers.add(field2.getName());
                }

            }
            else {
                headers.add(field.getName());
            }
        }

        this.headers = headers;
    }

    public String getHeaders() {
        StringBuilder res = new StringBuilder();
        headers.stream().forEach(e -> {
            res.append(e + ";");

        });
        return res.toString();
    }

    public void createCSV() throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/textDetailProduct.csv"), StandardCharsets.UTF_8);) {


            writer.write(getHeaders());
            writer.append("\n");
            lsitems.stream().forEach(e -> {
                try {
                    writer.append(e.toCSVWrite() + "\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

        }
    }


}
