package com.zspps.store.libs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    public static String getHashData(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(data.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        }
        catch(NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
