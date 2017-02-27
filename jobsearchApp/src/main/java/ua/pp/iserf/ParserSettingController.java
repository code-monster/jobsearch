package ua.pp.iserf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.parser.ParserManager;
import ua.pp.iserf.parser.core.beans.ParserManagerSetting;

@Controller
@RequestMapping("/parsersetting")
public class ParserSettingController {

    private final static Logger LOG = LogManager.getLogger();
    
    @Autowired
    ParserManager parserManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        ParserManagerSetting parserSetting = new ParserManagerSetting(
                parserManager.isRunning(),
                parserManager.retrieveModuleInfo()
        );
   
        ModelAndView modelAndView = new ModelAndView("parsersetting");
        modelAndView.getModelMap().addAttribute("parserSetting", parserSetting);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(@ModelAttribute("parserSetting") ParserManagerSetting parserSetting) {
       
        parserManager.applySetting(parserSetting);
        return new ModelAndView("redirect:/parsersetting");
    }
}
