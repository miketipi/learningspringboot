package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoControllerForThymeLeaf {
    @GetMapping("/test")
    public String sayHello(Model model){
        model.addAttribute("theDate", java.time.LocalDateTime.now());
        //this will return a model in templates/xxx.html
        //sboot will automagically do it
        return "helloworld";
    }

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //Model is the data which can be used by the templates
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read data from the url
        String theName = request.getParameter("studentName");

        //convert to upper case
        theName = theName.toUpperCase();

        //create some new message

        String message = "Hello Bro" + theName;

        //add message to the model
        model.addAttribute("message", message);

        return "helloworld";
    }
}
