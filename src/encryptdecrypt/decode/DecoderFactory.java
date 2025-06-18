package encryptdecrypt.decode;

public class DecoderFactory {

    private static final String SHIFT_ALG = "shift";
    private static final String UNICODE_ALG = "unicode";

    public static Decoder getDecoder(String algorithm) {
        return switch (algorithm) {
            case SHIFT_ALG -> new ShiftDecoder();
            case UNICODE_ALG -> new UnicodeDecoder();
            case null, default -> throw new IllegalArgumentException("Unexpected algorithm type");
        };
    }
}
