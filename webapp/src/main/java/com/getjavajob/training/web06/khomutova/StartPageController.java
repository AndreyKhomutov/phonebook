package com.getjavajob.training.web06.khomutova;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showStartPage() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
