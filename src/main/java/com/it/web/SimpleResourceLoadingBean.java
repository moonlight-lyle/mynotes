package com.it.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class SimpleResourceLoadingBean {

//    private static Logger log = LoggerFactory.getLogger(HealthMonitorApplication.class);

    @Autowired
    private ResourceLoader resourceLoader;


    @RequestMapping("/getresource")
    public String resourceLoadingMethod() throws IOException {
//        log.info("IN RESOURCE LOADER");

        Resource resource = this.resourceLoader.getResource("s3://s3.amazonaws.com/mybucket/myfile.ext");

        InputStream inputStream = resource.getInputStream();

        return inputStream.toString();
    }
}