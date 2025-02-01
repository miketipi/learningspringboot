package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoControllerForThymeLeaf {
    @GetMapping("/test")
    public String sayHello(Model model){
        model.addAttribute("theDate", java.time.LocalDateTime.now());
        //this will return a model in templates/xxx.html
        //sboot will automagically do it
        return "helloworld";
    }
}
