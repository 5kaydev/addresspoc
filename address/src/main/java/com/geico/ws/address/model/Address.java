package com.geico.ws.address.model;

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
public record Address(
        String addressLine1,
        String addressLine2,
        String city,
        String country,
        String state,
        String zipCode
) {
}
