package com.lancedom.spring_3_4.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "info")
@Validated
public class InformationalProperties {

    @NotNull
    private String name;

    @Email
    private String email;

    @Valid //the validation to cascade down to nested properties - https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.4-Release-Notes#bean-validation-of-configuration-properties
    private Address address;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InformationalProperties{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", address=" + address + '}';
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Valid Address getAddress() {
        return address;
    }

    public void setAddress(@Valid Address address) {
        this.address = address;
    }
}
