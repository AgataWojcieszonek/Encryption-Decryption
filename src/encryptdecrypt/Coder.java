package encryptdecrypt;

public class Coder {
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String fileName = null;
    private String algorithm = "shift";
    private final ParametersSetter parametersSetter = new ParametersSetter();
    private final Output output = new Output();

    public void codeData(String[] args, Coder coder) {
        parametersSetter.setParameters(args, coder);
        String result = "";
        if (algorithm.equals("unicode") && mode.equals("enc")) {
            result = encryptionWithUnicode(data, key);
        } else if (algorithm.equals("unicode") && mode.equals("dec")) {
            result = decryptionWithUnicode(data, key);
        } else if (algorithm.equals("shift") && mode.equals("enc")) {
            result = encryptionWithShift(data, key);
        } else if (algorithm.equals("shift") && mode.equals("dec")) {
            result = decryptionWithShift(data, key);
        }
        output.getOutput(fileName, result);
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    private String encryptionWithShift(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            if (x >= 'a' && x <= 'z') {
                x = (char) ((x - 'a' + key) % 26 + 'a');
            }
            if (x >= 'A' && x <= 'Z') {
                x = (char) ((x - 'A' + key) % 26 + 'A');
            }
            result.append(x);
        }
        return result.toString();
    }

    private String decryptionWithShift(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            if (x >= 'a' && x <= 'z') {
                x = (char) ((26 + x - 'a' - key) % 26 + 'a');
            }
            if (x >= 'A' && x <= 'Z') {
                x = (char) ((26 + x - 'A' - key) % 26 + 'A');
            }
            result.append(x);
        }
        return result.toString();
    }

    private String encryptionWithUnicode(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            x = (char) (x + key);
            result.append(x);
        }
        return result.toString();
    }

    private String decryptionWithUnicode(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            x = (char) (x - key);
            result.append(x);
        }
        return result.toString();
    }
}
