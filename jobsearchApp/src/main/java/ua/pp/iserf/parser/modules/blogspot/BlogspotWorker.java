package ua.pp.iserf.parser.modules.blogspot;

import java.sql.Timestamp;

/**
 *
 * @author alex
 */
public class BlogspotWorker   implements Runnable {

    @Override
    public void run() {
        
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + "Blogspot Parser counter =" + counter);
            counter++;

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Blogspot Parser is interrupted!");
            }
        }

    }

}
