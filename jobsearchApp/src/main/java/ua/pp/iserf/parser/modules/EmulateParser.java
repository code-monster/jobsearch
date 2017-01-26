package ua.pp.iserf.parser.modules;

import java.sql.Timestamp;

/**
 *
 * @author alex
 */
public class EmulateParser implements Runnable {

    private int counter;
    private boolean enable = false;
    private String name = "Emulate Parser";

    public EmulateParser() {

    }

    @Override
    public void run() {
        counter = 0;
        while (Thread.currentThread().isInterrupted() == false) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " counter=" + counter);
            counter++;

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("EmulateParser is interrupted!");
            }
        }

    }

    /**
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
