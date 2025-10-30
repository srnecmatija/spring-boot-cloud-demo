package com.ibmix.springcloud.demo.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "greeting")
public interface GreetingClient {

    @GetMapping
    String getGreeting();

    @GetMapping("/{languageCode}")
    String getGreeting(@PathVariable String languageCode);
}
