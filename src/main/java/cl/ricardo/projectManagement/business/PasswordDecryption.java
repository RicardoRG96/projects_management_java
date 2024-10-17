package cl.ricardo.projectManagement.business;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class PasswordDecryption {
    
    public static String decrypt(byte[] cipherText, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv); 
        byte[] plainText = cipher.doFinal(cipherText);
        return new String(plainText);
    }
    
}
