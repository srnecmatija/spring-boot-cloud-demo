package com.ibmix.springcloud.demo.web;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

    private static final String URL = "http://localhost:7070";

    private final RestTemplate restTemplate;

    public NameService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getName() {
        return this.restTemplate.getForObject(URL, String.class);
    }
}
