import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Main {
    public static void main(String[] args) {
        byte[] arrayOfByte = Base64.getDecoder().decode("5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=".getBytes(StandardCharsets.UTF_8));
        try {
            arrayOfByte = a(b("8d127684cbc37c17616d806cf50473cc"), arrayOfByte);
        } catch (Exception exception) {

        }

        System.out.println(new String(arrayOfByte));
    }

    public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(paramArrayOfbyte2);
    }

     public static byte[] b(String paramString) {
         int i = paramString.length();
         byte[] arrayOfByte = new byte[i / 2];
         for (byte b = 0; b < i; b += 2)
             arrayOfByte[b / 2] = (byte)(byte)((Character.digit(paramString.charAt(b), 16) << 4) + Character.digit(paramString.charAt(b + 1), 16));
         return arrayOfByte;
     }
}
