package Utilities;

// Method that makes a small delay
public class Delays {
    public static void timeDelay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException ignored) {
        }
    }
}
