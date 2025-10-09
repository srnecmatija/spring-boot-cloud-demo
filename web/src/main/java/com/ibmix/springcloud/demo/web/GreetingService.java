package com.ibmix.springcloud.demo.web;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

    private static final String URL = "http://localhost:9090";

    private final RestTemplate restTemplate;

    public GreetingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getGreeting() {
        return this.restTemplate.getForObject(URL, String.class);
    }

    public String getGreeting(final String locale) {
        final String localeUrl = new StringBuilder(URL).append("/").append(locale).toString();
        return this.restTemplate.getForObject(localeUrl, String.class);
    }
}
