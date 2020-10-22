import detalinfo.DetailProduct;
import detalinfo.Product;
import filecreate.CSVCreate;
import filecreate.CSVCreateDetailProduct;
import filecreate.CSVCreateProduct;
import logic.Parser;
import java.io.IOException;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //-------------------
    Parser parser = new Parser();
    CSVCreate csv;
        try {
            List<Product> list = parser.getItem();
            csv = new CSVCreateProduct(list);;
            List<DetailProduct> detailProductList = parser.getDetailsProduct(list);
            csv.createHeaders();
            csv.createCSV();
            csv = new CSVCreateDetailProduct(detailProductList);
            csv.createHeaders();
            csv.createCSV();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
