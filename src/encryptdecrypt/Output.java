package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;

public class Output {

    public void getOutput(String fileName, String result) {
        if (fileName == null) {
            System.out.println(result);
        } else {
            File file = new File(fileName);
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println(result);
            } catch (Exception e) {
                System.out.println("An exception occurred");
            }
        }
    }
}
