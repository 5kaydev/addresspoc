package com.geico.ws.address.dao;

import com.geico.ws.address.model.Address;
import com.geico.ws.address.model.StandardizeAddressRequest;
import com.geico.ws.address.model.StandardizeAddressResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

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
    private final HttpGraphQlClient uspsClient;

    public USPSService(@Qualifier("uspsClient") final HttpGraphQlClient uspsClient) {
        this.uspsClient = uspsClient;
    }

    public Mono<Address> standardizeAddress(final Address addressInput) {
        return uspsClient.document(QUERY_TEXT)
                .variables(Map.of("request", new StandardizeAddressRequest(addressInput)))
                .retrieve("standardizeAddress")
                .toEntity(StandardizeAddressResponse.class)
                .map(StandardizeAddressResponse::address);
    }
}
