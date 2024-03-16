package com.geico.ws.address.service;

import com.geico.ws.address.dao.USPSService;
import com.geico.ws.address.model.Address;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Address Standardization Service.
 */
@Service
public class AddressStandardizationService {

    private final USPSService uspsService;

    public AddressStandardizationService(final USPSService uspsService) {
        this.uspsService = uspsService;
    }

    /**
     * Standardize Address.
     *
     * @param addressInput The address to standardize.
     * @return The standardized address.
     */
    public Mono<Address> standardizeAddress(final Address addressInput) {
        return uspsService.standardizeAddress(addressInput);
    }

}
