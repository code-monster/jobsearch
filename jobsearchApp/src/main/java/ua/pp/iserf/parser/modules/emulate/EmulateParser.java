package ua.pp.iserf.parser.modules.emulate;

import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;

/**
 *
 * @author alex
 */
@Component
public class EmulateParser extends Module {

    private Thread thread;

    public EmulateParser() {
        setName("Emulate Parser");
    }

    public void start() {
        if (isEnable() == false) {
            return;
        }
        EmulateWorker emulateParser = new EmulateWorker();
        thread = new Thread(emulateParser);
        thread.start();
        running = true;
    }

    public void stop() {
        if (isEnable() == false) {
            return;
        }
        thread.interrupt();
        running = false;
    }

}
