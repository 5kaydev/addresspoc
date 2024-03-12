package com.geico.ws.address.web;

import com.geico.ws.address.model.StandardizeAddressRequest;
import com.geico.ws.address.model.StandardizeAddressResponse;
import com.geico.ws.address.service.AddressStandardizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {

    private final AddressStandardizationService addressStandardizationService;

    /**
     * Constructor.
     *
     * @param addressStandardizationService The address standardization service.
     */
    @Autowired
    public AddressController(final AddressStandardizationService addressStandardizationService) {
        this.addressStandardizationService = addressStandardizationService;
    }

    @QueryMapping
    public Mono<StandardizeAddressResponse> standardizeAddress(@Argument final StandardizeAddressRequest request) {
        return addressStandardizationService.standardizeAddress(request.address())
                .map(StandardizeAddressResponse::new);
    }
}
