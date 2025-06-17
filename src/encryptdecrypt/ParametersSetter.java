package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParametersSetter {
    public void setParameters(String[] args, Coder coder) {
        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i]) && ("enc".equals(args[i + 1]) || "dec".equals(args[i + 1]))) {
                coder.setMode(args[i + 1]);
            } else if ("-key".equals(args[i]) && new Scanner(args[i + 1]).hasNextInt()) {
                coder.setKey(Integer.parseInt(args[i + 1]));
            } else if ("-in".equals(args[i]) && coder.getData().isEmpty() && new Scanner(args[i + 1]).hasNextLine()) {
                File file = new File(args[i + 1]);
                try (Scanner scanner = new Scanner(file)) {
                    coder.setData(scanner.nextLine());
                } catch (FileNotFoundException ignored) {
                }
            } else if ("-data".equals(args[i]) && new Scanner(args[i + 1]).hasNextLine()) {
                coder.setData(args[i + 1]);
            } else if ("-out".equals(args[i]) && new Scanner(args[i + 1]).hasNextLine()) {
                coder.setFileName(args[i + 1]);
            } else if ("-alg".equals(args[i]) && ("unicode".equals(args[i + 1]) || "shift".equals(args[i + 1]))) {
                coder.setAlgorithm(args[i + 1]);
            }
        }
    }
}
