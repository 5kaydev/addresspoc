package com.geico.ws.address;

import com.geico.ws.address.configuration.USPSServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({USPSServiceProperties.class})
@SpringBootApplication
public class AddressAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressAPIApplication.class, args);
    }

}
