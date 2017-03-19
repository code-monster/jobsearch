package ua.pp.iserf.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/userhome", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername(); //get logged in username

        ModelAndView modelAndView = new ModelAndView("userhome");
        modelAndView.getModelMap().addAttribute("title", "User home ");
        modelAndView.getModelMap().addAttribute("username", username);

        return modelAndView;

    }
}
