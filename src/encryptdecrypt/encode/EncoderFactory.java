package encryptdecrypt.encode;

public class EncoderFactory {

    private static final String SHIFT_ALG = "shift";
    private static final String UNICODE_ALG = "unicode";

    public static Encoder getEncoder(String algorithm) {
        return switch (algorithm) {
            case SHIFT_ALG -> new ShiftEncoder();
            case UNICODE_ALG -> new UnicodeEncoder();
            case null, default -> throw new IllegalArgumentException("Unexpected algorithm type");
        };
    }
}
