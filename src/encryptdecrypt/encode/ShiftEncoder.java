package encryptdecrypt.encode;

public class ShiftEncoder implements Encoder {

    @Override
    public String encode(String data, int key) {
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
}
