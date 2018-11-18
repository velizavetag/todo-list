package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class DemoController {

//    fields
    private final DemoService demoService;

//    constructors
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

//    request methods

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

//  Http:://localhost:8080/todo-list/welcome
//  Http:://localhost:8080/todo-list/welcome?user=Tim

    //    prefix+name+suffix
    @GetMapping("welcome")
    public String welcome(@RequestParam String user , @RequestParam int age, Model model){
        model.addAttribute("helloMessage",demoService.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("model = {}", model);

        return "welcome";
    }

//    model attributes
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcome message() called");
        return demoService.getWelcomeMessage();
    }
}
