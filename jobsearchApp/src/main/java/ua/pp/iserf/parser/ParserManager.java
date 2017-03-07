package ua.pp.iserf.parser;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.parser.core.beans.ParserManagerSetting;

/**
 * Global control for all parser objects
 *
 * @author alex
 */
@Component
public class ParserManager {

    private final static Logger LOG = LogManager.getLogger();

    private List<Module> moduleList;

    public ParserManager() {

    }

    public List<String> retrieveModuleInfo() {

        List moduleInfoList = new ArrayList();
        for (Module module : moduleList) {
            moduleInfoList.add(module.getName() 
                    + " enabled:" + module.isEnable()
                    + " running:" + module.isRunning());
        }

        return moduleInfoList;
    }
    
    @Autowired
    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public void start() {
        for (Module module : moduleList) {
            module.start();
        }

        LOG.debug("start");
    }

    public void stop() {
        for (Module module : moduleList) {
            module.stop();
        }

        LOG.debug("stop");
    }

    public void restart() {
        stop();
        start();
    }

    public void applySetting(ParserManagerSetting parserSetting) {
        if (parserSetting.isRunAction()) {
            start();
        } else {
            stop();
        }
    }

    /**
     * @return the moduleList
     */
    public List<Module> getModuleList() {
        return moduleList;
    }


}
