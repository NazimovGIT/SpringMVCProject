package ru.SpringMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    /*    @GetMapping("/hello")
        public String SayHello (HttpServletRequest request){ //переменная хранит всю инфу о запросе (передает Spring)
            String name = request.getParameter("name");//получаем параметр из запроса по ключу
            String surname = request.getParameter("surname");

            //работаем с пришедшими параметрами
            System.out.println("Hello, " + name + " " + surname);

            return "first/hello";
        }*/
    @GetMapping("/hello")
    public String SayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname, Model model) {

        //работаем с пришедшими параметрами
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String Calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action, Model model) {

        //работаем с пришедшими параметрами
        double result = switch (action) {
            case "multiplication" -> (double) (a * b);
            case "addition" -> (double) (a + b);
            case "subtraction" -> (double) (a - b);
            case "division" -> (a / (double)b);
            default -> 0;
        };
        model.addAttribute("result", result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String SayGoodby() {
        return "first/goodbye";
    }
}
