package ua.pp.iserf.parser.core;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author alex
 */
public class EmulateParser implements Runnable {

    AtomicInteger counter;
    public EmulateParser(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        while (Thread.currentThread().isInterrupted()==false) {
            // System.out.println("EmulateParser".getTimaee);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " counter="+counter.get());
            counter.incrementAndGet();

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                 Thread.currentThread().interrupt();
                System.out.println("EmulateParser is interrupted!");
            }
        }

    }


}
