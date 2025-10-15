package com.ibmix.springcloud.demo.name;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class NameController {

    private static final Logger LOG = Logger.getLogger(NameController.class.getName());

    private final NameProperties nameProperties;

    public NameController(NameProperties nameProperties) {
        this.nameProperties = nameProperties;
    }

    @RequestMapping
    public String getName() {
        LOG.info("Name: " + this.nameProperties.getName());
        return nameProperties.getName();
    }
}
