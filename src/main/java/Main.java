

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
