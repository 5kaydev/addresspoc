package com.geico.ws.address.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Address record.
 *
 * @param addressLine1 Line1 of the address.
 * @param addressLine2 Line2 of the address.
 * @param city         City name.
 * @param country      Country name.
 * @param state        State Name.
 * @param zipCode      zip code.
 */
//@JsonDeserialize
//@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
        String addressLine1,
        String addressLine2,
        String city,
        String country,
        String state,
        String zipCode
) {
}
