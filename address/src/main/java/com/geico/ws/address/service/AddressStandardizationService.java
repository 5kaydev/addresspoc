package com.geico.ws.address.service;

import com.geico.ws.address.model.Address;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Address Standardization Service.
 */
@Service
public class AddressStandardizationService {
    /**
     * Standardize Address.
     *
     * @param addressInput The address to standardize.
     * @return The standardized address.
     */
    public Mono<Address> standardizeAddress(final Address addressInput) {
        return Mono.just(addressInput)
                .map(address ->
                        new Address(StringUtils.toRootUpperCase(address.addressLine1()),
                                StringUtils.toRootUpperCase(address.addressLine2()),
                                StringUtils.toRootUpperCase(address.city()),
                                StringUtils.toRootUpperCase(address.country()),
                                StringUtils.toRootUpperCase(address.state()),
                                StringUtils.toRootUpperCase(address.zipCode())));
    }

}
