package com.ibmix.springcloud.demo.greeting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GreetingController {

    private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

    private final GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    @RequestMapping("/")
    public String getGreeting() {
        LOG.info("Greeting: " + greetingProperties.getGreeting());
        return this.greetingProperties.getGreeting();
    }

    @RequestMapping("/{languageCode}")
    public String getGreeting(@PathVariable String languageCode) {
        LOG.info("Language Code: " + languageCode);
        LOG.info("Greeting: " + this.greetingProperties.getGreetings().get(languageCode.toUpperCase()));
        return  this.greetingProperties.getGreetings().getOrDefault(languageCode.toUpperCase(), this.greetingProperties.getGreeting());
    }
}
