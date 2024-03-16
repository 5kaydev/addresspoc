package com.geico.ws.address.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Standardize Address Request.
 *
 * @param address Address to standardize.
 */
//@JsonDeserialize
//@JsonIgnoreProperties(ignoreUnknown = true)
public record StandardizeAddressResponse(Address address) {
}
