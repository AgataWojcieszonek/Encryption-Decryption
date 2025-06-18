package encryptdecrypt.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigCreator {

    private static final String MODE_ARG = "-mode";
    private static final String KEY_ARG = "-key";
    private static final String IN_ARG = "-in";
    private static final String DATA_ARG = "-data";
    private static final String OUT_ARG = "-out";
    private static final String ALG_ARG = "-alg";

    private static final String DEFAULT_ALGORITHM = "shift";
    private static final String DEFAULT_MODE = "enc";
    private static final String DEFAULT_KEY = "0";
    private static final String DEFAULT_DATA = "";

    public EncryptDecryptConfig fromCommandLineArgs(String[] args) {
        Map<String, String> argToValue = getArguments(args);
        String mode = argToValue.getOrDefault(MODE_ARG, DEFAULT_MODE);
        int key = Integer.parseInt(argToValue.getOrDefault(KEY_ARG, DEFAULT_KEY));
        String data = getData(argToValue);
        String fileName = argToValue.get(OUT_ARG);
        String algorithm = argToValue.getOrDefault(ALG_ARG, DEFAULT_ALGORITHM);

        return new EncryptDecryptConfig(mode, key, data, fileName, algorithm);
    }

    private Map<String, String> getArguments(String[] args) {
        Map<String, String> argToValue = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            String arg = args[i];
            String value = args[i + 1];
            argToValue.put(arg, value);
        }
        return argToValue;
    }

    private String getData(Map<String, String> argToValue) {
        if (argToValue.containsKey(DATA_ARG)) {
            return argToValue.get(DATA_ARG);
        } else if (argToValue.containsKey(IN_ARG)) {
            File file = new File(argToValue.get(IN_ARG));
            try (Scanner scanner = new Scanner(file)) {
                return scanner.nextLine();
            } catch (FileNotFoundException ignored) {
                return DEFAULT_DATA;
            }
        } else {
            return DEFAULT_DATA;
        }
    }
}
