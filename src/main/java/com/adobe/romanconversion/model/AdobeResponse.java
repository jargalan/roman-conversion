package com.adobe.romanconversion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdobeResponse<T> {
    boolean success;
    T response;
    AdobeErrorResponse error;

    public AdobeResponse(final T response) {
        this.success = true;
        this.error = null;
        this.response = response;
    }
}
