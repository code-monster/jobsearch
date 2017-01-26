package ua.pp.iserf.parser;

import ua.pp.iserf.parser.modules.EmulateParser;

/**
 *
 * @author alex
 */
public class Parser {

    private Thread thread;
    public static final String STATUS_RUN = "RUN";
    public static final String STATUS_STOP = "STOP";
    private String status;
    private String action;

    private static Parser _instance = null;

    public static synchronized Parser getInstance() {
        if (_instance == null) {
            _instance = new Parser();
        }
        return _instance;
    }

    private Parser() {
        status = STATUS_STOP;
    }

    public void run() {

        EmulateParser emulateParser = new EmulateParser();
        thread = new Thread(emulateParser);
        thread.start();
        setStatus(STATUS_RUN);

    }

    public void stop() {

        thread.interrupt();
        setStatus(STATUS_STOP);

    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the action
     */
    public String getAction() {

        if (status.equals(STATUS_RUN)) {
            setAction(STATUS_STOP);
        } else {
            setAction(STATUS_RUN);
        }

        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

}
