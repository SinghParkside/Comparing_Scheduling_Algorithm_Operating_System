/**
 * Creates the nap time
 */
import java.nio.Buffer;

public class SleepUtilities   {
    public static void nap() {
        nap(NAP_TIME);
    }
    /**
     * Nap between zero and duration seconds.
     */
    public static void nap(int duration) {
        int sleeptime = duration;
        try { Thread.sleep(sleeptime*1000);}
        catch (InterruptedException e) {}
    }
    private static final int NAP_TIME = 5;
    private Buffer buffer;
}
