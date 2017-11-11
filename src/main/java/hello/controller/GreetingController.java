package hello.controller;

import java.util.concurrent.atomic.AtomicLong;
import java.awt.font.*;

import hello.model.Greeting;
import hello.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            return greetingService.getGreeting(name);
        }
        catch (Exception exception) {
            return greetingService.getGreeting(name);
        }
    }
}
