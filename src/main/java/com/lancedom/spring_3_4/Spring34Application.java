package com.lancedom.spring_3_4;

import com.lancedom.spring_3_4.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * For
 * 1. https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.4-Release-Notes#restclient-and-resttemplate
 */
@SpringBootApplication
public class Spring34Application implements CommandLineRunner {

    @Autowired
    private PlaygroundService playgroundService;

    @Override
    public void run(String... args) {
        playgroundService.invokeGitHubDetails();
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring34Application.class, args);
    }

}
