package com.lancedom.spring_3_4.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "info")
@Validated
@Getter
@Setter
@ToString
public class InformationalProperties {

    @NotNull
    private String name;

    @Email
    private String email;

    @Valid
    //the validation to cascade down to nested properties - https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.4-Release-Notes#bean-validation-of-configuration-properties
    private Address address;

}
