package com.adobe.romanconversion.service;

import com.adobe.romanconversion.model.RomanNumeral;
import com.adobe.romanconversion.util.RomanNumeralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RomanNumeralService {

    final RomanNumeralUtil romanNumeralUtil;

    public RomanNumeralService(RomanNumeralUtil romanNumeralUtil) {
        this.romanNumeralUtil = romanNumeralUtil;
    }

    public RomanNumeral getRomanNumeral(int num) {
        RomanNumeral romanNumeral = new RomanNumeral(
                String.valueOf(num),
                romanNumeralUtil.convertIntToRoman(num));
        return romanNumeral;
    }
}
