package com.lancedom.spring_3_4.config;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank
    private String line1;
    private String line2;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

    @Override
    public String toString() {
        return "Address{" + "line1='" + line1 + '\'' + ", line2='" + line2 + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", country='" + country + '\'' + '}';
    }

    public @NotBlank String getLine1() {
        return line1;
    }

    public void setLine1(@NotBlank String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public @NotBlank String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        this.city = city;
    }

    public @NotBlank String getState() {
        return state;
    }

    public void setState(@NotBlank String state) {
        this.state = state;
    }

    public @NotBlank String getCountry() {
        return country;
    }

    public void setCountry(@NotBlank String country) {
        this.country = country;
    }
}
