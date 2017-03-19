package ua.pp.iserf.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.parser.ParserManager;

@Controller
@RequestMapping("/parsersetting")
public class ParserSettingController {

    private final static Logger LOG = LogManager.getLogger();

    @Autowired
    private ParserManager parserManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("parsersetting");
        modelAndView.getModelMap().addAttribute("moduleList", parserManager.getModuleList());

        return modelAndView;
    }

}
