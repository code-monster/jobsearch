package ua.pp.iserf;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public ModelAndView index(ModelMap modelMap, HttpServletRequest request) {

        List<Module> moduleList = parserManager.getModuleList();
        int moduleIndex = Integer.parseInt(context.getParameter("moduleIndex"));
        Module module = moduleList.get(moduleIndex);
        ModuleSetting moduleSetting = new ModuleSetting(module.getName(), module.isEnable(), moduleIndex);

        modelMap.addAttribute("moduleSetting", moduleSetting);
        return new ModelAndView("module");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(Model modelMap,
            @ModelAttribute("moduleSetting") ModuleSetting moduleSetting,
            RedirectAttributes redirectAttributes) {
        List<Module> moduleList = parserManager.getModuleList();
        Module module = moduleList.get(moduleSetting.getModuleIndex());

        if (moduleSetting.isEnable() != module.isEnable()) {

            if (parserManager.isRunning()) {
                parserManager.stop();
                module.setEnable(moduleSetting.isEnable());
                parserManager.start();
            } else {
                module.setEnable(moduleSetting.isEnable());
            }
        }

        return new ModelAndView("redirect:/module?moduleIndex=" + moduleSetting.getModuleIndex());

    }
}
