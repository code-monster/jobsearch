package ua.pp.iserf.parser.core;

/**
 *
 * @author alex
 */
public abstract class Module {

    private boolean enable = false;
    // required field, this name will used in database 
    private String name = "Unnamed";

    public abstract void start();

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
