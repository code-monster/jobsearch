package ua.pp.iserf.parser.core;

import ua.pp.iserf.parser.core.beans.ModuleSetting;

/**
 *
 * @author alex
 */
public abstract class Module {

    private boolean enable = false;
    // required field, this name will used in database 
    private String name = "Unnamed";
    public boolean running;

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

    protected boolean isSettingEqual(ModuleSetting moduleSetting) {
        if (moduleSetting.isEnable() == isEnable()) {
            return true;
        }
        return false;
    }

    public void applySetting(ModuleSetting moduleSetting) {
        if (isSettingEqual(moduleSetting)) {
           return;
        }
        
        if (isRunning()) {
            stop();
            setEnable(moduleSetting.isEnable());
            start();
        } else {
            setEnable(moduleSetting.isEnable());
        }
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

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

}
