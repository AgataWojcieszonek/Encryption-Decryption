package encryptdecrypt;

import encryptdecrypt.config.ConfigCreator;
import encryptdecrypt.config.EncryptDecryptConfig;
import encryptdecrypt.decode.Decoder;
import encryptdecrypt.decode.DecoderFactory;
import encryptdecrypt.encode.Encoder;
import encryptdecrypt.encode.EncoderFactory;

public class EncodeDecodeHandler {

    private static final String ENC_MODE = "enc";
    private static final String DEC_MODE = "dec";

    public void codeData(String[] args) {
        ConfigCreator configCreator = new ConfigCreator();
        EncryptDecryptConfig config = configCreator.fromCommandLineArgs(args);
        String result = "";

        if (ENC_MODE.equals(config.mode())) {
            Encoder encoder = EncoderFactory.getEncoder(config.algorithm());
            result = encoder.encode(config.data(), config.key());
        } else if (DEC_MODE.equals(config.mode())) {
            Decoder decoder = DecoderFactory.getDecoder(config.algorithm());
            result = decoder.decode(config.data(), config.key());
        }

        logOutput(config.fileName(), result);
    }

    private void logOutput(String fileName, String result) {
        if (fileName == null) {
            System.out.println(result);
        } else {
            FileWriter fileWriter = new FileWriter();
            fileWriter.saveToFile(fileName, result);
        }
    }
}
