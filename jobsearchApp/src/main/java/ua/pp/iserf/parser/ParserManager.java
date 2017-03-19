package ua.pp.iserf.parser;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.pp.iserf.parser.core.Module;

@Component
public class ParserManager {

    private final static Logger LOG = LogManager.getLogger();
    private List<Module> moduleList;

    @Autowired
    public ParserManager(final List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

}
