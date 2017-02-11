package ua.pp.iserf;

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
import ua.pp.iserf.parser.core.beans.ParserManagerSetting;

@Controller
@RequestMapping("/parsersetting")
public class ParserSettingController {

    @Autowired
    ParserManager parserManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, HttpServletRequest request) {

        ParserManagerSetting parserSetting = new ParserManagerSetting(
                parserManager.isRunning(),
                parserManager.retrieveModuleInfo()
        );
        modelMap.addAttribute("parserSetting", parserSetting);
        return new ModelAndView("parsersetting");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(Model modelMap,
            @ModelAttribute("parserSetting") ParserManagerSetting parserSetting,
            RedirectAttributes redirectAttributes) {

        System.out.println("got parserAction = " + parserSetting.getAction() + " in controller");
        if (parserSetting.getAction().equals(ParserManagerSetting.STATUS_RUN)) {
            parserManager.start();
        } else {
            parserManager.stop();
        }

        return new ModelAndView("redirect:/parsersetting");

    }
}
