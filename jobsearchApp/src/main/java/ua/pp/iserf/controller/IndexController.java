package ua.pp.iserf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.service.VacancyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private HttpServletRequest context;

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMethod() {

        int limit = 10;
        int offset = 0;

        if (context.getParameterMap().containsKey("offset") == true) {
            offset = Integer.parseInt(context.getParameter("offset"));
        }

        List vacancyList = vacancyService.findByPage(limit, offset);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModelMap().addAttribute("title", "View vacancies");
        modelAndView.getModelMap().addAttribute("vacancyList", vacancyList);

        return modelAndView;
    }
}
