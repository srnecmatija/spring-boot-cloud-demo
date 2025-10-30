package com.ibmix.springcloud.demo.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class WebController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public WebController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    @RequestMapping
    public String getResult(HttpServletRequest request) {
        final String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();

        final ServiceInstance greetingService = discoveryClient.getInstances("greeting").get(0);
        final ServiceInstance nameService = discoveryClient.getInstances("name").get(0);

        final String greetingServiceResponse = this.restClient
                .get()
                .uri(greetingService.getUri() + "/" + locale)
                .retrieve()
                .body(String.class);

        final String nameServiceResponse = this.restClient
                .get()
                .uri(nameService.getUri())
                .retrieve()
                .body(String.class);

        return greetingServiceResponse + " " + nameServiceResponse;
    }
}
