package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPass {
    public static String hasher(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash=md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString=new StringBuilder();

            for (byte b: hash){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Ez da algoritmoa aurkitu");
        }
        return null;
    }

}
