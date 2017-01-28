package ua.pp.iserf.parser.core.beans;

import java.util.List;

/**
 *
 * @author alex
 */
public class ParserManagerSetting {

    public ParserManagerSetting() {
    }

    public ParserManagerSetting(String status, String action, List<String> parserNameList) {
        this.status = status;
        this.action = action;
        this.parserNameList = parserNameList;
    }

    private String status;
    private String action;
    private List<String> parserNameList;

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

    /**
     * @return the parserNameList
     */
    public List<String> getParserNameList() {
        return parserNameList;
    }

    /**
     * @param parserNameList the parserNameList to set
     */
    public void setParserNameList(List<String> parserNameList) {
        this.parserNameList = parserNameList;
    }

}
