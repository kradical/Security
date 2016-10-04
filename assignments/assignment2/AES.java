import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;

class Encrypt {
    private static byte[] sBox = javax.xml.bind.DatatypeConverter.parseHexBinary("637C777BF26B6FC53001672BFED7AB76CA82C97DFA5947F0ADD4A2AF9CA472C0B7FD9326363FF7CC34A5E5F171D8311504C723C31896059A071280E2EB27B27509832C1A1B6E5AA0523BD6B329E32F8453D100ED20FCB15B6ACBBE394A4C58CFD0EFAAFB434D338545F9027F503C9FA851A3408F929D38F5BCB6DA2110FFF3D2CD0C13EC5F974417C4A77E3D645D197360814FDC222A908846EEB814DE5E0BDBE0323A0A4906245CC2D3AC629195E479E7C8376D8DD54EA96C56F4EA657AAE08BA78252E1CA6B4C6E8DD741F4BBD8B8A703EB5664803F60E613557B986C11D9EE1F8981169D98E949B1E87E9CE5528DF8CA1890DBFE6426841992D0FB054BB16");

    public Encrypt() {
        System.out.println(Arrays.toString(sBox));
    }
}

class AES {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("USAGE:\tjava AES option keyFile inputFile");
            System.exit(0);
        }

        Encrypt en = new Encrypt();

        String option = args[0];
        String keyFileName = args[1];
        String inFileName = args[2];

        byte[] key = new byte[32];
        byte[] inBuffer = new byte[16];

        System.out.println(option + keyFileName + inFileName);

        try {
            FileInputStream keyStream = new FileInputStream(keyFileName);
            int bytesRead = keyStream.read(key);
            if(bytesRead != 64) {
                System.out.println("Error reading key, not 256 bits");
                System.exit(1);
            }

            FileInputStream inStream = new FileInputStream(inFileName);
            FileOutputStream outStream = new FileOutputStream(inFileName + ".enc");
            while(inStream.read(inBuffer) == 32) {
                if(option.equals("e")) {
                    encrypt(key, inBuffer, outStream);                    
                }

                inStream.read(); //read newline
            }
        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
            System.exit(1);
        }

        //System.out.println(Arrays.toString(key));
    }

    private static void encrypt(byte[] key, byte[] input, FileOutputStream output) throws IOException {
        // 14 rounds of encryption
        for(int i = 0; i < 14; i++) {
            // subBytes();
            // shiftRows();
            // mixColumns();
            // addRoundkey();
        }
        output.write(input);
    }
}