package ua.pp.iserf;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.parser.ParserManager;
import ua.pp.iserf.parser.core.Module;
import ua.pp.iserf.parser.core.beans.ModuleSetting;

@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    ParserManager parserManager;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        List<Module> moduleList = parserManager.getModuleList();
        int moduleIndex = Integer.parseInt(context.getParameter("moduleIndex"));
        Module module = moduleList.get(moduleIndex);
        ModuleSetting moduleSetting = new ModuleSetting(module.getName(), module.isEnable(), moduleIndex);

        ModelAndView modelAndView = new ModelAndView("module");
        modelAndView.getModelMap().addAttribute("moduleSetting", moduleSetting);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(@ModelAttribute("moduleSetting") ModuleSetting moduleSetting) {
        List<Module> moduleList = parserManager.getModuleList();
        Module module = moduleList.get(moduleSetting.getModuleIndex());
        module.applySetting(moduleSetting);

        return new ModelAndView("redirect:/module?moduleIndex=" + moduleSetting.getModuleIndex());
    }
}
