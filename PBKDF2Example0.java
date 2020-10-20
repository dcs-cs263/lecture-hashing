
public class PBKDF2Example0 {
    public static void main(String[] args) {
        final int iterations = 5;
        final int keySize = 16; // bits

        while(true) {
            System.out.print("Enter password: ");
            String text = System.console().readLine();
            // this is bad: don't ever hard-code your salt!
            // lab exercise is requiring you to do better
            String salt = "salt";

            System.out.println();

            try {
                System.out.printf(
                    "pbkdf2(\"%s\")=\"%s\"\n", 
                    text, 
                    Utility.pbkdf2(text, salt, iterations, keySize)
                );
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            System.out.println();
        }
        
    }
}