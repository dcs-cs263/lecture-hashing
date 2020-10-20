public class HashExample {
    public static void main(String[] args) {
        while(true) {
            System.out.print("Enter password: ");
            String text = System.console().readLine();

            System.out.println();

            try {
                System.out.printf("md5(\"%s\")=\"%s\"\n", text, Utility.hash("MD5", text));
                System.out.printf("sha1(\"%s\")=\"%s\"\n", text, Utility.hash("SHA-1", text));
                System.out.printf("sha256(\"%s\")=\"%s\"\n", text, Utility.hash("SHA-256", text));
                System.out.printf("sha512(\"%s\")=\"%s\"\n", text, Utility.hash("SHA-512", text));
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            System.out.println();
        }
        
    }
}