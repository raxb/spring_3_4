package com.lancedom.spring_3_4.config;

import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Customization to set the defaults
 * <a href="https://docs.spring.io/spring-boot/reference/io/rest-client.html#io.rest-client.restclient.customization">documentation</a>
 */
@Configuration
public class RestClientCustomConfiguration {

    @Bean
    public RestClientCustomizer restClientCustomizer() {
        return new RestClientCustomizer() {
            @Override
            public void customize(RestClient.Builder restClientBuilder) {
                restClientBuilder.baseUrl("https://api.github.com/users").build();
            }
        };
    }

}
