package com.lancedom.spring_3_4.beans;

import com.lancedom.spring_3_4.annotations.MyPlaybook;
import com.lancedom.spring_3_4.service.PlaygroundService;
import com.lancedom.spring_3_4.service.ThemeParkService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class creates a bean of {@link ThemeParkService} when any bean is annotation with the {@link MyPlaybook} annotation
 * Here the return type of the bean that is being conditionally evaluated should be specified in the "value" element of the ConditionalOnBean
 * because the MyPlaybook annotation could be implemented on one or more types and if we wanted to narrow down the condition only on certain bean types.
 */
@Configuration
public class ThemeParkBean {

    // create ThemeParkService bean only if there is a bean annotated with MyPlaybook and is of bean type PlaygroundService
    @ConditionalOnBean(value = PlaygroundService.class, annotation = MyPlaybook.class)
    @Bean
    public ThemeParkService themeParkService() {
        return new ThemeParkService();
    }

}
