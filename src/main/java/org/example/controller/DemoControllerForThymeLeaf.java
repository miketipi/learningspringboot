package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.entity.Student;
import org.example.entity.StudentForThymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// use Controller to render HTML page, @RestController does not allow
@Controller
public class DemoControllerForThymeLeaf {
    @GetMapping("/test")
    public String sayHello(Model model) {
        model.addAttribute("theDate", java.time.LocalDateTime.now());
        //this will return a model in templates/xxx.html
        //sboot will automagically do it
        return "helloworld";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //Model is the data which can be used by the templates
//    @RequestMapping(value = "/processFormVersionTwo", method = RequestMethod.GET)
    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
//        //read data from the url
        // refractor
//        String theName = request.getParameter("studentName");

        //convert to upper case
        theName = theName.toUpperCase();

        //create some new message

        String message = "Hello Bro" + theName;

        //add message to the model
        model.addAttribute("message", message);

        return "helloworld";
    }


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        theModel.addAttribute("student", new StudentForThymeleaf());
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") StudentForThymeleaf theStudent){
        System.out.println("The student info: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
