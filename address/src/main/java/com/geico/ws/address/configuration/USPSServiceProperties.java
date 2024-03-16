package com.geico.ws.address.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The configuration properties for the external usps address standardization service.
 */
@ConfigurationProperties(prefix = "app.usps-service")
public class USPSServiceProperties {

    private String url;

    // add Lomnok to generate getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
