package com.ibmix.springcloud.demo.greeting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    @RequestMapping("/")
    public String getGreeting() {
        return this.greetingProperties.getGreeting();
    }

    @RequestMapping("/{languageCode}")
    public String getGreeting(@PathVariable String languageCode) {
        return  this.greetingProperties.getGreetings().getOrDefault(languageCode.toUpperCase(), this.greetingProperties.getGreeting());
    }
}
