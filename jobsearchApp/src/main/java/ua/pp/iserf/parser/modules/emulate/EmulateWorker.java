package ua.pp.iserf.parser.modules.emulate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmulateWorker implements Runnable {

    private final static Logger LOG = LogManager.getLogger();

    @Override
    public void run() {
        int counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            LOG.info("Emulate Parser counter=" + counter);
            counter++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                LOG.info("EmulateParser is interrupted!");
            }
        }

    }

}
