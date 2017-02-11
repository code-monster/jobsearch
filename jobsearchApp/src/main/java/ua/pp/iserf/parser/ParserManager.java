package ua.pp.iserf.parser;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;

/**
 * Global control for all parser objects
 *
 * @author alex
 */
@Component
public class ParserManager {

    private boolean enable = false;
    private List<Module> moduleList;

    public ParserManager() {

    }

    public List<String> retrieveModuleInfo() {

        List moduleInfoList = new ArrayList();
        for (Module parser : moduleList) {
            moduleInfoList.add(parser.getName() + " enabled:" + parser.isEnable());
        }

        return moduleInfoList;
    }

    @Autowired
    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public void start() {
        for (Module parser : moduleList) {
            parser.start();
        }
        enable = true;
    }

    public void stop() {
        for (Module parser : moduleList) {
            parser.stop();
        }
        enable = false;
    }

    /**
     * @return the moduleList
     */
    public List<Module> getModuleList() {
        return moduleList;
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

}
