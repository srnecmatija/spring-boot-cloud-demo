package com.ibmix.springcloud.demo.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties
public class GreetingProperties {

    private String greeting;
    private Map<String, String> greetings = new HashMap<>();

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Map<String, String> getGreetings() {
        return greetings;
    }

    public void setGreetings(Map<String, String> greetings) {
        this.greetings = greetings;
    }
}
