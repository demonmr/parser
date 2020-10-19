import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    Parser parser = new Parser();
        try {
            List<Product> list = parser.getItem();
            System.out.println(list.size());
            list.stream().forEach(System.out::println);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
