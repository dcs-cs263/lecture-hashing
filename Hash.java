import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private static String toHex(byte[] buffer) {
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

    public static void main(String[] args) {
        while(true) {
            System.out.print("Enter password: ");
            String text = System.console().readLine();

            System.out.println();

            try {
                System.out.printf("md5(\"%s\")=\"%s\"\n", text, hash("MD5", text));
                System.out.printf("sha1(\"%s\")=\"%s\"\n", text, hash("SHA-1", text));
                System.out.printf("sha256(\"%s\")=\"%s\"\n", text, hash("SHA-256", text));
                System.out.printf("sha512(\"%s\")=\"%s\"\n", text, hash("SHA-512", text));
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            System.out.println();
        }
        
    }
}