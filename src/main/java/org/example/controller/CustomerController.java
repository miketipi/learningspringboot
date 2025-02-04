package org.example.controller;

import jakarta.validation.Valid;
import org.example.entity.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    //reminder : @ModelAttribute is the replacement for Model model and
    @PostMapping("/customer/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }
/* @InitBinder
• @InitBinder annotation works as a pre-processor
• It will pre-process each web request to our controller
• Method annotated with @InitBinder is executed */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
