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
import ua.pp.iserf.parser.Parser;

@Controller
public class ParserSettingController {

    @Autowired
    private HttpServletRequest context;

    @RequestMapping(value = "/parsersetting", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, HttpServletRequest request) {

        Parser parser = Parser.getInstance();
        modelMap.addAttribute("parserStatus", parser.getStatus());
        modelMap.addAttribute("parserAction", parser.getAction());

        return new ModelAndView("parsersetting");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAction(Model modelMap, RedirectAttributes redirectAttributes) {
        String parserAction = context.getParameter("parserAction");
        System.out.println("got parserAction =" + parserAction + "in controller");
        Parser parser = Parser.getInstance();
        if (parserAction.equals(Parser.STATUS_STOP)) {
            System.out.println("command stop in controller");
            parser.stop();
        } else {
            System.out.println("command run  in controller");
            parser.run();
        }

        return new ModelAndView("redirect:/parsersetting");

    }
}
