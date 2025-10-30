package com.ibmix.springcloud.demo.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {

    private final GreetingClient greetingClient;
    private final NameClient nameClient;

    public WebController(GreetingClient greetingClient, NameClient nameClient) {
        this.greetingClient = greetingClient;
        this.nameClient = nameClient;
    }

    @RequestMapping
    public String getResult(HttpServletRequest request) {
        final String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();

        final String greetingServiceResponse = this.greetingClient.getGreeting(locale);
        final String nameServiceResponse = this.nameClient.getName();

        return greetingServiceResponse + " " + nameServiceResponse;
    }
}
