package ua.pp.iserf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.service.VacancyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private final static Logger LOG = LogManager.getLogger();

    @Autowired
    private HttpServletRequest context;


    @Autowired
    VacancyService vacancyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userLogin(ModelMap modelMap) {

        int limit = 2;
        int offset = 2;

        if (context.getParameterMap().containsKey("offset") == true) {
            offset = Integer.parseInt(context.getParameter("offset"));
        }

        List vacancyList = vacancyService.findByPage(limit, offset);
        modelMap.addAttribute("title", "View users");
        modelMap.addAttribute("vacancyList", vacancyList);

        return new

                ModelAndView("index");
    }
}
