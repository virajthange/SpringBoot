package com.spider.__form_handling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping(value = "regdata", method = RequestMethod.POST)
    public String registerData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String useremail = request.getParameter("useremail");
        String userpassword = request.getParameter("userpassword");
        System.out.println();
        System.out.println("=== User Details ===");
        System.out.println(username);
        System.out.println(useremail);
        System.out.println(userpassword);

        request.setAttribute("username", username);
        request.setAttribute("useremail", useremail);
        request.setAttribute("userpassword", userpassword);
        return "display";
    }

    @RequestMapping("/data")
    public String data(Model model) {
        model.addAttribute("username", "Viraj");
        model.addAttribute("userage", 23);
        model.addAttribute("user", new User(2, "Suraj", 38));
        return "data";
    }
    @RequestMapping("/viewdata")
    public ModelAndView showData(ModelAndView modelAndView) {
//        ModelAndView modelAndView = new ModelAndView();   //We can define the reference in method body or fun parameter also but it is recommended to use as parameters
        modelAndView.setViewName("viewdata");
        modelAndView.addObject("name", "Vinay");
        modelAndView.addObject("age", 33);
        modelAndView.addObject("user", new User(1, "Shubham", 34));
        return modelAndView;
    }

    @RequestMapping
//    @ResponseBody
    public String home() {
        return "home";
    }
}
