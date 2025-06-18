package encryptdecrypt.encode;

public class UnicodeEncoder implements Encoder {

    @Override
    public String encode(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char x = data.charAt(i);
            x = (char) (x + key);
            result.append(x);
        }
        return result.toString();
    }
}
