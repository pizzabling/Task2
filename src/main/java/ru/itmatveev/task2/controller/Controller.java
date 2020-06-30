package ru.itmatveev.task2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmatveev.task2.service.ParseService;

@org.springframework.stereotype.Controller
public class Controller {

    private ParseService service;


    public Controller(ParseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/currency")
    public String currencyPage(Model model){
        model.addAttribute("info", service.getDomainList());
        return "currency";
    }

    @PostMapping("/currency")
    public String getCurrency(@RequestParam String data) throws Exception {
        service.parsing(data);
        return "redirect:/currency";
    }

}
