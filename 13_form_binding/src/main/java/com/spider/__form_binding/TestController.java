package com.spider.__form_binding;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @RequestMapping("/display")
    public String display() {
        return "display";
    }

    @RequestMapping(value = "/reg")
    public String register(Model model) {
        model.addAttribute("userdata",new User());
        return "register";
    }
    @RequestMapping(value = "regdata", method = RequestMethod.POST)
    public String data(User user, Model model) {
        model.addAttribute("userdata", user);
        return "display";
    }
}
