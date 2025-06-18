package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;

public class FileWriter {

    public void saveToFile(String fileName, String result) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(result);
        } catch (Exception e) {
            System.out.println("An exception occurred");
        }
    }
}
