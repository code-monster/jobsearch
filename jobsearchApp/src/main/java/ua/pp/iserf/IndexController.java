package ua.pp.iserf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.service.VacancyService;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {


    @Autowired
    VacancyService vacancyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMethod(ModelMap modelMap) {

        List vacancyList = vacancyService.findAll();

        modelMap.addAttribute("title", "View users");
        modelMap.addAttribute("vacancyList", vacancyList);

        return new ModelAndView("index");
    }
}
