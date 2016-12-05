package edu.shu.com.shufinance.Utilities;

import android.util.Base64;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Encryption {


    SecretKeySpec secretKeySpec;
    byte[] encryptedByteArray, decryptedByteArray;
    String encryptedString, decryptedString;


    public String decryption(String decryptString) {
        try {
            // Get the Key
            byte[] key = "myshukeymyshukey".getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher c1 = Cipher.getInstance("AES");
            c1.init(Cipher.DECRYPT_MODE, secretKeySpec);
            decryptedByteArray = c1.doFinal(Base64.decode(decryptString, Base64.DEFAULT));

        } catch (Exception e) {

        }

        decryptedString = new String(decryptedByteArray);
        return decryptedString;
    }


    public String encryption(String encryptString) {

        try {
            // Get the Key
            byte[] key = "myshukeymyshukey".getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher c1 = Cipher.getInstance("AES");
            c1.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            encryptedByteArray = c1.doFinal(encryptString.getBytes());
        } catch (Exception e) {

        }

        encryptedString = Base64.encodeToString(encryptedByteArray, Base64.DEFAULT);
        return encryptedString;
    }


}