package ua.pp.iserf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.iserf.service.LogService;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMethod() {

        String logContent = logService.getContent();
        ModelAndView modelAndView = new ModelAndView("log");
        modelAndView.getModelMap().addAttribute("title", "View users");
        modelAndView.getModelMap().addAttribute("logContent", logContent);

        return modelAndView;
    }


}
