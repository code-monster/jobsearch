package ua.pp.iserf.parser.core.beans;

/**
 *
 * @author alex
 */
public class ParserSetting {

    public ParserSetting() {
    }

    public ParserSetting(String status, String action) {
        this.status = status;
        this.action = action;
    }

    private String status;
    private String action;

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
