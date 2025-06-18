package encryptdecrypt.decode;

public class UnicodeDecoder implements Decoder {

    @Override
    public String decode(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            x = (char) (x - key);
            result.append(x);
        }
        return result.toString();
    }
}
