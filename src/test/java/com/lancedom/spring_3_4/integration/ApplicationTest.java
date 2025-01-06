package com.lancedom.spring_3_4.integration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ApplicationTest.ApplicationTestConfig.class)
public class ApplicationTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext.getBean(DynamicPropertyRegistrar.class)).isNotNull();
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @TestConfiguration
    public static class ApplicationTestConfig {

        /**
         * Refer the documentation of {@link DynamicPropertyRegistrar}
         * This approach decouple for defining {@link org.springframework.test.context.DynamicPropertySource} with DynamicPropertyRegistry
         */
        @Bean
        DynamicPropertyRegistrar dynamicPropertyRegistrar() {
            return new DynamicPropertyRegistrar() {
                @Override
                public void accept(DynamicPropertyRegistry registry) {
                    registry.add("spring.datasource.url", postgres::getJdbcUrl);
                    registry.add("spring.datasource.username", postgres::getUsername);
                    registry.add("spring.datasource.password", postgres::getPassword);
                }
            };
        }

        /**
         * Scope of DynamicPropertyRegistry: The DynamicPropertyRegistry is designed for use within test contexts
         * and is not a Spring bean available for injection into application beans.
         *
         * Avoid Injecting into @Bean Methods: Attempting to inject DynamicPropertyRegistry into @Bean methods in your application configuration
         * will result in a NoSuchBeanDefinitionException, as it is not managed by the Spring container in that context.
         *
         * References:
         * DynamicPropertyRegistry in @Bean-method fails with spring-boot-testcontainers dependency in classpath (3.4.0-M1)
         * Introduce DynamicPropertyRegistrar as a replacement for DynamicPropertyRegistry
         *
         */
        /*@Bean
        public ThemeParkService themeParkService(DynamicPropertyRegistry registry) {
            // Register dynamic properties
            registry.add("spring.datasource.url", postgres::getJdbcUrl);
            registry.add("spring.datasource.username", postgres::getUsername);
            registry.add("spring.datasource.password", postgres::getPassword);

            return new ThemeParkService();
        }*/
    }

}
