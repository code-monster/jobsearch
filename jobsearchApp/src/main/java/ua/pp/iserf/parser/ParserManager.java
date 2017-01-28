package ua.pp.iserf.parser;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.DataSource;

/**
 * Global control for all parser objects
 *
 * @author alex
 */
@Component
public class ParserManager {

    public static final String STATUS_RUN = "RUN";
    public static final String STATUS_STOP = "STOP";
    private String status = STATUS_STOP;
    private String action;
    private List<DataSource> parserList;

    public List<String> retrieveParserNameList() {

        List parserNameList = new ArrayList();
        for (DataSource parser : parserList) {
            parserNameList.add(parser.getName());
        }

        return parserNameList;
    }

    public ParserManager() {

    }

    @Autowired
    public void setParserList(List<DataSource> parserList) {
        this.parserList = parserList;
    }

    public void run() {
        for (DataSource parser : parserList) {
            parser.run();
        }
        setStatus(STATUS_RUN);
    }

    public void stop() {
        for (DataSource parser : parserList) {
            parser.stop();
        }
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
