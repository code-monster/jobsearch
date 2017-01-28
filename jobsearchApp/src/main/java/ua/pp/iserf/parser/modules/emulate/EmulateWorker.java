package ua.pp.iserf.parser.modules.emulate;

import java.sql.Timestamp;

/**
 *
 * @author alex
 */
public class EmulateWorker  implements Runnable {

    @Override
    public void run() {
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + "Emulate Parser counter=" + counter);
            counter++;

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("EmulateParser is interrupted!");
            }
        }

    }

}
