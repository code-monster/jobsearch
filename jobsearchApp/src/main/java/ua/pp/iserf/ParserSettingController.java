package ua.pp.iserf;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.pp.iserf.parser.Parser;
import ua.pp.iserf.parser.core.beans.ParserSetting;

@Controller
@RequestMapping("/parsersetting")
public class ParserSettingController {


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, HttpServletRequest request) {

        Parser parser = Parser.getInstance();
        ParserSetting parserSetting = new ParserSetting(parser.getStatus(), parser.getAction());
        modelMap.addAttribute("parserSetting", parserSetting);
        return new ModelAndView("parsersetting");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(Model modelMap,
            @ModelAttribute("parserSetting") ParserSetting parserSetting,
            RedirectAttributes redirectAttributes) {

        System.out.println("got parserAction =" + parserSetting.getAction() + "in controller");
        Parser parser = Parser.getInstance();
        if (parserSetting.getAction().equals(Parser.STATUS_STOP)) {
            System.out.println("command stop in controller");
            parser.stop();
        } else {
            System.out.println("command run  in controller");
            parser.run();
        }

        return new ModelAndView("redirect:/parsersetting");

    }
}
