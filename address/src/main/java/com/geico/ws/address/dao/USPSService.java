package com.geico.ws.address.dao;

import com.geico.ws.address.model.Address;
import com.geico.ws.address.model.StandardizeAddressRequest;
import com.geico.ws.address.model.StandardizeAddressResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class USPSService {

    private static final String QUERY_TEXT = """
            query myQuery ($request: StandardizeAddressRequest) {
                standardizeAddress(request: $request) {
                    address {
                        addressLine1
                        addressLine2
                        city
                        country
                        state
                        zipCode
                    }
                }
            }
            """;
    private final WebClient uspsClient;

    public USPSService(@Qualifier("uspsClient") final WebClient uspsClient) {
        this.uspsClient = uspsClient;
    }

    public Mono<Address> standardizeAddress(final Address addressInput) {
        return uspsClient.post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new StandardizeAddressRequest(addressInput))
                .retrieve()
                .bodyToMono(StandardizeAddressResponse.class)
                .map(StandardizeAddressResponse::address);
    }
}
