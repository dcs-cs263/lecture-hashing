import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidKeySpecException;

public class Utility {
    /**
     * Converts a byte array to a hexadecimal String representation.
     */
    public static String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer();
		for (byte b : buffer) {
			sb.append(String.format("%02x", b & 0xff));
        }
        
        return sb.toString();
    }

    public static String hash(String algorithm, String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(text.getBytes());
        byte[] digest = md.digest();
        
        return toHex(digest);
    }

    /**
     * Derives a key from a password.
     */
    public static String pbkdf2(String password, String salt, int iterations, int keySize) {
        // convert the username and password to char and byte arrays
        char[] pwd = password.toCharArray();
        byte[] slt = salt.getBytes();

        try {
            // initialise the crypto classes with the desired configuration
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(pwd, slt, iterations, keySize);

            // hash the password using the configuration
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();

            // return the hashed password as a hexadecimal string
            return toHex(res);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
