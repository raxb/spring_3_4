package com.lancedom.spring_3_4.service;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PlaygroundService {

    private final RestClient restClient;

    /**
     * From {@link com.lancedom.spring_3_4.config.RestClientCustomConfiguration} uses the autoconfigured ReactorClientHttpRequestFactory
     * <p>
     * But here we are overriding the service to use JdkClientHttpRequestFactory instead
     */
    public PlaygroundService(RestClient.Builder builder) {
        JdkClientHttpRequestFactory jdkClientHttpRequestFactory = new JdkClientHttpRequestFactory();
        jdkClientHttpRequestFactory.setReadTimeout(5000);
        restClient = builder.requestFactory(jdkClientHttpRequestFactory).build();
    }

    public void invokeGitHubDetails() {
        var result = restClient.get().uri("/raxb").retrieve().body(String.class);
        System.out.println(result);
    }

}
