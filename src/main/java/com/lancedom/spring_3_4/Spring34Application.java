package com.lancedom.spring_3_4;

import com.lancedom.spring_3_4.service.PlaygroundService;
import com.lancedom.spring_3_4.service.ThemeParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * For
 * 1. <a href="https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.4-Release-Notes#restclient-and-resttemplate">restclient</a>
 */
@SpringBootApplication
public class Spring34Application implements CommandLineRunner {

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired(required = false)
    private ThemeParkService themeParkService;

    @Override
    public void run(String... args) {
        playgroundService.invokeGitHubDetails();
        if (null != themeParkService) {
            themeParkService.execute();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Spring34Application.class, args);
    }

}
