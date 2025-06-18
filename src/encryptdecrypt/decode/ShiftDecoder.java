package encryptdecrypt.decode;

public class ShiftDecoder implements Decoder {

    @Override
    public String decode(String data, int key) {
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
}
