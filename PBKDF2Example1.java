
public class PBKDF2Example1 {
    public static void main(String[] args) {
        final int baseIterations = 1000000;
        final int keySize = 256; // bits

        while(true) {
            System.out.print("Enter password: ");
            String text = System.console().readLine();
            // this is bad: don't ever hard-code your salt!
            // lab exercise is requiring you to do better
            String salt = "salt";

            System.out.println();

            try {
                for(int i=1; i<=5; i++) {
                    int iterations = baseIterations*i;

                    // obtain the current time
                    long start = System.nanoTime();

                    // generate the key
                    String key = Utility.pbkdf2(text, salt, iterations, keySize);
                    
                    // check how much time has elapsed
                    double duration = (System.nanoTime() - start) / 1000000000.0;

                    System.out.printf(
                        "pbkdf2(\"%s\", %d)=\"%s\" in %f seconds\n", 
                        text, iterations, key, duration
                    );
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            System.out.println();
        }
        
    }
}