package ua.pp.iserf.parser.core;

/**
 *
 * @author alex
 */
public abstract class Module {

    private boolean running;

    public abstract void begin();

    public abstract void end();

    public abstract String getName();

    public void start() {
        if (running) {
            return;
        }
        begin();
        running = true;
    }

    public void stop() {
        if (running == false) {
            return;
        }
        end();
        running = false;
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

}
