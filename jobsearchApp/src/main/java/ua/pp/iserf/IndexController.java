package ua.pp.iserf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.service.UserService;
import ua.pp.iserf.service.VacancyService;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private final static Logger LOG = LogManager.getLogger();

    @Autowired
    UserService userService;

    @Autowired
    VacancyService vacancyService;

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView userLogin(ModelMap modelMap) {


        List userList = userService.findAll();
        List vacancyList = vacancyService.findAll();

        modelMap.addAttribute("title", "View users");
        modelMap.addAttribute("userList", userList);
        modelMap.addAttribute("vacancyList", vacancyList);


        return new ModelAndView("index");
    }
}
