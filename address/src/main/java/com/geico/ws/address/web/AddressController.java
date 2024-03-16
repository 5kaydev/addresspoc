package com.geico.ws.address.web;

import com.geico.ws.address.model.StandardizeAddressRequest;
import com.geico.ws.address.model.StandardizeAddressResponse;
import com.geico.ws.address.service.AddressStandardizationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AddressController {

    private final AddressStandardizationService addressStandardizationService;

    /**
     * Constructor.
     *
     * @param addressStandardizationService The address standardization service.
     */
    public AddressController(final AddressStandardizationService addressStandardizationService) {
        this.addressStandardizationService = addressStandardizationService;
    }

    @PostMapping(value = "/standardizeAddress", consumes = "application/json", produces = "application/json")
    public Mono<StandardizeAddressResponse> standardizeAddress(@RequestBody final StandardizeAddressRequest request) {
        return addressStandardizationService.standardizeAddress(request.address())
                .map(StandardizeAddressResponse::new);
    }
}
