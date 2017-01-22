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

    Thread thread;
    private AtomicInteger counter;
    

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

    public Parser() {
       counter = new AtomicInteger();
    }

    public void run() {
   
        
        EmulateParser emulateParser = new EmulateParser(counter);
        thread = new Thread(emulateParser);
        thread.start();

    }

    public void stop() {

        thread.interrupt();

    }

}
