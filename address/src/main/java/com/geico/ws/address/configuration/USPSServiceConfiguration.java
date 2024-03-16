package com.geico.ws.address.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * The configuration for the external usps address standardization service.
 */
@Configuration
public class USPSServiceConfiguration {

    private final USPSServiceProperties uspsServiceProperties;

    public USPSServiceConfiguration(final USPSServiceProperties uspsServiceProperties) {
        this.uspsServiceProperties = uspsServiceProperties;
    }

    @Bean
    HttpGraphQlClient uspsClient(WebClient.Builder builder) {
        return HttpGraphQlClient.builder(builder
                        .baseUrl(uspsServiceProperties.getUrl())
                        .build())
                .build();
    }
}
