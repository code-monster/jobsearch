package ua.pp.iserf.parser.modules.emulate;

import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.DataSource;

/**
 *
 * @author alex
 */
@Component
public class EmulateParser extends DataSource {

    private Thread thread;

    public EmulateParser() {
        setRunningStatus(false);
        setEnable(false);
        setName("Emulate Parser");
    }

    public void start() {
        if (isEnable() == false) {
            return;
        }
        EmulateWorker emulateParser = new EmulateWorker();
        thread = new Thread(emulateParser);
        thread.start();
        setRunningStatus(true);
    }

    public void stop() {
        if (isEnable() == false) {
            return;
        }
        thread.interrupt();
        setRunningStatus(false);

    }

}
