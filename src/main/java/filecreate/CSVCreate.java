package filecreate;

import java.io.IOException;

public interface CSVCreate {
    void createCSV() throws IOException;
    void createHeaders();
    String getHeaders();
}
