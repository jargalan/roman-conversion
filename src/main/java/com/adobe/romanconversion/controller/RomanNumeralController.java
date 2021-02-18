package com.adobe.romanconversion.controller;

import com.adobe.romanconversion.model.AdobeResponse;
import com.adobe.romanconversion.model.RomanNumeral;
import com.adobe.romanconversion.service.RomanNumeralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
@Slf4j
public class RomanNumeralController {

    final RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    @GetMapping("/romannumeral")
    public AdobeResponse<RomanNumeral> getRomanNumeral(@RequestParam @Min(1) @Max(3999) int query) {
        RomanNumeral romanNumeral = romanNumeralService.getRomanNumeral(query);
        return new AdobeResponse<>(romanNumeral);
    }
}
