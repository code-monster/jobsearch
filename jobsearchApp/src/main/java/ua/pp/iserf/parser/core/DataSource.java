package ua.pp.iserf.parser.core;


/**
 *
 * @author alex
 */
public abstract class DataSource {

    protected boolean enable;
    protected String name;

    public abstract void run();

    public abstract void stop();

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
