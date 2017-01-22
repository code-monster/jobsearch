package ua.pp.iserf.parser;

import java.util.concurrent.atomic.AtomicInteger;
import ua.pp.iserf.parser.core.EmulateParser;
import ua.pp.iserf.parser.core.JobParser;
import ua.pp.iserf.parser.core.JobParserMultithread;
import ua.pp.iserf.parser.core.SingleVacancyParserMultithread;

/**
 *
 * @author alex
 */
public class Parser {

    private Thread thread;
    private AtomicInteger counter;
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
    /*
     public static void main(String[] args) {

     System.out.println("Parser start point");

     //        JobParser jobParser = JobParser.getInstance();
     //        jobParser.setBaseUrl("http://javajobsearchapp.blogspot.com/");
     //        jobParser.run();
     //        JobParserMultithread  jobParser = JobParserMultithread.getInstance();
     //        jobParser.setBaseUrl("http://javajobsearchapp.blogspot.com/");
     //        jobParser.run();
        
     Parser parser = new Parser();   
     parser.run();

     boolean flag = true;
     while (flag) {

     if (parser.counter.get() > 10) {
     flag = false;
     System.out.println("stop thread");
     parser.stop();
     }
       
     }

     System.out.println("Finish");

     }
     */

    private Parser() {
        counter = new AtomicInteger();
        status = STATUS_STOP;
    }

    public void run() {

        EmulateParser emulateParser = new EmulateParser(counter);
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
