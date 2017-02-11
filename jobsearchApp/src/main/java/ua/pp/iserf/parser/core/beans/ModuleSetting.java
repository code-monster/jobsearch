package ua.pp.iserf.parser.core.beans;

/**
 *
 * @author alex
 */
public class ModuleSetting {

    private int moduleIndex;
    private boolean enable;
    private String name;

    public ModuleSetting() {
    }

    public ModuleSetting(String name, boolean enable, int moduleIndex) {
        this.setName(name);
        this.setEnable(enable);
        this.setModuleIndex(moduleIndex);
    }

    /**
     * @return the moduleIndex
     */
    public int getModuleIndex() {
        return moduleIndex;
    }

    /**
     * @param moduleIndex the moduleIndex to set
     */
    public void setModuleIndex(int moduleIndex) {
        this.moduleIndex = moduleIndex;
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
