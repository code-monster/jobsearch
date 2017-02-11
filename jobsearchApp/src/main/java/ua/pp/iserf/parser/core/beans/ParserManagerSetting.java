package ua.pp.iserf.parser.core.beans;

import java.util.List;

/**
 *
 * @author alex
 */
public class ParserManagerSetting {

    private List<String> moduleInfoList;
    private String status;
    private String action;

    public static final String STATUS_RUN = "RUN";
    public static final String STATUS_STOP = "STOP";

    public ParserManagerSetting() {
    }

    public ParserManagerSetting(boolean enable, List<String> moduleInfoList) {
        if (enable) {
            status = STATUS_RUN;
            action = STATUS_STOP;
        } else {
            status = STATUS_STOP;
            action = STATUS_RUN;
        }
        this.moduleInfoList = moduleInfoList;
    }

    /**
     * @return the moduleInfoList
     */
    public List<String> getModuleInfoList() {
        return moduleInfoList;
    }

    /**
     * @param moduleInfoList the moduleInfoList to set
     */
    public void setModuleInfoList(List<String> moduleInfoList) {
        this.moduleInfoList = moduleInfoList;
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
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

}
