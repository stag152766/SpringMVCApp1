package ru.alishev.springcourse.config.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname",required = false) String surname,
                            Model model){

        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goobbuyPage(){
        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model){

        double result = 0;
        if (action.equals("multiplication")){
            result = a * b;
        }
        else if (action.equals("addition")){
            result = a + b;
        }
        else if (action.equals("substraction")){
            result = a - b;
        }
        else if (action.equals("division") && b != 0){
            result = (double) a / b;
        }
        model.addAttribute("result", result);
        return "first/calculator" ;
    }

}
