package ua.pp.iserf.parser.modules.emulate;

import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;

@Component
public class EmulateParser extends Module {

    private Thread thread;

    @Override
    public void begin() {
        EmulateWorker emulateParser = new EmulateWorker();
        thread = new Thread(emulateParser);
        thread.start();
    }

    @Override
    public void end() {
        thread.interrupt();
    }

    @Override
    public String getName() {
        return "Emulate Parser";
    }

}
