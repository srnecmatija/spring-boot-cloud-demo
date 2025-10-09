package com.ibmix.springcloud.demo.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {

    private final NameService nameService;
    private final GreetingService greetingService;

    public WebController(NameService nameService, GreetingService greetingService) {
        this.nameService = nameService;
        this.greetingService = greetingService;
    }

    @RequestMapping
    public String getResult(HttpServletRequest request) {
        final String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();

        return new StringBuilder()
                .append(this.greetingService.getGreeting(locale))
                .append(" ")
                .append(this.nameService.getName())
                .toString();
    }
}
