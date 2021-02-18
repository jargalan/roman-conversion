package com.adobe.romanconversion.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class AdobeErrorResponse implements Serializable {
    private String code;
    private String message;
    private String errorDetail;

    public AdobeErrorResponse(String code, String message, String errorDetail) {
        this.code = code;
        this.message = message;
        this.errorDetail = errorDetail;
    }
}
