package ua.pp.iserf.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.parser.ParserManager;
import ua.pp.iserf.parser.core.Module;

@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ParserManager parserManager;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        if (context.getParameterMap().containsKey("activate") == false) {
            return new ModelAndView("redirect:/parsersetting");
        }

        List<Module> moduleList = parserManager.getModuleList();
        int moduleIndex = Integer.parseInt(context.getParameter("moduleIndex"));
        Module module = moduleList.get(moduleIndex);

        boolean activate = Boolean.parseBoolean(context.getParameter("activate"));
        if (activate) {
            module.start();
        } else {
            module.stop();
        }

        return new ModelAndView("redirect:/parsersetting");
    }

}
