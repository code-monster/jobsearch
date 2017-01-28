package ua.pp.iserf.parser.modules.emulate;

import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.DataSource;

/**
 *
 * @author alex
 */
@Component
public class EmulateParser extends DataSource  {

    private Thread thread;

    public EmulateParser() {
        enable = true;
        name = "Emulate Parser";

    }

    public void start() {
this.setEnable(true);
//        EmulateWorker emulateParser = new EmulateWorker();
//        thread = new Thread(emulateParser);
//        thread.start();
        

    }

    public void stop() {

     //   thread.interrupt();
        this.setEnable(false);

    }

}
